package com.trepudox.cargoservice.core.port.out;

import com.trepudox.cargoservice.core.view.CargoView;

import java.util.List;
import java.util.Optional;

public interface DatabaseOutputPort {

    CargoView save(CargoView cargoView);

    List<CargoView> getAll();

    Optional<CargoView> getById(Long id);

    void deleteById(Long id);

}
