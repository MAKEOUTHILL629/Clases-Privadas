package com.ceiba.clase.controlador;

import com.ceiba.ApplicationMock;
import com.ceiba.clase.comando.ClaseComando;
import com.ceiba.clase.modelo.dto.ClaseDTO;
import com.ceiba.clase.puerto.dao.ClaseDAO;
import com.ceiba.clase.servicio.testdatabuilder.ClaseComandoTestDataBuilder;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.tomcat.jni.Local;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.http.MediaType;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;


import java.time.LocalDateTime;
import java.time.format.DateTimeParseException;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@RunWith(SpringRunner.class)
@ContextConfiguration(classes = ApplicationMock.class)
@WebMvcTest(ComandoClaseControlador.class)
public class ComandoClaseControladorTest {
    @Autowired
    private ObjectMapper objectMapper;

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private ClaseDAO claseDAO;

    @Test
    public void crear() throws Exception {
        ClaseComando clase = new ClaseComandoTestDataBuilder().setFecha(LocalDateTime.now().plusDays(1)).build();

        mockMvc.perform(post("/clase")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(clase)))
                .andExpect(status().isOk())
                .andExpect(content().json("{'valor': 5}"));

    }

    @Test
    public void actualizar() throws Exception {
        Long id = 1L;
        ClaseComando claseComando = new ClaseComandoTestDataBuilder().setIdEstudiante(1l).setIdProfesor(6l).build();

        mockMvc.perform(put("/clase/{id}", id)
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(claseComando)))
                .andExpect(status().isOk()).andDo(
                        resultado -> {
                            ClaseDTO actualizarClaseRespuesta = claseDAO.obtener(id);
                            assertEquals(claseComando.getIdEstudiante() ,actualizarClaseRespuesta.getEstudianteDTO().getId());
                            assertEquals(claseComando.getFecha().toString().substring(0, 19), actualizarClaseRespuesta.getFecha().toString());
                            assertEquals(claseComando.getIdProfesor(),actualizarClaseRespuesta.getProfesorDTO().getId());
                        }
                );

    }

    @Test(expected = EmptyResultDataAccessException.class)
    public void eliminar() throws Exception {
        Long id = 2L;

        mockMvc.perform(delete("/clase/{id}", id)
                        .contentType(MediaType.APPLICATION_JSON)
                        .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk()).andDo(result -> {
                    ClaseDTO claseDTO = claseDAO.obtener(id);
                });
    }

}