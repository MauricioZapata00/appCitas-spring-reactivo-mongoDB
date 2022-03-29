package com.springBajo8.springBajo8.repository;

import com.springBajo8.springBajo8.domain.PacientesDTOReactiva;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import org.springframework.stereotype.Repository;
import reactor.core.publisher.Flux;

import java.util.ArrayList;

@Repository
public interface PacientesReactivosRepository extends ReactiveMongoRepository<PacientesDTOReactiva, String> {
    ArrayList<String> findPatologiasById(String idPaciente);


}
