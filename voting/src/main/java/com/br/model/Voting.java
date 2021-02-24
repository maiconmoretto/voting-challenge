package com.br.model;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Data
@Entity
public class Voting {

	@Id
	@GeneratedValue
	private int id;
	private int idAgenda;
	private int idUser;
	private String createdAt;
	private String vote;

}





