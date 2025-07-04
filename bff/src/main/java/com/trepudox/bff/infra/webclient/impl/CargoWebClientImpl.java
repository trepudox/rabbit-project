package com.trepudox.bff.infra.webclient.impl;

import com.trepudox.bff.core.dto.CargoDTO;
import com.trepudox.bff.infra.mapper.CargoInfraMapper;
import com.trepudox.bff.infra.webclient.CargoWebClient;
import com.trepudox.bff.infra.webclient.data.response.CargoRestResponse;
import com.trepudox.bff.infra.webclient.restclient.CargoRestClient;
import jakarta.enterprise.context.ApplicationScoped;
import lombok.RequiredArgsConstructor;
import org.eclipse.microprofile.rest.client.inject.RestClient;
import org.jboss.resteasy.reactive.RestResponse;

import java.util.List;

@ApplicationScoped
@RequiredArgsConstructor
public class CargoWebClientImpl implements CargoWebClient {

    @RestClient
    private CargoRestClient cargoRestClient;

    @Override
    public void create() {
        // TODO: quando criar o message producer
    }

    @Override
    public List<CargoDTO> getAll() {
        RestResponse<List<CargoRestResponse>> response = cargoRestClient.getAll();
        List<CargoRestResponse> body = response.getEntity();

        return CargoInfraMapper.INSTANCE.cargoRestResponseListToCargoDTOList(body);
    }

    @Override
    public CargoDTO getById(long id) {
        return null;
    }

    @Override
    public void update() {
        // TODO: quando criar o message producer
    }

    @Override
    public void delete(long id) {
        // TODO: quando criar o message producer
    }
}
