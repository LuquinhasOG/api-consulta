package api.hospital.controller;

import api.hospital.model.Medico;
import api.hospital.service.MedicoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;

@RestController
@RequestMapping("/medico")
public class MedicoController {
    @Autowired
    private MedicoService medicoService;

    @GetMapping
    public ResponseEntity<Iterable<Medico>> findAll() {
        return ResponseEntity.ok(medicoService.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Medico> findById(@PathVariable("id") int id) {
        Medico medico = medicoService.findById(id);
        return ResponseEntity.ok(medico);
    }

    @PostMapping
    public ResponseEntity<Medico> create(@RequestBody Medico medico) {
        Medico medicoSalvo = medicoService.create(medico);
        URI locationResponse = ServletUriComponentsBuilder
                .fromCurrentRequest()
                .path("/{id}")
                .buildAndExpand(medicoSalvo.getId())
                .toUri();
        return ResponseEntity.created(locationResponse).body(medicoSalvo);
    }

    @PutMapping
    public ResponseEntity<Medico> update(@RequestBody Medico medico) {
        Medico medicoAtualizado = medicoService.update(medico);
        URI locationResponse = ServletUriComponentsBuilder
                .fromCurrentRequest()
                .path("/{id}")
                .buildAndExpand(medicoAtualizado.getId())
                .toUri();
        return ResponseEntity.created(locationResponse).body(medicoAtualizado);
    }
}
