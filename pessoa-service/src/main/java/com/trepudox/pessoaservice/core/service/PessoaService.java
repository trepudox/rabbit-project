package com.trepudox.pessoaservice.core.service;

import com.trepudox.pessoaservice.core.dto.PessoaDTO;
import com.trepudox.pessoaservice.core.exception.EntityNotFoundException;
import com.trepudox.pessoaservice.core.port.in.PessoaInputPort;
import com.trepudox.pessoaservice.core.port.out.DatabaseOutputPort;

import java.util.List;
import java.util.Optional;

public class PessoaService implements PessoaInputPort {

    public PessoaService(DatabaseOutputPort databaseOutputPort) {
        this.databaseOutputPort = databaseOutputPort;
    }

    private final DatabaseOutputPort databaseOutputPort;

    @Override
    public PessoaDTO create(PessoaDTO pessoaDTO) {
        return databaseOutputPort.save(pessoaDTO);
    }

    @Override
    public List<PessoaDTO> getAll() {
        return databaseOutputPort.getAll();
    }

    @Override
    public PessoaDTO getById(Long id) {
        Optional<PessoaDTO> pessoaDTOOptional = databaseOutputPort.getById(id);

        return pessoaDTOOptional
                .orElseThrow(() -> new EntityNotFoundException("Pessoa com id %d não encontrada".formatted(id)));
    }

    @Override
    public PessoaDTO update(PessoaDTO pessoaDTO) {
        final Long pessoaId = pessoaDTO.getId();

        if (databaseOutputPort.getById(pessoaId).isPresent()) {
            return databaseOutputPort.save(pessoaDTO);
        } else {
            throw new EntityNotFoundException("Pessoa com id %d não encontrada".formatted(pessoaId));
        }
    }

    @Override
    public void deleteById(Long id) {
        databaseOutputPort.deleteById(id);
    }

}
