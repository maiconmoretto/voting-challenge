package com.br.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.br.repository.AgendaRepository;
import com.br.model.Agenda;

@Service
public class AgendaService {

	@Autowired
	private AgendaRepository repository;

	public List<Agenda> findAll() {
		return (List<Agenda>) repository.findAll();
	}

	public Agenda findById(int id) {
		return repository.findById(id).get();
	}

	public Agenda save(Agenda agenda) {
		if (agenda.getDuration() == 0) {
			agenda.setDuration(60);
		}
		return repository.save(agenda);
	}

	public Agenda update(Agenda agenda) throws  Exception {
		Optional<Agenda> agendaExist = repository.findById(agenda.getId());
		if (!agendaExist.isPresent()) {
			throw new Exception("Agenda does not exist");
		}
		return repository.save(agenda);
	}

	public ResponseEntity<String> deleteById(int id) {
		repository.deleteById(id);
		return new ResponseEntity<>("Agenda successfully deleted", HttpStatus.OK);
	}

	public List<Agenda> agendasClosed() {
		return repository.agendasClosed();
	}

	public Agenda findAgendaClosedById(int id) {
		return repository.findAgendaClosedById(id);
	}

	public Agenda agendaOpen(int idAgenda) {
		return repository.agendaOpen(idAgenda);
	}

}
