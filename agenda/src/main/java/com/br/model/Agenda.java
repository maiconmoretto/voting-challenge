package com.br.model;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.time.LocalDateTime;
import lombok.Getter;
import lombok.Setter;

@Data
@Entity
public class Agenda {

    @Id
    @GeneratedValue
    private int id;
    private String description;
    private LocalDateTime createdAt = LocalDateTime.now();
    private int duration;
    private int sim = 0;
    private int nao = 0;
    private boolean sentToMessager;
    private boolean agendaClosed;


}
