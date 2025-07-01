package com.trepudox.bff.core.service.impl;

import com.trepudox.bff.core.data.request.CreateCargoRequest;
import com.trepudox.bff.core.data.request.UpdateCargoRequest;
import com.trepudox.bff.core.data.response.CargoResponse;
import com.trepudox.bff.core.service.CargoService;
import com.trepudox.bff.infra.webclient.CargoWebclient;
import jakarta.enterprise.context.ApplicationScoped;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import java.util.List;

@Slf4j
@ApplicationScoped
@RequiredArgsConstructor
public class CargoServiceImpl implements CargoService {

    private final CargoWebclient cargoWebclient;

    @Override
    public CargoResponse create(CreateCargoRequest createCargoRequest) {
        return new CargoResponse(1L, "Java Developer", "A crazy man");
    }

    @Override
    public List<CargoResponse> getAll() {
        return List.of(
                new CargoResponse(1L, "Java Developer", "A crazy man"),
                new CargoResponse(2L, "Fireman", "A cool guy")
        );
    }

    @Override
    public CargoResponse getById(long id) {
        return new CargoResponse(id, "Java Developer", "A crazy man");
    }

    @Override
    public CargoResponse update(UpdateCargoRequest updateCargoRequest) {
        return new CargoResponse(1L, "Java Developer", "A crazy man");
    }

    @Override
    public void deleteById(Long id) {
        // :p
    }
}
