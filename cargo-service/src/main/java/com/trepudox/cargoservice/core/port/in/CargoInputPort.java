package com.trepudox.cargoservice.core.port.in;

import com.trepudox.cargoservice.core.dto.CargoDTO;

import java.util.List;

public interface CargoInputPort {

    CargoDTO create(CargoDTO cargoDTO);

    CargoDTO getById(Long id);

    List<CargoDTO> getAll();

    CargoDTO update(CargoDTO cargoDTO);

    void deleteById(Long id);

}
