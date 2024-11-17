package api.hospital.service.implementation;

import api.hospital.model.EstadoConsulta;
import api.hospital.repository.EstadoConsultaRepository;
import api.hospital.service.EstadoConsultaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.NoSuchElementException;

@Service
public class EstadoConsultaServiceImpl implements EstadoConsultaService {
    @Autowired
    private EstadoConsultaRepository estadoConsultaRepository;

    @Override
    public EstadoConsulta findById(int id) {
        return estadoConsultaRepository.findById(id).orElseThrow(NoSuchElementException::new);
    }

    @Override
    public EstadoConsulta create(EstadoConsulta estadoConsulta) {
        return estadoConsultaRepository.save(estadoConsulta);
    }

    @Override
    public void deleteById(int id) {
        estadoConsultaRepository.deleteById(id);
    }
}
