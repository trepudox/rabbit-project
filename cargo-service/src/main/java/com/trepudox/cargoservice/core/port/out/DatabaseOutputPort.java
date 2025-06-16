package com.trepudox.cargoservice.core.port.out;

import com.trepudox.cargoservice.core.dto.CargoDTO;

import java.util.List;
import java.util.Optional;

public interface DatabaseOutputPort {

    CargoDTO save(CargoDTO cargoDTO);

    List<CargoDTO> getAll();

    Optional<CargoDTO> getById(Long id);

    void deleteById(Long id);

}
