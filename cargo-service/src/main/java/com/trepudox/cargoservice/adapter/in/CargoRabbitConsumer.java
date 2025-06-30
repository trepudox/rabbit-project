package com.trepudox.cargoservice.adapter.in;

import com.rabbitmq.client.Channel;
import com.trepudox.cargoservice.adapter.out.CargoRabbitDlqProducer;
import com.trepudox.cargoservice.core.view.CargoView;
import com.trepudox.cargoservice.core.port.in.CargoInputPort;
import com.trepudox.cargoservice.infra.mapper.JsonMapper;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.core.Message;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

import java.io.IOException;

@Slf4j
@Component
@RequiredArgsConstructor
public class CargoRabbitConsumer {

    private final JsonMapper jsonMapper;
    private final CargoInputPort cargoInputPort;
    private final CargoRabbitDlqProducer cargoRabbitDlqProducer;

    @RabbitListener(queues = {"${rabbitmq.consumer.queue.name}"})
    public void receiveMessage(Message message, Channel channel) throws IOException {
        long deliveryTag = message.getMessageProperties().getDeliveryTag();
        String actionHeader = message.getMessageProperties().getHeader("action");
        String messageContent = new String(message.getBody());

        log.info("Delivery Tag : {} - ActionHeader: {} - Message: {}", deliveryTag, actionHeader, messageContent);

        try {
            CargoView cargoView = jsonMapper.fromJson(messageContent, CargoView.class);
            processMessage(actionHeader, cargoView);
            channel.basicAck(deliveryTag, false);

            log.info("Message with delivery tag '{}' was processed and acknowledged successfully", deliveryTag);
        } catch (Exception e) {
            log.error("It wasn't possible to process this message - Delivery tag: {} - Error: {}", deliveryTag, e.toString());
            sendMessageToDLQ(message, channel, deliveryTag);
            log.warn("The message was rejected");
        }
    }

    private void processMessage(String action, CargoView cargoView) {
        switch (action.toLowerCase()) {
            case "create" -> cargoInputPort.create(cargoView);
            case "update" -> cargoInputPort.update(cargoView);
            case "delete" -> cargoInputPort.deleteById(cargoView.getId());
            default -> throw new IllegalArgumentException("No action defined for '%s'".formatted(action));
        }
    }

    private void sendMessageToDLQ(Message message, Channel channel, long deliveryTag) throws IOException {
        try {
            cargoRabbitDlqProducer.sendMessage(message);
            log.info("The message was sent to the DLQ.");
            channel.basicReject(deliveryTag, false);
        } catch(Exception e) {
            log.info("It wasn't possible to send this message to the DLQ. Requeuing...");
            channel.basicReject(deliveryTag, true);
        }
    }
}
