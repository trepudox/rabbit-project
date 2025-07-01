package com.trepudox.bff.core.data.response;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class CargoResponse {

    private Long id;
    private String funcao;
    private String descricao;

}
