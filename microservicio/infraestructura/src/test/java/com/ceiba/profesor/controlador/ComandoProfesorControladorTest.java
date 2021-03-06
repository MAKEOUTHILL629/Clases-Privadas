package com.ceiba.profesor.controlador;

import com.ceiba.ApplicationMock;
import com.ceiba.profesor.comando.comando.ProfesorComandoActualizar;
import com.ceiba.profesor.comando.comando.ProfesorComandoCrear;
import com.ceiba.profesor.modelo.dto.ProfesorDTO;
import com.ceiba.profesor.puerto.dao.ProfesorDAO;
import com.ceiba.profesor.servicio.testdatabuilder.ProfesorComandoActualizarTestDataBuilder;
import com.ceiba.profesor.servicio.testdatabuilder.ProfesorComandoTestDataBuilder;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.http.MediaType;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@ContextConfiguration(classes = ApplicationMock.class)
@WebMvcTest(ComandoProfesorControlador.class)
public class ComandoProfesorControladorTest {
    @Autowired
    private ObjectMapper objectMapper;

    @Autowired
    private MockMvc mocMvc;

    @Autowired
    private ProfesorDAO profesorDAO;

    @Test
    public void crear() throws Exception{
        ProfesorComandoCrear profesor = new ProfesorComandoTestDataBuilder().build();

        mocMvc.perform(post("/profesor")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(profesor)))
                .andExpect(status().isOk())
                .andExpect(content().json("{'valor': 8}"));
    }

    @Test
    public void actualizar() throws Exception {
        Long id = 1l;
        ProfesorComandoActualizar profesorComandoActualizar = new ProfesorComandoActualizarTestDataBuilder().setProfesion("Sociales").build();

        mocMvc.perform(put("/profesor/{id}", id)
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(profesorComandoActualizar)))
                .andExpect(status().isOk()).andDo(result -> {
                    ProfesorDTO actualizarProfesorRespuesta = profesorDAO.obtener(id);
                    assertEquals(profesorComandoActualizar.getProfesion(), actualizarProfesorRespuesta.getProfesion());
                });

    }

    @Test(expected = EmptyResultDataAccessException.class)
    public void eliminar() throws Exception {
        Long id = 8L;

        mocMvc.perform(delete("/profesor/{id}", id)
                        .contentType(MediaType.APPLICATION_JSON)
                        .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk()).andDo(result -> {
                    assertNull(profesorDAO.obtener(id));
                });
    }
}