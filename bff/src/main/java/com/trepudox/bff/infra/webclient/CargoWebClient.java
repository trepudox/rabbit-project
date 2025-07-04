package com.trepudox.bff.infra.webclient;

import com.trepudox.bff.core.dto.CargoDTO;

import java.util.List;

public interface CargoWebClient {

    void create();

    List<CargoDTO> getAll();

    CargoDTO getById(long id);

    void update();

    void delete(long id);

}
