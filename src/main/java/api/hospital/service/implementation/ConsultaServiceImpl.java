package api.hospital.service.implementation;

import api.hospital.model.Consulta;
import api.hospital.model.EstadoConsulta;
import api.hospital.model.Medico;
import api.hospital.model.Paciente;
import api.hospital.repository.*;
import api.hospital.service.ConsultaService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.NoSuchElementException;
import java.util.Optional;

@Service
public class ConsultaServiceImpl implements ConsultaService {
    @Autowired
    private ConsultaRepository consultaRepository;
    @Autowired
    private MedicoRepository medicoRepository;
    @Autowired
    private PacienteRepository pacienteRepository;
    @Autowired
    private EstadoConsultaRepository estadoConsultaRepository;

    @Override
    public Iterable<Consulta> findAll() {
        return consultaRepository.findAll();
    }

    @Override
    public Iterable<Consulta> findByPacienteName(String nome) {
        return consultaRepository.findAllByPacienteNome(nome);
    }

    @Override
    public Iterable<Consulta> findByMedicoName(String nome) {
        return consultaRepository.findAllByMedicoNome(nome);
    }

    @Override
    public Consulta findById(int id) {
        return consultaRepository.findById(id).orElseThrow(NoSuchElementException::new);
    }

    @Override
    public Consulta create(Consulta consulta) {
        Optional<Paciente> paciente = pacienteRepository.findById(consulta.getPaciente().getId());
        Optional<Medico> medico = medicoRepository.findById(consulta.getMedico().getId());
        Optional<EstadoConsulta> estadoConsulta = estadoConsultaRepository.findById(consulta.getEstadoConsulta().getId());

        if (paciente.isEmpty() || medico.isEmpty() || estadoConsulta.isEmpty()) {
            throw new IllegalArgumentException("Verifique se os dados estão corretos");
        }

        return consultaRepository.save(consulta);
    }

    @Override
    public Consulta update(Consulta consulta) {
        Optional<Consulta> encontrado = consultaRepository.findById(consulta.getId());
        if (encontrado.isEmpty()) {
            throw new IllegalArgumentException("Esta consulta não existe");
        }
        Consulta consultaAtualizada = new Consulta();
        BeanUtils.copyProperties(consulta, consultaAtualizada);
        return consultaRepository.save(consultaAtualizada);
    }

    @Override
    public void deleteById(int id) {
        consultaRepository.deleteById(id);
    }
}
