package com.trepudox.cargoservice.adapter.out;

import com.trepudox.cargoservice.core.view.CargoView;
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
    public CargoView save(CargoView cargoView) {
        CargoModel cargoModel = CargoMapper.INSTANCE.cargoViewToCargoModel(cargoView);
        cargoModel = cargoRepository.save(cargoModel);

        return CargoMapper.INSTANCE.cargoModelToCargoView(cargoModel);
    }

    @Override
    public List<CargoView> getAll() {
        return CargoMapper.INSTANCE.cargoModelListToCargoViewList(cargoRepository.findAll());
    }

    @Override
    public Optional<CargoView> getById(Long id) {
        Optional<CargoModel> pessoaModelOptional = cargoRepository.findById(id);

        if (pessoaModelOptional.isPresent()) {
            CargoView cargoView = CargoMapper.INSTANCE.cargoModelToCargoView(pessoaModelOptional.get());
            return Optional.of(cargoView);
        }

        return Optional.empty();
    }

    @Override
    public void deleteById(Long id) {
        cargoRepository.deleteById(id);
    }
}
