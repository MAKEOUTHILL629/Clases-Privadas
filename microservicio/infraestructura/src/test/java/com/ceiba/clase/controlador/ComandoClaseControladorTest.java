package com.ceiba.clase.controlador;

import com.ceiba.ApplicationMock;
import com.ceiba.clase.comando.ClaseComando;
import com.ceiba.clase.servicio.testdatabuilder.ClaseComandoTestDataBuilder;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.Test;
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
@WebMvcTest(ComandoClaseControlador.class)
public class ComandoClaseControladorTest {
    @Autowired
    private ObjectMapper objectMapper;

    @Autowired
    private MockMvc mockMvc;

    @Test
    public void crear() throws Exception {
        ClaseComando clase = new ClaseComandoTestDataBuilder().build();


        mockMvc.perform(post("/clase")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(clase)))
                .andExpect(status().isOk())
                .andExpect(content().json("{'valor': 1}"));

    }


    @Test
    public void actualizar() throws Exception{
        Long id = 2L;
        ClaseComando claseComando = new ClaseComandoTestDataBuilder().build();

        mockMvc.perform(put("/clase/{id}",id)
                .contentType(MediaType.APPLICATION_JSON)
                .content(objectMapper.writeValueAsString(claseComando)))
                .andExpect(status().isOk());

    }

    @Test
    public void eliminar() throws Exception {
        // arrange
        Long id = 2L;

        // act - assert
        mockMvc.perform(delete("/clase/{id}",id)
                        .contentType(MediaType.APPLICATION_JSON)
                        .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk());
    }
}