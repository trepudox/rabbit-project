package com.trepudox.messageproducer.adapter.in;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/cargo")
@RequiredArgsConstructor
public class CargoController {

    @PostMapping
    public ResponseEntity<?> create() {
        return null;
    }

    @PutMapping
    public ResponseEntity<?> update() {
        return null;
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteById(@PathVariable long id) {
        return null;
    }
}
