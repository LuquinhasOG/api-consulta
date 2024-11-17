package api.hospital.service;

import api.hospital.model.Consulta;

public interface ConsultaService {
    Iterable<Consulta> findAll();
    Iterable<Consulta> findByPacienteName(String nome);
    Iterable<Consulta> findByMedicoName(String nome);
    Consulta findById(int id);
    Consulta create(Consulta especialidade);
    Consulta update(Consulta especialidade);
    void deleteById(int id);
}
