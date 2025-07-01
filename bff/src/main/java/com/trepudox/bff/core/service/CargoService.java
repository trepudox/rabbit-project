package com.trepudox.bff.core.service;

import com.trepudox.bff.core.data.request.CreateCargoRequest;
import com.trepudox.bff.core.data.request.UpdateCargoRequest;
import com.trepudox.bff.core.data.response.CargoResponse;

import java.util.List;

public interface CargoService {

    CargoResponse create(CreateCargoRequest createCargoRequest);

    List<CargoResponse> getAll();

    CargoResponse getById(long id);

    CargoResponse update(UpdateCargoRequest updateCargoRequest);

    void deleteById(Long id);

}
