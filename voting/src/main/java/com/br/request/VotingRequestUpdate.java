package com.br.request;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Data
public class VotingRequestUpdate {

	private int id;
	private int idAgenda;
	private int idUser;
	private String vote;

}





