package com.trepudox.bff.infra.mapper;

import com.trepudox.bff.core.dto.CargoDTO;
import com.trepudox.bff.infra.webclient.data.response.CargoRestClientResponse;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper
public interface CargoInfraMapper {

    CargoInfraMapper INSTANCE = Mappers.getMapper(CargoInfraMapper.class);

    CargoDTO cargoRestClientResponseToCargoDTO(CargoRestClientResponse cargoRestClientResponse);

    List<CargoDTO> cargoRestClientResponseListToCargoDTOList(List<CargoRestClientResponse> cargoRestClientResponseList);

}
