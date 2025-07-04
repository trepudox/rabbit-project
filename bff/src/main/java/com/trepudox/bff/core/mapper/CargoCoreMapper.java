package com.trepudox.bff.core.mapper;

import com.trepudox.bff.core.dto.CargoDTO;
import com.trepudox.bff.infra.controller.data.response.CargoControllerResponse;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper
public interface CargoCoreMapper {

    CargoCoreMapper INSTANCE = Mappers.getMapper(CargoCoreMapper.class);

    CargoControllerResponse cargoDTOToCargoControllerResponse(CargoDTO cargoDTO);

    List<CargoControllerResponse> cargoDTOListToCargoControllerResponseList(List<CargoDTO> cargoDTOList);

}
