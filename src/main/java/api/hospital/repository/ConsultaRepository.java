package api.hospital.repository;

import api.hospital.model.Consulta;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ConsultaRepository extends JpaRepository<Consulta, Integer> {
    Iterable<Consulta> findAllByPacienteNome(String nome);
    Iterable<Consulta> findAllByMedicoNome(String nome);
}
