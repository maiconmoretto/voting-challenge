package com.br.model;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Data
@Entity
public class Agenda {

    @Id
    @GeneratedValue
    private int id;
    private String description;
    private String createdAt;
    private int duration;
    private int sim;
    private int nao;
    private boolean sentToMessager;

}
