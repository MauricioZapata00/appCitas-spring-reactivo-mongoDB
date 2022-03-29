package com.springBajo8.springBajo8.service.impl;

//import com.yoandypv.reactivestack.messages.domain.Message;
//import com.yoandypv.reactivestack.messages.repository.MessageRepository;
//import com.yoandypv.reactivestack.messages.service.MessageService;
import com.springBajo8.springBajo8.domain.CitasDTOReactiva;
import com.springBajo8.springBajo8.repository.IcitasReactivaRepository;
import com.springBajo8.springBajo8.service.IcitasReactivaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
public class CitasReactivaServiceImpl implements IcitasReactivaService {

    @Autowired
    private IcitasReactivaRepository IcitasReactivaRepository;

    @Override
    public Mono<CitasDTOReactiva> save(CitasDTOReactiva citasDTOReactiva) {
        return this.IcitasReactivaRepository.save(citasDTOReactiva);
    }

    @Override
    public Mono<CitasDTOReactiva> delete(String id) {
        return this.IcitasReactivaRepository
                .findById(id)
                .flatMap(p -> this.IcitasReactivaRepository.deleteById(p.getId()).thenReturn(p));

    }

    @Override
    public Mono<CitasDTOReactiva> update(String id, CitasDTOReactiva citasDTOReactiva) {
        return this.IcitasReactivaRepository.findById(id)
                .flatMap(citasDTOReactiva1 -> {
                    citasDTOReactiva.setId(id);
                    return save(citasDTOReactiva);
                })
                .switchIfEmpty(Mono.empty());
    }

    @Override
    public Flux<CitasDTOReactiva> findByIdPaciente(String idPaciente) {
        return this.IcitasReactivaRepository.findByIdPaciente(idPaciente);
    }

    public Mono<CitasDTOReactiva> cancelarCita(String id, CitasDTOReactiva citasDTOReactiva){
        return this.IcitasReactivaRepository.findById(id)
                .flatMap(citas ->{
                    if(citasDTOReactiva.getEstadoReservaCita().equals("activa"))
                        citasDTOReactiva.setEstadoReservaCita("cancelada");
                    return save(citasDTOReactiva);

                }).switchIfEmpty(Mono.empty());
    }
/*
    public Mono<CitasDTOReactiva> consultarCitaHoraFecha(String id, String fecha, String hora){
        return this.IcitasReactivaRepository.findById(id).
                flatMap(citas ->{
                    IcitasReactivaRepository.findCitaByDate(id,fecha,hora)

                }).single()
    }

 */


    @Override
    public Flux<CitasDTOReactiva> findAll() {
        return this.IcitasReactivaRepository.findAll();
    }

    @Override
    public Mono<CitasDTOReactiva> findById(String id) {
        return this.IcitasReactivaRepository.findById(id);
    }
}
