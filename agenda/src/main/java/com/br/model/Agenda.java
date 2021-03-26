package com.br.model;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.time.LocalDateTime;

@Data
@Entity
public class Agenda {

    @Id
    @GeneratedValue
    private int id;
    private String description;
    private LocalDateTime createdAt = LocalDateTime.now();
    private int duration;
    private int sim;
    private int nao;
    private boolean sentToMessager;

}
