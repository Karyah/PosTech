package br.com.fiap.reserva_salas.controller;

import br.com.fiap.reserva_salas.dto.SalaDTO;
import br.com.fiap.reserva_salas.service.SalaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;
import java.util.UUID;

@RestController
@RequestMapping("/sala")
public class SalaController {

    @Autowired
    private SalaService service;

    @GetMapping
    public ResponseEntity<Collection<SalaDTO>> findAll(){
        var salas = service.findAll();
        return ResponseEntity.ok(salas);
    }

    @GetMapping("/{id}")
    public ResponseEntity<SalaDTO> findById(@PathVariable UUID id){
        var sala = service.findById(id);
        return ResponseEntity.ok(sala);
    }

    @PostMapping
    public ResponseEntity<SalaDTO> save(@RequestBody SalaDTO salaDTO){
        salaDTO = service.save(salaDTO);
        return ResponseEntity.status(HttpStatusCode.valueOf(201)).body(salaDTO);
    }

    @PutMapping("/{id}")
    public ResponseEntity<SalaDTO> update(@PathVariable UUID id, @RequestBody SalaDTO salaDTO){
        salaDTO = service.update(id, salaDTO);
        return ResponseEntity.ok(salaDTO);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable UUID id){
        service.delete(id);
        return ResponseEntity.noContent().build();
    }
}
