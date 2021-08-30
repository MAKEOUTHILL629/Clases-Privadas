package com.ceiba.persona.controlador;

import com.ceiba.ApplicationMock;
import com.ceiba.persona.comando.PersonaComando;
import com.ceiba.persona.modelo.dto.PersonaDTO;
import com.ceiba.persona.puerto.dao.PersonaDAO;
import com.ceiba.persona.servicio.testdatabuilder.PersonaComandoTestDataBuilder;
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

import static org.junit.Assert.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@ContextConfiguration(classes= ApplicationMock.class)
@WebMvcTest(PersonaComandoControlador.class)
public class PersonaComandoControladorTest {
    @Autowired
    private ObjectMapper objectMapper;

    @Autowired
    private MockMvc mocMvc;

    @Autowired
    private PersonaDAO personaDAO;

    @Test
    public void crear() throws Exception{
        PersonaComando comando = new PersonaComandoTestDataBuilder().build();

        mocMvc.perform(post("/personas")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(comando)))
                .andExpect(status().isOk())
                .andExpect(content().json("{'valor': 17}"));
    }

    @Test(expected = EmptyResultDataAccessException.class)
    public void eliminar() throws Exception{
        Long id = 16L;

        mocMvc.perform(delete("/personas/{id}",id)
                        .contentType(MediaType.APPLICATION_JSON)
                        .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk()).andDo(result -> {
                    assertNull(personaDAO.obtener(id));
                });
    }

    @Test
    public void actualizar() throws Exception{
        Long id = 3l;
        PersonaComando personaComando = new PersonaComandoTestDataBuilder().setCedula("1000784040").build();

        mocMvc.perform(put("/personas/{id}",id)
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(personaComando)))
                .andExpect(status().isOk()).andDo(result -> {
                    PersonaDTO personaActualizarRespuesta = personaDAO.obtener(id);
                    assertEquals(personaComando.getNombres(), personaActualizarRespuesta.getNombres());
                    assertEquals(personaComando.getApellidos(), personaActualizarRespuesta.getApellidos());
                    assertEquals(personaComando.getCedula(), personaActualizarRespuesta.getCedula());
                });

    }


}