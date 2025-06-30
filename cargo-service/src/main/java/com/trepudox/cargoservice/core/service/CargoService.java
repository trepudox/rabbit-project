package com.trepudox.cargoservice.core.service;

import com.trepudox.cargoservice.core.port.in.CargoInputPort;
import com.trepudox.cargoservice.core.view.CargoView;
import com.trepudox.cargoservice.core.exception.EntityNotFoundException;
import com.trepudox.cargoservice.core.port.out.DatabaseOutputPort;

import java.util.List;
import java.util.Optional;

public class CargoService implements CargoInputPort {

    public CargoService(DatabaseOutputPort databaseOutputPort) {
        this.databaseOutputPort = databaseOutputPort;
    }

    private final DatabaseOutputPort databaseOutputPort;

    @Override
    public CargoView create(CargoView cargoView) {
        return databaseOutputPort.save(cargoView);
    }

    @Override
    public List<CargoView> getAll() {
        return databaseOutputPort.getAll();
    }

    @Override
    public CargoView getById(Long id) {
        Optional<CargoView> cargoDTOOptional = databaseOutputPort.getById(id);

        return cargoDTOOptional
                .orElseThrow(() -> new EntityNotFoundException("Cargo com id %d não encontrado".formatted(id)));
    }

    @Override
    public CargoView update(CargoView cargoView) {
        final Long cargoId = cargoView.getId();

        if (databaseOutputPort.getById(cargoId).isPresent()) {
            return databaseOutputPort.save(cargoView);
        } else {
            throw new EntityNotFoundException("Pessoa com id %d não encontrado".formatted(cargoId));
        }
    }

    @Override
    public void deleteById(Long id) {
        databaseOutputPort.deleteById(id);
    }

}
