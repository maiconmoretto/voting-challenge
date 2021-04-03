package com.br.service;

import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import java.util.concurrent.TimeoutException;
import com.br.repository.AgendaRepository;
import com.br.model.Agenda;
import java.io.IOException;
import com.br.request.AgendaRequest;
import com.br.request.AgendaRequestUpdate;

@Service
public class AgendaService {

	@Autowired
	private AgendaRepository repository;

	@Autowired
	private Sender sender;

	@Autowired
	private Consumer consumer;

	public List<Agenda> findAll() {
		return (List<Agenda>) repository.findAll();
	}

	public Agenda findById(int id) {
		return repository.findById(id).get();
	}

	public Agenda save(AgendaRequest request) throws IOException, TimeoutException  {
		Agenda agenda = new Agenda();
		agenda.setDuration(request.getDuration());
		agenda.setDescription(request.getDescription());
		sender.send(agenda);

		if (agenda.getDuration() == 0) {
			agenda.setDuration(60);
		}
		return repository.save(agenda);
	}

	public Agenda update(AgendaRequestUpdate request) throws  Exception {
		Optional<Agenda> agendaExist = repository.findById(request.getId());
		if (!agendaExist.isPresent()) {
			throw new Exception("Agenda does not exist");
		}
		Agenda agenda = new Agenda();
		agenda.setDuration(request.getDuration());
		agenda.setDescription(request.getDescription());
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
