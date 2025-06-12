package com.trepudox.cargoservice.infra.persistence.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Table(name = "Cargo")
@Data
public class CargoModel {

    @Id
    private Long id;

    private String funcao;

    private String descricao;

}
