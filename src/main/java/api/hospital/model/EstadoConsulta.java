package api.hospital.model;

import jakarta.persistence.*;

@Entity(name = "estado_consulta")
public class EstadoConsulta {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Column(length = 20)
    private String estado;
}
