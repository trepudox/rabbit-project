package com.trepudox.bff.infra.webclient.data.response;

import lombok.Data;

@Data
public class CargoRestClientResponse {

    private Long id;
    private String funcao;
    private String descricao;

}
