package com.trepudox.cargoservice.infra.mapper;

import com.google.gson.Gson;
import com.google.gson.JsonSyntaxException;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

@Slf4j
@Component
@RequiredArgsConstructor
public class JsonMapper {

    private final Gson gson;

    public <T> T fromJson(String jsonString, Class<T> targetClass) {
        try {
            return gson.fromJson(jsonString, targetClass);
        } catch (JsonSyntaxException e) {
            log.error("Erro ao parsear JSON para {}: {}", targetClass.getSimpleName(), e.getMessage());
            throw new IllegalArgumentException("Invalid JSON format for " + targetClass.getSimpleName(), e);
        }
    }

    public String toJson(Object object) {
        return gson.toJson(object);
    }

}
