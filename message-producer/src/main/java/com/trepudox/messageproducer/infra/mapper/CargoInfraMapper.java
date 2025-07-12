package com.trepudox.messageproducer.infra.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface CargoInfraMapper {

    CargoInfraMapper INSTANCE = Mappers.getMapper(CargoInfraMapper.class);



}
