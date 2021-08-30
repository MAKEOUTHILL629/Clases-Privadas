package com.ceiba.horarios_profesor.controlador;

import com.ceiba.ApplicationMock;
import com.ceiba.horarios_profesor.comando.HorariosProfesorComando;
import com.ceiba.horarios_profesor.modelo.dto.HorariosProfesorDTO;
import com.ceiba.horarios_profesor.puerto.dao.HorariosProfesorDAO;
import com.ceiba.horarios_profesor.servicio.testdatabuilder.HorariosProfesorComandoTestDataBuilder;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import java.util.NoSuchElementException;

import static org.junit.Assert.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@ContextConfiguration(classes = ApplicationMock.class)
@WebMvcTest(ComandoHorariosProfesorControlador.class)
public class ComandoHorariosProfesorControladorTest {
    @Autowired
    private ObjectMapper objectMapper;

    @Autowired
    private MockMvc mocMvc;

    @Autowired
    private HorariosProfesorDAO horariosProfesorDAO;

    @Test
    public void crear() throws Exception {
        HorariosProfesorComando comando = new HorariosProfesorComandoTestDataBuilder().setHora("15:00").build();

        mocMvc.perform(post("/horarios")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(comando)))
                .andExpect(status().isOk())
                .andExpect(content().json("{'valor': 8}"));
    }

    @Test
    public void actualizar() throws Exception {
        Long id = 2l;
        HorariosProfesorComando horariosProfesorComando = new HorariosProfesorComandoTestDataBuilder().build();

        mocMvc.perform(put("/horarios/{id}", id)
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(horariosProfesorComando)))
                .andExpect(status().isOk()).andDo(result -> {
                    HorariosProfesorDTO horarioRespuestaActualizar = horariosProfesorDAO.listar().stream().filter(horario -> horario.getId().equals(id)).findFirst().get();
                    assertEquals(horariosProfesorComando.getDiaSemana().toString(), horarioRespuestaActualizar.getDiaSemana());
                    assertEquals(horariosProfesorComando.getHora(), horarioRespuestaActualizar.getHora().toString());
                    assertEquals(horariosProfesorComando.getIdProfesor(), horarioRespuestaActualizar.getIdProfesor());
                });

    }

    @Test(expected = NoSuchElementException.class)
    public void eliminar() throws Exception {
        Long id = 8L;

        mocMvc.perform(delete("/horarios/{id}", id)
                        .contentType(MediaType.APPLICATION_JSON)
                        .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk()).andDo(result -> {
                    HorariosProfesorDTO eliminarHorarioRespuesta = horariosProfesorDAO.listar().stream().filter(horario -> horario.getId().equals(id)).findFirst().get();
                    assertNull(eliminarHorarioRespuesta);
                });

    }
}