package com.springBajo8.springBajo8.service;

//import com.yoandypv.reactivestack.messages.domain.Message;
import com.springBajo8.springBajo8.domain.CitasDTOReactiva;
import com.springBajo8.springBajo8.domain.PacientesDTOReactiva;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.ArrayList;

public interface IcitasReactivaService {
    Mono<CitasDTOReactiva> save(CitasDTOReactiva citasDTOReactiva);

    Mono<CitasDTOReactiva> delete(String id);

    Mono<CitasDTOReactiva> update(String id, CitasDTOReactiva citasDTOReactiva);

    Flux<CitasDTOReactiva> findByIdPaciente(String idPaciente);

    Flux<CitasDTOReactiva> findAll();

    Mono<CitasDTOReactiva> findById(String id);

    Mono<CitasDTOReactiva> cancelarCita(String id, CitasDTOReactiva citasDTOReactiva);

    Flux<CitasDTOReactiva> consultarCitaHoraFecha(String id, String fecha, String hora);

    Mono<CitasDTOReactiva> encontrarNombreMedico(String nombreMedico);

    ArrayList<String> encontrarPatologiasByPacienteId(String id);
}
