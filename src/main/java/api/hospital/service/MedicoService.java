package api.hospital.service;

import api.hospital.model.Medico;

public interface MedicoService {
    Iterable<Medico> findAll();
    Medico findById(int id);
    Medico create(Medico medico);
    Medico update(Medico medico);
}
