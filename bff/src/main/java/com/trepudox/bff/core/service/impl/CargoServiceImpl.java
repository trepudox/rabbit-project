package com.trepudox.bff.core.service.impl;

import com.trepudox.bff.core.dto.CargoDTO;
import com.trepudox.bff.core.mapper.CargoCoreMapper;
import com.trepudox.bff.infra.controller.data.request.CreateCargoControllerRequest;
import com.trepudox.bff.infra.controller.data.request.UpdateCargoControllerRequest;
import com.trepudox.bff.infra.controller.data.response.CargoControllerResponse;
import com.trepudox.bff.core.service.CargoService;
import com.trepudox.bff.infra.webclient.impl.CargoWebClientImpl;
import jakarta.enterprise.context.ApplicationScoped;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import java.util.List;

@Slf4j
@ApplicationScoped
@RequiredArgsConstructor
public class CargoServiceImpl implements CargoService {

    private final CargoWebClientImpl cargoWebclient;

    @Override
    public CargoControllerResponse create(CreateCargoControllerRequest createCargoControllerRequest) {
        return new CargoControllerResponse(1L, "Java Developer", "A crazy man");
    }

    @Override
    public List<CargoControllerResponse> getAll() {
        List<CargoDTO> cargoDTOList = cargoWebclient.getAll();
        return CargoCoreMapper.INSTANCE.cargoDTOListToCargoControllerResponseList(cargoDTOList);
    }

    @Override
    public CargoControllerResponse getById(long id) {
        CargoDTO cargoDTO = cargoWebclient.getById(id);
        return CargoCoreMapper.INSTANCE.cargoDTOToCargoControllerResponse(cargoDTO);
    }

    @Override
    public CargoControllerResponse update(UpdateCargoControllerRequest updateCargoControllerRequest) {
        return new CargoControllerResponse(1L, "Java Developer", "A crazy man");
    }

    @Override
    public void deleteById(Long id) {
        // :p
    }
}
