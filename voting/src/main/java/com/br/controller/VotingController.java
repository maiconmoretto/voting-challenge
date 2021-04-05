
package com.br.controller;

import java.util.List;
import java.util.Optional;

import org.hibernate.annotations.UpdateTimestamp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import com.br.request.VotingRequest;
import com.br.model.Voting;
import com.br.service.VotingService;
import org.springframework.web.server.ResponseStatusException;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import com.br.request.VotingRequestUpdate;

@RestController
public class VotingController {

    @Autowired
    private VotingService service;

    @ApiOperation(value = "It will return list of Voting")
    @GetMapping("/api/v1/voting")
    public List<Voting> findAll() {
        return service.findAll();
    }

    @ApiOperation(value = "It will return a Voting by id")
    @GetMapping("/api/v1/voting/{id}")
    public Voting findById(@PathVariable int id) {
        return service.findById(id);
    }

    @ApiOperation(value = "It will save a Voting")
    @PostMapping(path = "/api/v1/voting/")
    public @ResponseBody
    ResponseEntity save(@RequestBody VotingRequest votingRequest) throws ResponseStatusException {
        return service.save(votingRequest);
    }

    @ApiOperation(value = "It will update a Voting")
    @PutMapping(value = "/api/v1/voting/{id}")
    public ResponseEntity<String> update(@RequestBody VotingRequestUpdate votingRequestUpdate) {
        return service.update(votingRequestUpdate);
    }

    @ApiOperation(value = "It will deleve a Voting by id")
    @DeleteMapping(path = "/api/v1/voting/{id}")
    public ResponseEntity<String> deleteById(@PathVariable int id) {
        return service.deleteById(id);
    }

}