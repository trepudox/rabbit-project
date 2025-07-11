package com.trepudox.bff.infra.webclient.data.request;

import lombok.Data;

@Data
public class UpdateCargoRestClientRequest {

    private Long id;
    private String funcao;
    private String descricao;

}
