package com.ceiba.estudiante.controlador;

import com.ceiba.ApplicationMock;
import com.ceiba.estudiante.comando.comando.EstudianteComandActualizar;
import com.ceiba.estudiante.comando.comando.EstudianteComandoCrear;
import com.ceiba.estudiante.modelo.clasificacion.NivelEstudios;
import com.ceiba.estudiante.modelo.dto.EstudianteDTO;
import com.ceiba.estudiante.puerto.dao.EstudianteDAO;
import com.ceiba.estudiante.servicio.testdatabuilder.EstudianteComandoActualizarTestDataBuilder;
import com.ceiba.estudiante.servicio.testdatabuilder.EstudianteComandoCrearTestDataBuilder;
import com.fasterxml.jackson.databind.ObjectMapper;
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

    @Autowired
    private EstudianteDAO estudianteDAO;

    @Test
    public void crear() throws Exception {

        EstudianteComandoCrear estudiante = new EstudianteComandoCrearTestDataBuilder().setIdPersona(16l).setNivelEstudios(NivelEstudios.SECUNDARIA).build();

        mocMvc.perform(post("/estudiante")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(estudiante)))
                .andExpect(status().isOk())
                .andExpect(content().json("{'valor': 8}"));
    }

    @Test
    public void actualizar() throws Exception {
        Long id = 1l;
        EstudianteComandActualizar estudianteComandActualizar = new EstudianteComandoActualizarTestDataBuilder().setNivelEstudios(NivelEstudios.SECUNDARIA).build();

        mocMvc.perform(put("/estudiante/{id}", id)
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(estudianteComandActualizar)))
                .andExpect(status().isOk()).andDo(result -> {
                    EstudianteDTO actualizarEstudianteRespuesta = estudianteDAO.obtener(id);
                    Assert.assertEquals(estudianteComandActualizar.getNivelEstudios(), actualizarEstudianteRespuesta.getNivelEstudios());
                });
    }

    @Test(expected = EmptyResultDataAccessException.class)
    public void eliminar() throws Exception {
        Long id = 8L;

        mocMvc.perform(delete("/estudiante/{id}", id)
                        .contentType(MediaType.APPLICATION_JSON)
                        .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk()).andDo(result -> {
                    EstudianteDTO eliminarEstudianteRespuesta = estudianteDAO.obtener(id);
                    Assert.assertNull(eliminarEstudianteRespuesta);
                });
    }
}