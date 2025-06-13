package com.trepudox.pessoaservice.adapter.out;

import com.trepudox.pessoaservice.core.dto.PessoaDTO;
import com.trepudox.pessoaservice.core.port.out.DatabaseOutputPort;

import com.trepudox.pessoaservice.infra.persistence.repository.PessoaRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

@Component
@RequiredArgsConstructor
public class PessoaRepositoryAdapater implements DatabaseOutputPort {

    private final PessoaRepository pessoaRepository;

    @Override
    public List<PessoaDTO> getAll() {
        // TODO
        return List.of();
    }

    @Override
    public Optional<PessoaDTO> getById(Long id) {
        // TODO
        return Optional.empty();
    }
}
