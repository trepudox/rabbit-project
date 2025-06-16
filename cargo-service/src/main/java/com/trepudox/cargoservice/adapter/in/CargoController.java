package com.trepudox.cargoservice.adapter.in;

import com.trepudox.cargoservice.core.dto.CargoDTO;
import com.trepudox.cargoservice.core.port.in.CargoInputPort;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/cargo")
@RequiredArgsConstructor
public class CargoController {

    private final CargoInputPort cargoInputPort;

    @GetMapping("/")
    public ResponseEntity<List<CargoDTO>> getAll() {
        List<CargoDTO> pessoaDTOList = cargoInputPort.getAll();

        return ResponseEntity.status(200).body(pessoaDTOList);
    }

    @GetMapping("/{id}")
    public ResponseEntity<CargoDTO> getById(@PathVariable Long id) {
        CargoDTO pessoaDTO = cargoInputPort.getById(id);

        return ResponseEntity.status(200).body(pessoaDTO);
    }

}
