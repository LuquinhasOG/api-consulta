package api.hospital.controller;

import api.hospital.model.EstadoConsulta;
import api.hospital.service.EstadoConsultaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;

@RestController
@RequestMapping("/estadoconsulta")
public class EstadoConsultaController {
    @Autowired
    private EstadoConsultaService estadoConsultaService;

    @GetMapping("/{id}")
    public ResponseEntity<EstadoConsulta> findById(@PathVariable("id") int id) {
        EstadoConsulta estadoConsulta = estadoConsultaService.findById(id);
        return ResponseEntity.ok(estadoConsulta);
    }

    @PostMapping
    public ResponseEntity<EstadoConsulta> create(@RequestBody EstadoConsulta estadoConsulta) {
        EstadoConsulta estadoConsultaSalvo = estadoConsultaService.create(estadoConsulta);
        URI locationResponse = ServletUriComponentsBuilder
                .fromCurrentRequest()
                .path("/{id}")
                .buildAndExpand(estadoConsultaSalvo.getId())
                .toUri();
        return ResponseEntity.created(locationResponse).body(estadoConsultaSalvo);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteById(@PathVariable("id") int id) {
        estadoConsultaService.deleteById(id);
        return ResponseEntity.ok("Deletado estado de consulta");
    }
}
