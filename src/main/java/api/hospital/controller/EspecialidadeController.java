package api.hospital.controller;

import api.hospital.model.Especialidade;
import api.hospital.model.Paciente;
import api.hospital.service.EspecialidadeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;

@RestController
@RequestMapping("/especialidade")
public class EspecialidadeController {
    @Autowired
    private EspecialidadeService especialidadeService;

    @GetMapping("/{id}")
    public ResponseEntity<Especialidade> findById(@PathVariable("id") int id) {
        Especialidade especialidade = especialidadeService.findById(id);
        return ResponseEntity.ok(especialidade);
    }

    @PostMapping
    public ResponseEntity<Especialidade> create(@RequestBody Especialidade especialidade) {
        Especialidade especialidadeSalvo = especialidadeService.create(especialidade);
        URI locationResponse = ServletUriComponentsBuilder
                .fromCurrentRequest()
                .path("/{id}")
                .buildAndExpand(especialidadeSalvo.getId())
                .toUri();
        return ResponseEntity.created(locationResponse).body(especialidadeSalvo);
    }

    @PutMapping
    public ResponseEntity<Especialidade> update(@RequestBody Especialidade especialidade) {
        Especialidade especialidadeAtualizada = especialidadeService.update(especialidade);
        URI locationResponse = ServletUriComponentsBuilder
                .fromCurrentRequest()
                .path("/{id}")
                .buildAndExpand(especialidadeAtualizada.getId())
                .toUri();
        return ResponseEntity.created(locationResponse).body(especialidadeAtualizada);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteById(@PathVariable("id") int id) {
        especialidadeService.deleteById(id);
        return ResponseEntity.ok("Especialidade deletada");
    }
}
