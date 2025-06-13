package com.trepudox.pessoaservice.infra.persistence.repository;

import com.trepudox.pessoaservice.infra.persistence.model.PessoaModel;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PessoaRepository extends JpaRepository<PessoaModel, Long> {
}
