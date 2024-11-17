package api.hospital.service;

import api.hospital.model.EstadoConsulta;

public interface EstadoConsultaService {
    EstadoConsulta findById(int id);
    EstadoConsulta create(EstadoConsulta estadoConsulta);
    void deleteById(int id);
}
