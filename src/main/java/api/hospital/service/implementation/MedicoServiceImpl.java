package api.hospital.service.implementation;

import api.hospital.model.Especialidade;
import api.hospital.model.Medico;
import api.hospital.repository.EspecialidadeRepository;
import api.hospital.repository.MedicoRepository;
import api.hospital.service.EspecialidadeService;
import api.hospital.service.MedicoService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.NoSuchElementException;
import java.util.Optional;

@Service
public class MedicoServiceImpl implements MedicoService {
    @Autowired
    private MedicoRepository medicoRepository;
    @Autowired
    private EspecialidadeRepository especialidadeService;

    @Override
    public Iterable<Medico> findAll() {
        return medicoRepository.findAll();
    }

    @Override
    public Medico findById(int id) {
        return medicoRepository.findById(id).orElseThrow(NoSuchElementException::new);
    }

    @Override
    public Medico create(Medico medico) {
        Optional<Especialidade> especialidade = especialidadeService.findById(medico.getEspecialidade().getId());
        if (especialidade.isEmpty()) {
            throw new IllegalArgumentException("A especialidade do médico não foi encontrada");
        }
        if (medicoRepository.existsByCpf(medico.getCpf())) {
            throw new IllegalArgumentException("Este médico já está registrado");
        }
        medico.setEspecialidade(especialidade.get());
        return medicoRepository.save(medico);
    }

    @Override
    public Medico update(Medico medico) {
        Optional<Medico> encontrado = medicoRepository.findById(medico.getId());
        if (encontrado.isEmpty()) {
            throw new IllegalArgumentException("Este médico não foi encontrado");
        }
        Medico medicoAtualizado = encontrado.get();
        BeanUtils.copyProperties(medico, medicoAtualizado);
        return medicoRepository.save(medicoAtualizado);
    }
}
