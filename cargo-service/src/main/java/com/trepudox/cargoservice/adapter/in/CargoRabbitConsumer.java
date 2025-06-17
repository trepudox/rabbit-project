package com.trepudox.cargoservice.adapter.in;

import com.trepudox.cargoservice.core.dto.CargoDTO;
import com.trepudox.cargoservice.core.port.in.CargoInputPort;
import com.trepudox.cargoservice.infra.mapper.JsonMapper;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.messaging.handler.annotation.Header;
import org.springframework.stereotype.Component;

@Slf4j
@Component
@RequiredArgsConstructor
public class CargoRabbitConsumer {

    private final JsonMapper jsonMapper;
    private final CargoInputPort cargoInputPort;

    // TODO: tratamento de exceção jogando na DLQ, criar um metodo separado pro case default do switch case
    @RabbitListener(queues = {"${rabbitmq.queue.name}"})
    public void receiveMessage(String messageContent,
                        @Header(name = "action") String actionHeader) {
        log.info("ActionHeader: {} - Message: {}", actionHeader, messageContent);

        CargoDTO cargoDTO = jsonMapper.fromJson(messageContent, CargoDTO.class);

        switch (actionHeader.toLowerCase()) {
            case "create" -> cargoInputPort.create(cargoDTO);
            case "update" -> cargoInputPort.update(cargoDTO);
            case "delete" -> cargoInputPort.deleteById(cargoDTO.getId());
            default -> throw new IllegalArgumentException("No action defined for '%s'".formatted(actionHeader));
        }
    }

}
