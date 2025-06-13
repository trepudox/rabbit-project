package com.trepudox.pessoaservice.core.service;

import com.trepudox.pessoaservice.core.dto.PessoaDTO;
import com.trepudox.pessoaservice.core.port.in.PessoaInputPort;
import com.trepudox.pessoaservice.core.port.out.DatabaseOutputPort;

import java.util.Optional;

public class PessoaService implements PessoaInputPort {

    public PessoaService(DatabaseOutputPort databaseOutputPort) {
        this.databaseOutputPort = databaseOutputPort;
    }

    private final DatabaseOutputPort databaseOutputPort;

    public PessoaDTO getById(Long id) {
        Optional<PessoaDTO> pessoaDTOOptional = databaseOutputPort.getById(id);

        // TODO: criar uma exception personalizada
        return pessoaDTOOptional.orElseThrow(RuntimeException::new);
    }

}
