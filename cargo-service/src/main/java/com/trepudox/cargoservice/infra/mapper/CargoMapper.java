package com.trepudox.cargoservice.infra.mapper;

import com.trepudox.cargoservice.core.view.CargoView;
import com.trepudox.cargoservice.infra.persistence.model.CargoModel;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.time.LocalDateTime;
import java.util.List;

@Mapper(imports = {LocalDateTime.class})
public interface CargoMapper {

    CargoMapper INSTANCE = Mappers.getMapper(CargoMapper.class);

    CargoModel cargoViewToCargoModel(CargoView cargoView);

    CargoView cargoModelToCargoView(CargoModel cargoModel);

    List<CargoView> cargoModelListToCargoViewList(List<CargoModel> cargoModelList);
}
