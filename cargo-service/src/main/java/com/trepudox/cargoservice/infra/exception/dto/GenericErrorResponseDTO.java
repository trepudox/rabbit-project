package com.trepudox.cargoservice.infra.exception.dto;

import lombok.Builder;
import lombok.Data;

import java.time.LocalDateTime;

@Data
@Builder
public class GenericErrorResponseDTO {

    private String error;
    private String detail;
    private LocalDateTime timestamp;

}
