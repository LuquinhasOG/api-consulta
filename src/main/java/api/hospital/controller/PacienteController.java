package api.hospital.controller;

import api.hospital.model.Paciente;
import api.hospital.service.PacienteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.Optional;

@RestController
@RequestMapping("/paciente")
public class PacienteController {
    @Autowired
    private PacienteService pacienteService;

    @GetMapping("/{id}")
    public ResponseEntity<Paciente> findById(@PathVariable("id") int id) {
        Paciente paciente = pacienteService.findById(id);
        return ResponseEntity.ok(paciente);
    }

    @PostMapping
    public ResponseEntity<Paciente> create(@RequestBody Paciente paciente) {
        Paciente pacienteSalvo = pacienteService.create(paciente);
        URI locationResponse = ServletUriComponentsBuilder
                .fromCurrentRequest()
                .path("/{id}")
                .buildAndExpand(pacienteSalvo.getId())
                .toUri();
        return ResponseEntity.created(locationResponse).body(pacienteSalvo);
    }

    @PutMapping
    public ResponseEntity<Paciente> update(@RequestBody Paciente paciente) {
        Paciente pacienteAtualizado = pacienteService.update(paciente);
        URI locationResponse = ServletUriComponentsBuilder
                .fromCurrentRequest()
                .path("/{id}")
                .buildAndExpand(pacienteAtualizado.getId())
                .toUri();
        return ResponseEntity.created(locationResponse).body(pacienteAtualizado);
    }
}
