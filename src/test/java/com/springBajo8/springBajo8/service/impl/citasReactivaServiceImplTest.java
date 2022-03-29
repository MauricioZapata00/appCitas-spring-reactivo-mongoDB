package com.springBajo8.springBajo8.service.impl;

import com.springBajo8.springBajo8.domain.CitasDTOReactiva;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import reactor.core.publisher.Mono;
import reactor.test.StepVerifier;


@SpringBootTest
class citasReactivaServiceImplTest {



@Autowired
CitasReactivaServiceImpl citasReactivaServiceImpl;

    @Test
    void  cancelarCitaTest() {
        CitasDTOReactiva cita= new CitasDTOReactiva();
        cita.setNombrePaciente("Miguel");
        cita.setEstadoReservaCita("activa");

        Mono<CitasDTOReactiva> citaGuardada = citasReactivaServiceImpl.save(cita);
      //   StepVerifier.create(citaGuardada).expectNext(citasReactivaServiceImpl.cancelarCita(cita.getId(),cita)).verifyComplete();











    }
}