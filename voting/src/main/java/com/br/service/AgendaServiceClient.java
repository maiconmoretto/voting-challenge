package com.br.service;

import com.br.model.AgendaDTO;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import java.util.List;
import java.util.Optional;
import org.springframework.web.bind.annotation.*;
import org.springframework.http.ResponseEntity;

@FeignClient(name = "agenda-service-client", url = "${spring.agenda-service.url}")
public interface AgendaServiceClient {

    @GetMapping("/api/v1/agenda/{id}")
    AgendaDTO findById(@PathVariable int id);

    @GetMapping("/api/v1/agendas-closed")
    List<AgendaDTO> agendasClosed();

    @GetMapping("/api/v1/agenda-open/{idAgenda}")
    AgendaDTO agendaOpen(@PathVariable int idAgenda);

    @PutMapping(value = "/api/v1/agenda/")
    AgendaDTO update(@RequestBody AgendaDTO agenda);

}