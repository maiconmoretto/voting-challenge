package com.br.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.br.model.Agenda;
import com.br.service.AgendaService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@RestController
public class AgendaController {

	@Autowired
	private AgendaService service;

	@ApiOperation(value = "It will return list of Agenda")
	@GetMapping("/api/v1/agenda")
	public List<Agenda> findAll() {
		return service.findAll();
	}

	@ApiOperation(value = "It will return a Agenda by Id")
	@GetMapping("/api/v1/agenda/{id}")
	public Agenda findById(@PathVariable int id) {
		return service.findById(id);
	}

	@ApiOperation(value = "It will save a Agenda")
	@PostMapping(path = "/api/v1/agenda/")
	public Agenda saveAgenda(@RequestBody Agenda agenda) {
		return service.save(agenda);
	}

	@ApiOperation(value = "It will update a Agenda")
	@PutMapping(value = "/api/v1/agenda/")
	public Agenda update(@RequestBody Agenda agenda) throws  Exception {
		return service.update(agenda);
	}

	@ApiOperation(value = "It will delete a Agenda by Id")
	@DeleteMapping(path = "/api/v1/agenda/{id}")
	public ResponseEntity<String> deleteById(@PathVariable int id) {
		return service.deleteById(id);
	}

	@ApiOperation(value = "It will return list of Agenda closed")
	@GetMapping("/api/v1/agendas-closed")
	public List<Agenda> agendasClosed() {
		return service.agendasClosed();
	}

	@ApiOperation(value = "It will return a Agenda open")
	@GetMapping("/api/v1/agenda-open/{idAgenda}")
	public Agenda agendaOpen(@PathVariable int idAgenda) {
		return service.agendaOpen(idAgenda);
	}
}
