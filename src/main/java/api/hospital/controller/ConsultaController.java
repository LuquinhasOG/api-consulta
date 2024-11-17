package api.hospital.controller;

import api.hospital.model.Consulta;
import api.hospital.service.ConsultaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/consulta")
public class ConsultaController {
    @Autowired
    private ConsultaService consultaService;

    @GetMapping
    public ResponseEntity<Iterable<Consulta>> findAll() {
        return ResponseEntity.ok(consultaService.findAll());
    }

    @GetMapping("/paciente/{nome}")
    public ResponseEntity<Iterable<Consulta>> findAllByPacienteName(@PathVariable("nome") String nome) {
        return ResponseEntity.ok(consultaService.findByPacienteName(nome));
    }

    @GetMapping("/medico/{nome}")
    public ResponseEntity<Iterable<Consulta>> findAllByMedicoName(@PathVariable("nome") String nome) {
        return ResponseEntity.ok(consultaService.findByMedicoName(nome));
    }

    @GetMapping("/{id}")
    public ResponseEntity<Consulta> findById(@PathVariable("id") int id) {
        return ResponseEntity.ok(consultaService.findById(id));
    }

    @PostMapping
    public ResponseEntity<Consulta> create(@RequestBody Consulta consulta) {
        return ResponseEntity.ok(consultaService.create(consulta));
    }

    @PutMapping
    public ResponseEntity<Consulta> update(@RequestBody Consulta consulta) {
        return ResponseEntity.ok(consultaService.update(consulta));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteById(@PathVariable("id") int id) {
        consultaService.deleteById(id);
        return ResponseEntity.ok("Consulta deletada");
    }
}
