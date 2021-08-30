package com.ceiba.temas_profesor.controlador;

import com.ceiba.ApplicationMock;
import com.ceiba.temas_profesor.comando.TemasProfesorComando;
import com.ceiba.temas_profesor.modelo.dto.TemasProfesorDTO;
import com.ceiba.temas_profesor.puerto.dao.TemasProfesorDAO;
import com.ceiba.temas_profesor.servicio.testdatabuilder.TemasProfesorComandoTestDataBuilder;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import static org.junit.Assert.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@ContextConfiguration(classes = ApplicationMock.class)
@WebMvcTest(ComandoTemasProfesorControlador.class)
public class ComandoTemasProfesorControladorTest {
    @Autowired
    private ObjectMapper objectMapper;

    @Autowired
    private MockMvc mocMvc;

    @Autowired
    private TemasProfesorDAO temasProfesorDAO;
    @Test
    public void crear() throws Exception{
        TemasProfesorComando comando = new TemasProfesorComandoTestDataBuilder().build();

        mocMvc.perform(post("/temas")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(comando)))
                .andExpect(status().isOk())
                .andExpect(content().json("{'valor': 8}"));
    }

    @Test
    public void actualizar() throws Exception{
        Long id = 4l;
        TemasProfesorComando temasProfesorComando = new TemasProfesorComandoTestDataBuilder().build();

        mocMvc.perform(put("/temas/{id}", id)
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(temasProfesorComando)))
                .andExpect(status().isOk()).andDo(result -> {
                    TemasProfesorDTO actualizarTemasRespuesta = temasProfesorDAO.listar().stream().filter(temas -> temas.getId().equals(id)).findFirst().get();
                    assertEquals(temasProfesorComando.getTema(), actualizarTemasRespuesta.getTema());
                    assertEquals(temasProfesorComando.getIdProfesor(), actualizarTemasRespuesta.getIdProfesor());
                });
    }

    @Test
    public void eliminar() throws Exception{
        Long id = 3L;

        mocMvc.perform(delete("/temas/{id}", id)
                        .contentType(MediaType.APPLICATION_JSON)
                        .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk());


    }
}