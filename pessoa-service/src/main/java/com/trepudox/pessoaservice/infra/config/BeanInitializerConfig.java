package com.trepudox.pessoaservice.infra.config;

import com.trepudox.pessoaservice.core.port.out.DatabaseOutputPort;
import com.trepudox.pessoaservice.core.service.PessoaService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class BeanInitializerConfig {

    @Bean
    public PessoaService pessoaService(DatabaseOutputPort databaseOutputPort) {
        return new PessoaService(databaseOutputPort);
    }

}
