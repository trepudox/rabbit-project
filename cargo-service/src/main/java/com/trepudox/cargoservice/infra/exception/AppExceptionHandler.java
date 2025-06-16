package com.trepudox.cargoservice.infra.exception;

import com.trepudox.cargoservice.core.exception.EntityNotFoundException;
import com.trepudox.cargoservice.infra.exception.dto.GenericErrorResponseDTO;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.time.LocalDateTime;

@RestControllerAdvice
public class AppExceptionHandler extends ResponseEntityExceptionHandler {

    // TODO
    @ExceptionHandler({Exception.class})
    public ResponseEntity<GenericErrorResponseDTO> handleException(Exception e) {
        GenericErrorResponseDTO errorResponse = GenericErrorResponseDTO.builder()
                .error("Error")
                .detail(e.getMessage())
                .timestamp(LocalDateTime.now())
                .build();

        return ResponseEntity.status(400).body(errorResponse);
    }

    @ExceptionHandler({EntityNotFoundException.class})
    public ResponseEntity<GenericErrorResponseDTO> handleEntityNotFoundException(Exception e, WebRequest request) {
        GenericErrorResponseDTO errorResponse = GenericErrorResponseDTO.builder()
                .error("Entity not found")
                .detail(e.getMessage())
                .timestamp(LocalDateTime.now())
                .build();

        return ResponseEntity.status(422).body(errorResponse);
    }

}
