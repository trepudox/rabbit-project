package com.trepudox.bff.infra.controller.data.response;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class CargoControllerResponse {

    private Long id;
    private String funcao;
    private String descricao;

}
