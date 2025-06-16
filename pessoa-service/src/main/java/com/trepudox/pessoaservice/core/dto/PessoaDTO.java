package com.trepudox.pessoaservice.core.dto;

import java.time.LocalDate;

public class PessoaDTO {

    private Long id;
    private String nome;
    private LocalDate dataNascimento;
    private Long cargoId;

    public PessoaDTO() {}

    public PessoaDTO(Long id, String nome, LocalDate dataNascimento, Long cargoId) {
        this.id = id;
        this.nome = nome;
        this.dataNascimento = dataNascimento;
        this.cargoId = cargoId;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public LocalDate getDataNascimento() {
        return dataNascimento;
    }

    public void setDataNascimento(LocalDate dataNascimento) {
        this.dataNascimento = dataNascimento;
    }

    public Long getCargoId() {
        return cargoId;
    }

    public void setCargoId(Long cargoId) {
        this.cargoId = cargoId;
    }
}
