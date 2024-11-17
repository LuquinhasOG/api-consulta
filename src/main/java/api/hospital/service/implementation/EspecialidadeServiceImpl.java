package api.hospital.service.implementation;

import api.hospital.model.Especialidade;
import api.hospital.repository.EspecialidadeRepository;
import api.hospital.service.EspecialidadeService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.NoSuchElementException;
import java.util.Optional;

@Service
public class EspecialidadeServiceImpl implements EspecialidadeService {
    @Autowired
    private EspecialidadeRepository especialidadeRepository;

    @Override
    public Especialidade findById(int id) {
        return especialidadeRepository.findById(id).orElseThrow(NoSuchElementException::new);
    }

    @Override
    public Especialidade create(Especialidade especialidade) {
        return especialidadeRepository.save(especialidade);
    }

    @Override
    public Especialidade update(Especialidade especialidade) {
        Optional<Especialidade> encontrado = especialidadeRepository.findById(especialidade.getId());
        if (encontrado.isEmpty()) {
            throw new IllegalArgumentException("Esta especialidade não foi encontrada");
        }
        Especialidade especialidadeAtualizada = encontrado.get();
        BeanUtils.copyProperties(especialidade, especialidadeAtualizada);
        return especialidadeRepository.save(especialidadeAtualizada);
    }

    @Override
    public void deleteById(int id) {
        especialidadeRepository.deleteById(id);
    }
}
