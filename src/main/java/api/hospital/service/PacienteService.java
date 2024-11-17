package api.hospital.service;

import api.hospital.model.Paciente;

public interface PacienteService {
    Paciente findById(int id);
    Paciente create(Paciente paciente);
    Paciente update(Paciente paciente);
}
