
package com.br;

import static org.hamcrest.CoreMatchers.containsString;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import com.fasterxml.jackson.databind.Module.SetupContext;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.Before;
import com.br.model.Agenda;

@SpringBootTest
@AutoConfigureMockMvc
public class AgendaControllerTests {

    @Autowired
    private MockMvc mvc;

    private Agenda agenda;

    @Before
    public void setup() {
        Agenda agenda = new Agenda();
    }

    @Test
    public void findAll() throws Exception {
        mvc.perform(MockMvcRequestBuilders.get("/api/v1/agenda/").accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk());
    }

    @Test
    public void saveWithoutDescription() throws Exception {
        mvc.perform(MockMvcRequestBuilders.post("/api/v1/agenda/").accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isBadRequest());
    }

    @Test
    public void save() throws Exception {
        mvc.perform(MockMvcRequestBuilders.post("/api/v1/agenda/").content(asJsonString(agenda))
                .contentType(MediaType.APPLICATION_JSON).accept(MediaType.APPLICATION_JSON));

    }

    @Test
    public void findByIdMethodNotAllowed() throws Exception {
        mvc.perform(MockMvcRequestBuilders.post("/api/v1/agenda/1").accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isMethodNotAllowed());
    }

    @Test
    public void update() throws Exception {
        mvc.perform(MockMvcRequestBuilders.put("/api/v1/agenda/").content(asJsonString(agenda))
                .contentType(MediaType.APPLICATION_JSON).accept(MediaType.APPLICATION_JSON));
    }

    @Test
    public void delete() throws Exception {
        mvc.perform(MockMvcRequestBuilders.delete("/api/v1/agenda/").content(asJsonString(agenda))
                .contentType(MediaType.APPLICATION_JSON).accept(MediaType.APPLICATION_JSON));
    }

    public static String asJsonString(final Object obj) {
        try {
            final ObjectMapper mapper = new ObjectMapper();
            final String jsonContent = mapper.writeValueAsString(obj);
            return jsonContent;
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}

