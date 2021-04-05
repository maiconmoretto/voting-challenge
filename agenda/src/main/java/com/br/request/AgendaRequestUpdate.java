package com.br.request;

import lombok.Data;
import javax.persistence.Id;
import lombok.Getter;
import lombok.Setter;

@Data
public class AgendaRequestUpdate {

    private int id;
    private String description;
    private int duration;
    private boolean sentToMessager;
    private boolean agendaClosed;



}
