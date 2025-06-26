package com.trepudox.cargoservice.adapter.out;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.core.Message;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Slf4j
@Component
@RequiredArgsConstructor
public class CargoRabbitDlqProducer {

    private final RabbitTemplate rabbitTemplate;

    @Value("${rabbitmq.producer.exchange}")
    private String exchange;

    @Value("${rabbitmq.producer.routing-key}")
    private String routingKey;

    public void sendMessage(Message message) {
        log.info("Sending message to the exchange '{}' with following routing key {}. Message: {}", exchange, routingKey, new String(message.getBody()));
        rabbitTemplate.send(exchange, routingKey, message);
        log.info("Message sent successfully.");

    }

}
