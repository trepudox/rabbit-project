package com.trepudox.cargoservice.infra.mapper;

import com.trepudox.cargoservice.core.dto.CargoDTO;
import com.trepudox.cargoservice.infra.persistence.model.CargoModel;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.time.LocalDateTime;
import java.util.List;

@Mapper(imports = {LocalDateTime.class})
public interface CargoMapper {

    CargoMapper INSTANCE = Mappers.getMapper(CargoMapper.class);

    CargoModel cargoDTOToCargoModel(CargoDTO cargoDTO);

    CargoDTO cargoModelToCargoDTO(CargoModel cargoModel);

    List<CargoDTO> cargoModelListToCargoDTOList(List<CargoModel> cargoModelList);
}
