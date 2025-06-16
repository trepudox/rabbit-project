package com.trepudox.cargoservice.adapter.out;

import com.trepudox.cargoservice.core.dto.CargoDTO;
import com.trepudox.cargoservice.core.port.out.DatabaseOutputPort;

import com.trepudox.cargoservice.infra.mapper.CargoMapper;
import com.trepudox.cargoservice.infra.persistence.model.CargoModel;
import com.trepudox.cargoservice.infra.persistence.repository.CargoRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

@Component
@RequiredArgsConstructor
public class CargoRepositoryAdapater implements DatabaseOutputPort {

    private final CargoRepository cargoRepository;

    @Override
    public CargoDTO save(CargoDTO cargoDTO) {
        CargoModel cargoModel = CargoMapper.INSTANCE.cargoDTOToCargoModel(cargoDTO);
        cargoModel = cargoRepository.save(cargoModel);

        return CargoMapper.INSTANCE.cargoModelToCargoDTO(cargoModel);
    }

    @Override
    public List<CargoDTO> getAll() {
        return CargoMapper.INSTANCE.cargoModelListToCargoDTOList(cargoRepository.findAll());
    }

    @Override
    public Optional<CargoDTO> getById(Long id) {
        Optional<CargoModel> pessoaModelOptional = cargoRepository.findById(id);

        if (pessoaModelOptional.isPresent()) {
            CargoDTO cargoDTO = CargoMapper.INSTANCE.cargoModelToCargoDTO(pessoaModelOptional.get());
            return Optional.of(cargoDTO);
        }

        return Optional.empty();
    }

    @Override
    public void deleteById(Long id) {
        cargoRepository.deleteById(id);
    }
}
