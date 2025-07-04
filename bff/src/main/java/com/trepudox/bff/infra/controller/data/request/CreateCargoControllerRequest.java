package com.trepudox.bff.infra.controller.data.request;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class CreateCargoControllerRequest {

    private String funcao;
    private String descricao;

}
