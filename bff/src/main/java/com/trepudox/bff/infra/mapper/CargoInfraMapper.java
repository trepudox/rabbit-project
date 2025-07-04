package com.trepudox.bff.infra.mapper;

import com.trepudox.bff.core.dto.CargoDTO;
import com.trepudox.bff.infra.webclient.data.response.CargoRestResponse;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper
public interface CargoInfraMapper {

    CargoInfraMapper INSTANCE = Mappers.getMapper(CargoInfraMapper.class);

    CargoDTO cargoRestResponseToCargoDTO(CargoRestResponse cargoRestResponse);

    List<CargoDTO> cargoRestResponseListToCargoDTOList(List<CargoRestResponse> cargoRestResponseList);

}
