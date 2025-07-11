package com.trepudox.bff.infra.webclient;

import com.trepudox.bff.core.dto.CargoDTO;

import java.util.List;

public interface CargoWebClient {

    List<CargoDTO> getAll();

    CargoDTO getById(long id);

}
