package com.trepudox.messageproducer.adapter.in;

import com.trepudox.messageproducer.adapter.in.data.request.CreateCargoRequest;
import com.trepudox.messageproducer.adapter.in.data.request.UpdateCargoRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/cargo")
@RequiredArgsConstructor
public class CargoController {

    @PostMapping
    public ResponseEntity<?> create(@RequestBody CreateCargoRequest createCargoRequest) {
        return null;
    }

    @PutMapping
    public ResponseEntity<?> update(@RequestBody UpdateCargoRequest updateCargoRequest) {
        return null;
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteById(@PathVariable long id) {
        return null;
    }
}
