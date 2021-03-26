package com.br.model;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.time.LocalDateTime;

@Data
@Entity
public class Voting {

	@Id
	@GeneratedValue
	private int id;
	private int idAgenda;
	private int idUser;
	private LocalDateTime createdAt = LocalDateTime.now();
	private String vote;

}





