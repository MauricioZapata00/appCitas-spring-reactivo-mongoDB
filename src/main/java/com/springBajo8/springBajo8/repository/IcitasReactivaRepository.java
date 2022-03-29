package com.springBajo8.springBajo8.repository;

//import com.yoandypv.reactivestack.messages.domain.Message;
import com.springBajo8.springBajo8.domain.CitasDTOReactiva;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface IcitasReactivaRepository extends ReactiveMongoRepository<CitasDTOReactiva, String> {
    Flux<CitasDTOReactiva> findByIdPaciente(String idPaciente);
    Mono<CitasDTOReactiva> findCitaByDate(String id,String fecha,String hora);
}
