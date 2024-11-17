package api.hospital.repository;

import api.hospital.model.EstadoConsulta;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EstadoConsultaRepository extends JpaRepository<EstadoConsulta, Integer> {}
