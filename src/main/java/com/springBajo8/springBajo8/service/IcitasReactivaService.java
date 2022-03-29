package com.springBajo8.springBajo8.service;

//import com.yoandypv.reactivestack.messages.domain.Message;
import com.springBajo8.springBajo8.domain.CitasDTOReactiva;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface IcitasReactivaService {
    Mono<CitasDTOReactiva> save(CitasDTOReactiva citasDTOReactiva);

    Mono<CitasDTOReactiva> delete(String id);

    Mono<CitasDTOReactiva> update(String id, CitasDTOReactiva citasDTOReactiva);

    Flux<CitasDTOReactiva> findByIdPaciente(String idPaciente);

    Flux<CitasDTOReactiva> findAll();

    Mono<CitasDTOReactiva> findById(String id);
}
