package com.trepudox.cargoservice.infra.persistence.repository;

import com.trepudox.cargoservice.infra.persistence.model.CargoModel;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CargoRepository extends JpaRepository<CargoModel, Long> {
}
