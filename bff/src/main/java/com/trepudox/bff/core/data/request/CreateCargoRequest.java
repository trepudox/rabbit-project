package com.trepudox.bff.core.data.request;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class CreateCargoRequest {

    private String funcao;
    private String descricao;

}
