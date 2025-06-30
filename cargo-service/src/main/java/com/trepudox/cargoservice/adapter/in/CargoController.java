package com.trepudox.cargoservice.adapter.in;

import com.trepudox.cargoservice.core.view.CargoView;
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
    public ResponseEntity<List<CargoView>> getAll() {
        List<CargoView> pessoaDTOList = cargoInputPort.getAll();

        return ResponseEntity.status(200).body(pessoaDTOList);
    }

    @GetMapping("/{id}")
    public ResponseEntity<CargoView> getById(@PathVariable Long id) {
        CargoView pessoaDTO = cargoInputPort.getById(id);

        return ResponseEntity.status(200).body(pessoaDTO);
    }

}
