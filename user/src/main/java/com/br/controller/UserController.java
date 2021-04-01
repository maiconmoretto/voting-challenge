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
import com.br.model.User;
import com.br.service.UserService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@RestController
public class UserController {

	@Autowired
	private UserService service;

	@ApiOperation(value = "It will return list of User")
	@GetMapping("/api/v1/user")
	public List<User> findAll() {
		return service.findAll();
	}

	@ApiOperation(value = "It will return a User by Id")
	@GetMapping("/api/v1/user/{id}")
	public User findById(@PathVariable int id) {
		return service.findById(id);
	}

	@ApiOperation(value = "It will save a User")
	@PostMapping(path = "/api/v1/user/")
	public @ResponseBody ResponseEntity save(@RequestBody User user) {
		return service.save(user);
	}

	@ApiOperation(value = "It will update a User")
	@PutMapping(value = "/api/v1/user/{id}")
	public ResponseEntity<String> update(@RequestBody User user) {
		return service.update(user);
	}

	@ApiOperation(value = "It will delete a User by Id")
	@DeleteMapping(path = "/api/v1/user/{id}")
	public ResponseEntity<String> deleteById(@PathVariable int id) {
		return 	service.deleteById(id);		
	}
}
