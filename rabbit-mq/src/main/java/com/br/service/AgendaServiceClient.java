package com.br.service;

import com.br.model.AgendaDTO;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name = "agenda-service-client", url = "${spring.agenda-service.url}")
public interface AgendaServiceClient {

    @GetMapping("/api/v1/agenda/{id}")
    AgendaDTO findById(@PathVariable int id);

}