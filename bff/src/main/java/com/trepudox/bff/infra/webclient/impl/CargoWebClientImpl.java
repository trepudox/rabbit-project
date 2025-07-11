package com.trepudox.bff.infra.webclient.impl;

import com.trepudox.bff.core.dto.CargoDTO;
import com.trepudox.bff.infra.mapper.CargoInfraMapper;
import com.trepudox.bff.infra.webclient.CargoWebClient;
import com.trepudox.bff.infra.webclient.data.response.CargoRestClientResponse;
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
    public List<CargoDTO> getAll() {
        RestResponse<List<CargoRestClientResponse>> response = cargoRestClient.getAll();
        List<CargoRestClientResponse> body = response.getEntity();

        return CargoInfraMapper.INSTANCE.cargoRestClientResponseListToCargoDTOList(body);
    }

    @Override
    public CargoDTO getById(long id) {
        RestResponse<CargoRestClientResponse> response = cargoRestClient.getById(id);
        CargoRestClientResponse body = response.getEntity();

        return CargoInfraMapper.INSTANCE.cargoRestClientResponseToCargoDTO(body);
    }

}
