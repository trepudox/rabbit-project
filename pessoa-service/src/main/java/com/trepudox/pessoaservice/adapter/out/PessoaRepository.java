package com.trepudox.pessoaservice.adapter.out;

import com.trepudox.pessoaservice.core.port.out.DatabaseOutputPort;
import com.trepudox.pessoaservice.infra.persistence.model.PessoaModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PessoaRepository extends JpaRepository<PessoaModel, Long>, DatabaseOutputPort {
}
