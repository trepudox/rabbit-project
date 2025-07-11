package com.trepudox.bff.infra.webclient.data.request;

import lombok.Data;

@Data
public class CreateCargoRestClientRequest {

    private String funcao;
    private String descricao;

}
