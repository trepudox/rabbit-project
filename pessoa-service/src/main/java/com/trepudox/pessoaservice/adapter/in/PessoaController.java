package com.trepudox.pessoaservice.adapter.in;

import com.trepudox.pessoaservice.core.dto.PessoaDTO;
import com.trepudox.pessoaservice.core.port.in.PessoaInputPort;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/pessoa")
@RequiredArgsConstructor
public class PessoaController {

    private final PessoaInputPort pessoaInputPort;

    @GetMapping("/")
    public ResponseEntity<List<PessoaDTO>> getAll() {
        List<PessoaDTO> pessoaDTOList = pessoaInputPort.getAll();

        return ResponseEntity.status(200).body(pessoaDTOList);
    }

    @GetMapping("/{id}")
    public ResponseEntity<PessoaDTO> getById(@PathVariable Long id) {
        PessoaDTO pessoaDTO = pessoaInputPort.getById(id);

        return ResponseEntity.status(200).body(pessoaDTO);
    }

}
