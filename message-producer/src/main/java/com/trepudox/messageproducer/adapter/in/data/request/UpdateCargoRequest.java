package com.trepudox.messageproducer.adapter.in.data.request;

import lombok.Data;

@Data
public class UpdateCargoRequest {

    private Long id;
    private String funcao;
    private String descricao;

}
