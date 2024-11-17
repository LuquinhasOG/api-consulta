package api.hospital.service;

import api.hospital.model.Especialidade;

public interface EspecialidadeService {
    Especialidade findById(int id);
    Especialidade create(Especialidade especialidade);
    Especialidade update(Especialidade especialidade);
    void deleteById(int id);
}
