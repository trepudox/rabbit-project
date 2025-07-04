package com.trepudox.bff.core.service;

import com.trepudox.bff.infra.controller.data.request.CreateCargoControllerRequest;
import com.trepudox.bff.infra.controller.data.request.UpdateCargoControllerRequest;
import com.trepudox.bff.infra.controller.data.response.CargoControllerResponse;

import java.util.List;

public interface CargoService {

    CargoControllerResponse create(CreateCargoControllerRequest createCargoControllerRequest);

    List<CargoControllerResponse> getAll();

    CargoControllerResponse getById(long id);

    CargoControllerResponse update(UpdateCargoControllerRequest updateCargoControllerRequest);

    void deleteById(Long id);

}
