package com.br.model;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.time.LocalDateTime;

@Data
@Entity
public class User {

	@Id
	@GeneratedValue
	private int id;
	private String name;
	private LocalDateTime createdAt = LocalDateTime.now();
	private String cpf;

}