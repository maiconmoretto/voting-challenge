package com.br.controller;

import java.io.IOException;
import java.util.List;
import java.util.concurrent.TimeoutException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import com.br.service.RabbitMQWebService;
import org.springframework.beans.factory.annotation.Autowired;


@RestController
@RequestMapping(value = "/api/v1/rabbitmq/")
public class RabbitMQWebController {

	@Autowired
	private RabbitMQWebService service;

	@GetMapping(value = "/producer")
	public void producer(@RequestParam("id") int id) throws IOException, TimeoutException {
		service.producer(id);
	}
	
	@GetMapping(value = "/producer/all/")
	public void producerAll() throws IOException, TimeoutException {
		service.producerAll();
	}
	
	@GetMapping(value = "/consumer")
	public void producer() throws IOException, TimeoutException {		
		service.producer();
	}
	
}
