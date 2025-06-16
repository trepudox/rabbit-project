package com.trepudox.cargoservice.infra.config;

import com.trepudox.cargoservice.core.port.out.DatabaseOutputPort;
import com.trepudox.cargoservice.core.service.CargoService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class BeanInitializerConfig {

    @Bean
    public CargoService cargoService(DatabaseOutputPort databaseOutputPort) {
        return new CargoService(databaseOutputPort);
    }

}
