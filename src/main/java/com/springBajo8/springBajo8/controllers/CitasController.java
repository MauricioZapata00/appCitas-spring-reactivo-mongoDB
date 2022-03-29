package com.springBajo8.springBajo8.controllers;

import com.springBajo8.springBajo8.domain.CitasDTOReactiva;
import com.springBajo8.springBajo8.service.impl.CitasReactivaServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.ArrayList;

@RestController
public class CitasController {

    @Autowired
    private CitasReactivaServiceImpl citas;

    @RequestMapping(value = "/getPathologies/{id}", method = RequestMethod.GET)
    public ArrayList<String> getPathologiesOfPatient(@RequestParam("id") String id){
        return this.citas.encontrarPatologiasByPacienteId(id);
    }

    @RequestMapping(value = "/cancelAppointment", method = RequestMethod.POST)
    public Mono<CitasDTOReactiva> cancelAppointment(@RequestBody CitasDTOReactiva cita){
        return this.citas.cancelarCita(cita.getId(), cita);
    }

    @RequestMapping(value = "/searchDoctor/{name}", method = RequestMethod.GET)
    public Mono<CitasDTOReactiva> findDoctorsName(@RequestParam("name") String name){
        return this.citas.encontrarNombreMedico(name);
    }

    @RequestMapping(value = "/getAppointmentByDate", method = RequestMethod.GET)
    public Flux<CitasDTOReactiva> getAppointmentsWithDate(@RequestBody CitasDTOReactiva cita){
        return this.citas.consultarCitaHoraFecha(cita.getId(), cita.getFechaReservaCita(), cita.getHoraReservaCita());
    }
}
