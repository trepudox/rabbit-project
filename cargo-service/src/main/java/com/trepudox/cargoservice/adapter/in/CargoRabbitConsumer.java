package com.trepudox.cargoservice.adapter.in;

import com.rabbitmq.client.Channel;
import com.trepudox.cargoservice.core.dto.CargoDTO;
import com.trepudox.cargoservice.core.port.in.CargoInputPort;
import com.trepudox.cargoservice.infra.mapper.JsonMapper;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.amqp.support.AmqpHeaders;
import org.springframework.messaging.handler.annotation.Header;
import org.springframework.stereotype.Component;

import java.io.IOException;

@Slf4j
@Component
@RequiredArgsConstructor
public class CargoRabbitConsumer {

    private final JsonMapper jsonMapper;
    private final CargoInputPort cargoInputPort;

    // TODO: tratamento de exceção jogando na DLQ
    @RabbitListener(queues = {"${rabbitmq.queue.name}"})
    public void receiveMessage(String messageContent,
                               @Header(name = "action") String actionHeader,
                               @Header(AmqpHeaders.DELIVERY_TAG) long deliveryTag,
                               Channel channel) throws IOException {
        log.info("Delivery Tag : {} - ActionHeader: {} - Message: {}", deliveryTag, actionHeader, messageContent);

        try {
            CargoDTO cargoDTO = jsonMapper.fromJson(messageContent, CargoDTO.class);
            processMessage(actionHeader, cargoDTO);
            channel.basicAck(deliveryTag, false);

            log.info("Message with delivery tag '{}' was processed and acknowledged successfully", deliveryTag);
        } catch (Exception e) {
            log.error("It wasn't possible to process this message - Delivery tag: {} - Error: {}", deliveryTag, e.toString());
            channel.basicReject(deliveryTag, false);
            log.warn("The message was rejected");
        }

    }

    private void processMessage(String action, CargoDTO cargoDTO) {
        switch (action.toLowerCase()) {
            case "create" -> cargoInputPort.create(cargoDTO);
            case "update" -> cargoInputPort.update(cargoDTO);
            case "delete" -> cargoInputPort.deleteById(cargoDTO.getId());
            default -> throw new IllegalArgumentException("No action defined for '%s'".formatted(action));
        }
    }

}
