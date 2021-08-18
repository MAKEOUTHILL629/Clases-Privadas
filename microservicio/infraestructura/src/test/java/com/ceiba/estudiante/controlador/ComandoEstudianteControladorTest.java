package com.ceiba.estudiante.controlador;

import com.ceiba.ApplicationMock;
import com.ceiba.estudiante.comando.EstudianteComando;
import com.ceiba.estudiante.servicio.testdatabuilder.EstudianteComandoTestDataBuilder;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.Test;
import org.junit.jupiter.api.Disabled;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@ContextConfiguration(classes = ApplicationMock.class)
@WebMvcTest(ComandoEstudianteControlador.class)
public class ComandoEstudianteControladorTest {
    @Autowired
    private ObjectMapper objectMapper;

    @Autowired
    private MockMvc mocMvc;

    @Test

    public void crear() throws Exception {

        EstudianteComando estudiante = new EstudianteComandoTestDataBuilder().build();

        mocMvc.perform(post("/estudiante")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(estudiante)))
                .andExpect(status().isOk())
                .andExpect(content().json("{'valor': 8}"));
    }

    @Test

    public void actualizar() throws Exception {
        Long id = 8L;
        EstudianteComando comando = new EstudianteComandoTestDataBuilder().setNivelEstudios("SECUNDARIA").build();

        mocMvc.perform(put("/estudiante/{id}", id)
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(comando)))
                .andExpect(status().isOk());

    }

    @Test

    public void eliminar() throws Exception {
        Long id = 8L;

        mocMvc.perform(delete("/estudiante/{id}", id)
                        .contentType(MediaType.APPLICATION_JSON)
                        .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk());
    }
}