package com.trepudox.bff.infra.controller.data.request;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class UpdateCargoControllerRequest {

    private Long id;
    private String funcao;
    private String descricao;

}
