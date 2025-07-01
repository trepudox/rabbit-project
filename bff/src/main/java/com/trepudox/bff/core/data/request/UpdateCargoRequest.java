package com.trepudox.bff.core.data.request;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class UpdateCargoRequest {

    private Long id;
    private String funcao;
    private String descricao;

}
