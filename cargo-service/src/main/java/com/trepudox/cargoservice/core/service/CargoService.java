package com.trepudox.cargoservice.core.service;

import com.trepudox.cargoservice.core.port.in.CargoInputPort;
import com.trepudox.cargoservice.core.dto.CargoDTO;
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
    public CargoDTO create(CargoDTO cargoDTO) {
        return databaseOutputPort.save(cargoDTO);
    }

    @Override
    public List<CargoDTO> getAll() {
        return databaseOutputPort.getAll();
    }

    @Override
    public CargoDTO getById(Long id) {
        Optional<CargoDTO> cargoDTOOptional = databaseOutputPort.getById(id);

        return cargoDTOOptional
                .orElseThrow(() -> new EntityNotFoundException("Cargo com id %d não encontrado".formatted(id)));
    }

    @Override
    public CargoDTO update(CargoDTO cargoDTO) {
        final Long cargoId = cargoDTO.getId();

        if (databaseOutputPort.getById(cargoId).isPresent()) {
            return databaseOutputPort.save(cargoDTO);
        } else {
            throw new EntityNotFoundException("Pessoa com id %d não encontrado".formatted(cargoId));
        }
    }

    @Override
    public void deleteById(Long id) {
        databaseOutputPort.deleteById(id);
    }

}
