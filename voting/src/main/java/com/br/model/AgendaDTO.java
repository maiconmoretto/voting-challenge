package com.br.model;

import lombok.Data;
import java.time.LocalDateTime;

@Data
public class AgendaDTO {

    private int id;
    private String description;
    private LocalDateTime createdAt;
    private int duration;
    private int sim;
    private int nao;
    private boolean sentToMessager;
}