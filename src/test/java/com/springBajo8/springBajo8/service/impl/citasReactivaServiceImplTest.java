package com.springBajo8.springBajo8.service.impl;

import com.springBajo8.springBajo8.domain.CitasDTOReactiva;
import org.assertj.core.api.Assert.*;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.util.Assert;
import reactor.core.publisher.Flux;
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
       //StepVerifier.create(citaGuardada).expectNext(citasReactivaServiceImpl.cancelarCita(cita.getId(),cita)).verifyComplete();


    }

    @Test
    void buscarPorIdPacienteTest(){
        CitasDTOReactiva cita = new CitasDTOReactiva();
        cita.setIdPaciente("1");
        cita.setHoraReservaCita("10:30 am");
        cita.setNombrePaciente("Mary");
        cita.setNombreMedico("Victor");
        citasReactivaServiceImpl.save(cita);


        Flux<CitasDTOReactiva> paciente = citasReactivaServiceImpl.findByIdPaciente("1");
        StepVerifier.create(paciente).expectNext(cita).verifyComplete();
    }

    @Test
    void deleteCitaByIdTest (String id){
        CitasDTOReactiva cita = new CitasDTOReactiva();
        cita.setIdPaciente("1");
        cita.setHoraReservaCita("10:30 am");
        cita.setNombrePaciente("Mary");
        cita.setNombreMedico("Victor");
        citasReactivaServiceImpl.save(cita);
        citasReactivaServiceImpl.delete(cita.getId());

       // Mono<CitasDTOReactiva> cita1=  citasReactivaServiceImpl.save(cita);

        Mono<CitasDTOReactiva> citaPaBorrar = citasReactivaServiceImpl.delete(cita.getId());
        //StepVerifier.create(citaPaBorrar).expectNext(citasReactivaServiceImpl.delete("1")).verifyComplete();
        StepVerifier.create(citaPaBorrar).verifyComplete();

    }
}