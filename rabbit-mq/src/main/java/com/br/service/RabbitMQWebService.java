package com.br.service;

import java.io.IOException;
import org.springframework.stereotype.Service;
import java.util.concurrent.TimeoutException;
import com.br.service.Sender;
import com.br.service.Consumer;
import org.springframework.beans.factory.annotation.Autowired;
import  com.br.model.AgendaDTO;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.server.ResponseStatusException;
import feign.FeignException;

@Service
public class RabbitMQWebService {


    @Autowired
    Sender sender;

    @Autowired
    Consumer consumer;

    @Autowired
    private AgendaServiceClient agendaServiceClient;

    public void producer(int id) throws IOException, TimeoutException  {
        AgendaDTO agendaDTO;
        try {
            agendaDTO = agendaServiceClient.findById(id);
        } catch (FeignException ex) {
            if (HttpStatus.NOT_FOUND.value() == 404) {
                throw new ResponseStatusException(
                        HttpStatus.BAD_REQUEST,
                        "No Agenda found with id: " + id
                );
            } else {
                throw new ResponseStatusException(
                        HttpStatus.BAD_REQUEST,
                        "System unavaible." + HttpStatus.NOT_FOUND.value()
                ) ;
            }
        }
        //Agenda agenda = agendaService.findAgendaClosedById(id);

        //sender.send(agenda);
    }

    public void producerAll() throws IOException, TimeoutException {
        //List<Agenda> agendasClosed = agendaService.agendasClosed();

	/*	for(Agenda agenda: agendasClosed) {
			sender.send(agenda);
		}*/
    }


    public void producer() throws IOException, TimeoutException {
        consumer.consume();
    }
}