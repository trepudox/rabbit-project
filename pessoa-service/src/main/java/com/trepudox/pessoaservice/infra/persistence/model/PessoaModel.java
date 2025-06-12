package com.trepudox.pessoaservice.infra.persistence.model;

import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDate;

@Entity
@Table(name = "Pessoa")
@Data
public class PessoaModel {

    @Id
    private Long id;

    private String nome;

    @Column(name = "data_nascimento")
    private LocalDate dataNascimento;

    @Column(name = "cargo_id")
    private Long cargoId;

}
