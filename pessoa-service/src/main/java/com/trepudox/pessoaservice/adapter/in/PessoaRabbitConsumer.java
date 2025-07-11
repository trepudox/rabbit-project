package com.trepudox.pessoaservice.adapter.in;

import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.messaging.handler.annotation.Header;
import org.springframework.stereotype.Component;

@Slf4j
@Component
public class PessoaRabbitConsumer {

    @RabbitListener(queues = {"${rabbitmq.queue.name}"})
    public void receive(String messageContent,
                        @Header(name = "action") String actionHeader) {
        log.info("Message {}", messageContent);
        log.info("ActionHeader {}", actionHeader);
    }

}
