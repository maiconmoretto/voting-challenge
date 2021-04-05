package com.br;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.concurrent.TimeoutException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;
import com.br.model.Agenda;
import com.br.request.AgendaRequestUpdate;
import com.br.service.AgendaService;
import com.br.service.Sender;

@Component
public class ScheduledTasks {

    private static final Logger log = LoggerFactory.getLogger(ScheduledTasks.class);

    private static final SimpleDateFormat dateFormat = new SimpleDateFormat("HH:mm:ss");

    @Autowired
    AgendaService agendaService;

    @Scheduled(fixedRate = 10000)
    public void verifyAllAgendasClosedAndUpdate() throws IOException, TimeoutException, Exception {
        List<Agenda> agendasClosed = agendaService.agendasClosed();
        log.info("Task start {}", dateFormat.format(new Date()));
        for(Agenda agenda: agendasClosed) {
            AgendaRequestUpdate agendaRequestUpdate = new AgendaRequestUpdate();
            agendaRequestUpdate.setId(agenda.getId());
            agendaRequestUpdate.setDescription(agenda.getDescription());
            agendaRequestUpdate.setDuration(agenda.getDuration());
            agendaRequestUpdate.setSentToMessager(agenda.isSentToMessager());
            agendaRequestUpdate.setAgendaClosed(true);
            agendaService.update(agendaRequestUpdate);
        }
    }
}