package api.hospital.service.implementation;

import api.hospital.model.Paciente;
import api.hospital.repository.PacienteRepository;
import api.hospital.service.PacienteService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.NoSuchElementException;
import java.util.Optional;

@Service
public class PacienteServiceImpl implements PacienteService {
    @Autowired
    private PacienteRepository pacienteRepository;

    @Override
    public Paciente findById(int id) {
        return pacienteRepository.findById(id).orElseThrow(NoSuchElementException::new);
    }

    @Override
    public Paciente create(Paciente paciente) {
        if (pacienteRepository.existsById(paciente.getId())
                || pacienteRepository.existsByCpf(paciente.getCpf())) {
            throw new IllegalArgumentException("Este paciente já existe");
        }
        return pacienteRepository.save(paciente);
    }

    @Override
    public Paciente update(Paciente paciente) {
        Optional<Paciente> encontrou = pacienteRepository.findById(paciente.getId());
        if (encontrou.isEmpty()) {
            throw new IllegalArgumentException("Este paciente não foi encontrado");
        }
        Paciente pacienteAtualizado = new Paciente();
        BeanUtils.copyProperties(paciente, pacienteAtualizado);
        return pacienteRepository.save(pacienteAtualizado);
    }
}
