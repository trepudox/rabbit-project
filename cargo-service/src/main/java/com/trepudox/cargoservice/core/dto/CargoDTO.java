package com.trepudox.cargoservice.core.dto;

public class CargoDTO {

    private Long id;
    private String funcao;
    private String descricao;

    public CargoDTO() {}

    public CargoDTO(Long id, String funcao, String descricao) {
        this.id = id;
        this.funcao = funcao;
        this.descricao = descricao;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getFuncao() {
        return funcao;
    }

    public void setFuncao(String funcao) {
        this.funcao = funcao;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }
}
