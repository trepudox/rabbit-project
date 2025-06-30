package com.trepudox.cargoservice.config;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.trepudox.cargoservice.core.port.out.DatabaseOutputPort;
import com.trepudox.cargoservice.core.service.CargoService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class GenericBeanInitializerConfig {

    @Bean
    public CargoService cargoService(DatabaseOutputPort databaseOutputPort) {
        return new CargoService(databaseOutputPort);
    }

    @Bean
    public Gson gson() {
        return new GsonBuilder()
                .create();
    }

}
