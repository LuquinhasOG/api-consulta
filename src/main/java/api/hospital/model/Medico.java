package api.hospital.model;

import jakarta.persistence.*;

import java.time.LocalDate;

@Entity(name = "medico")
public class Medico {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Column(length = 50)
    private String nome;
    @Column(length = 11)
    private String cpf;
    @Column(name = "data_nascimento")
    private LocalDate dataNascimento;
    @Column(length = 14)
    private String telefone;
    private Boolean ativo;
    @Column(length = 9)
    private String crm;

    @ManyToOne
    private Especialidade especialidade;
}
