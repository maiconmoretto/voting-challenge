package com.br.model;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Data
@Entity
public class User {

	@Id
	@GeneratedValue
	private int id;
	private String name;
	private String createdAt;
	private String cpf;

}