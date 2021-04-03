package com.br.request;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.time.LocalDateTime;

@Data
public class AgendaRequest {

    private String description;
    private int duration;

}
