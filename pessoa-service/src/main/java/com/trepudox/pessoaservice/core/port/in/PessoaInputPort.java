package com.trepudox.pessoaservice.core.port.in;

import com.trepudox.pessoaservice.core.dto.PessoaDTO;

import java.util.List;

public interface PessoaInputPort {

    PessoaDTO create(PessoaDTO pessoaDTO);

    PessoaDTO getById(Long id);

    List<PessoaDTO> getAll();

    PessoaDTO update(PessoaDTO pessoaDTO);

    void deleteById(Long id);

}
