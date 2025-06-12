package com.trepudox.cargoservice.adapter.out;

import com.trepudox.cargoservice.core.port.out.DatabaseOutputPort;
import com.trepudox.cargoservice.infra.persistence.model.CargoModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CargoRepository extends JpaRepository<CargoModel, Long>, DatabaseOutputPort {
}
