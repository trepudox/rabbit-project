package com.trepudox.cargoservice.core.port.in;

import com.trepudox.cargoservice.core.view.CargoView;

import java.util.List;

public interface CargoInputPort {

    CargoView create(CargoView cargoView);

    CargoView getById(Long id);

    List<CargoView> getAll();

    CargoView update(CargoView cargoView);

    void deleteById(Long id);

}
