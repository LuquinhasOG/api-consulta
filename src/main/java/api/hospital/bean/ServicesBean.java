package api.hospital.bean;

import api.hospital.service.*;
import api.hospital.service.implementation.*;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ServicesBean {
    @Bean
    public PacienteService pacienteService() {
        return new PacienteServiceImpl();
    }

    @Bean
    public EspecialidadeService especialidadeService() {
        return new EspecialidadeServiceImpl();
    }

    @Bean
    public MedicoService medicoService() {
        return new MedicoServiceImpl();
    }

    @Bean
    public EstadoConsultaService estadoConsultaService() {
        return new EstadoConsultaServiceImpl();
    }

    @Bean
    public ConsultaService consultaService() {
        return new ConsultaServiceImpl();
    }
}
