package com.br.model;

import lombok.Data;

@Data
public class AgendaDTO {

    private String description;
    private String createdAt;
    private int duration;
    private int sim;
    private int nao;
    private boolean sentToMessager;
}