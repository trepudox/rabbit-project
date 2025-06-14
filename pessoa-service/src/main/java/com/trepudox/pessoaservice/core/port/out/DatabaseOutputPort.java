package com.trepudox.pessoaservice.core.port.out;

import com.trepudox.pessoaservice.core.dto.PessoaDTO;

import java.util.List;
import java.util.Optional;

public interface DatabaseOutputPort {

    PessoaDTO save(PessoaDTO pessoaDTO);

    List<PessoaDTO> getAll();

    Optional<PessoaDTO> getById(Long id);

    void deleteById(Long id);

}
