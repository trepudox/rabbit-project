package com.trepudox.cargoservice.infra.config;

import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.core.AcknowledgeMode;
import org.springframework.amqp.core.Message;
import org.springframework.amqp.rabbit.config.SimpleRabbitListenerContainerFactory;
import org.springframework.amqp.rabbit.connection.ConnectionFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Slf4j
@Configuration
public class RabbitMQListenerConfig {

    private static final String ACTION_HEADER_NAME = "action";

    @Bean
    public SimpleRabbitListenerContainerFactory rabbitListenerContainerFactory(ConnectionFactory connectionFactory) {
        SimpleRabbitListenerContainerFactory factory = new SimpleRabbitListenerContainerFactory();
        factory.setConnectionFactory(connectionFactory);
        factory.setAcknowledgeMode(AcknowledgeMode.MANUAL);

        // ! essa propriedade faz um metodo rodar após o recebimento da mensagem, antes dela ser processada
        factory.setAfterReceivePostProcessors(this::defaultPostProcess);

        return factory;
    }

    // ! nesse caso, é feita uma checagem no header 'action', se o mesmo vier vazio, a aplicação lança exceção
    // ! antes mesmo da mensagem ser processada, fazendo com que a mensagem nao seja rejeitada e nem enviada pra DLQ
    private Message defaultPostProcess(Message message) {
        if (!message.getMessageProperties().getHeaders().containsKey(ACTION_HEADER_NAME)) {
            log.warn("Message without '{}' header. It will be rejected and sent to the DLQ.", ACTION_HEADER_NAME);
            message.getMessageProperties().getHeaders().put(ACTION_HEADER_NAME, "");
        }

        return message;
    }

}
