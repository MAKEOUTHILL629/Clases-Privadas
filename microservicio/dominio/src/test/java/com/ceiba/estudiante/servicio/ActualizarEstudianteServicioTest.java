package com.ceiba.estudiante.servicio;

import com.ceiba.BasePrueba;
import com.ceiba.dominio.excepcion.ExcepcionDatoNoEncontrado;
import com.ceiba.dominio.excepcion.ExcepcionDuplicidad;
import com.ceiba.estudiante.modelo.clasificacion.NivelEstudios;
import com.ceiba.estudiante.modelo.dto.EstudianteDTO;
import com.ceiba.estudiante.modelo.entidad.Estudiante;
import com.ceiba.estudiante.puerto.repositorio.EstudianteRepositorio;
import com.ceiba.estudiante.servicio.testdatabuilder.EstudianteTestDataBuilder;
import com.ceiba.persona.modelo.dto.PersonaDTO;
import com.ceiba.persona.puerto.dao.PersonaDAO;
import org.junit.Test;

import static org.junit.Assert.*;
import static org.mockito.Matchers.anyLong;
import static org.mockito.Matchers.anyObject;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class ActualizarEstudianteServicioTest {

    @Test
    public void validarExistenciaPersonaPreviaTest() {
        Estudiante estudiante = new EstudianteTestDataBuilder().build();
        EstudianteRepositorio repositorio = mock(EstudianteRepositorio.class);
        when(repositorio.existeConIdEstudiante(anyLong())).thenReturn(true);
        PersonaDAO personaDAO = mock(PersonaDAO.class);
        when(personaDAO.obtener(anyLong())).thenReturn(anyObject());
        ActualizarEstudianteServicio servicio = new ActualizarEstudianteServicio(repositorio,personaDAO);

        BasePrueba.assertThrows(()-> servicio.ejecutar(estudiante), ExcepcionDatoNoEncontrado.class, "La persona no existe en el sistema");
    }

    @Test
    public void validarExistenciaPreviaTest() {
        Estudiante estudiante = new EstudianteTestDataBuilder().build();
        EstudianteRepositorio repositorio = mock(EstudianteRepositorio.class);
        when(repositorio.existeConIdEstudiante(anyLong())).thenReturn(false);
        PersonaDAO personaDAO = mock(PersonaDAO.class);
        when(personaDAO.existe(anyLong())).thenReturn(true);
        ActualizarEstudianteServicio servicio = new ActualizarEstudianteServicio(repositorio,personaDAO);


        BasePrueba.assertThrows(()-> servicio.ejecutar(estudiante), ExcepcionDatoNoEncontrado.class, "El estudiante no existe en el sistema");
    }

    @Test
    public void validarActualizarEstudianteNormalTest() {
        Estudiante estudiante = new EstudianteTestDataBuilder().build();
        EstudianteRepositorio repositorio = mock(EstudianteRepositorio.class);
        when(repositorio.existeConIdEstudiante(anyLong())).thenReturn(true);
        PersonaDAO personaDAO = mock(PersonaDAO.class);
        when(personaDAO.existe(anyLong())).thenReturn(true);
        ActualizarEstudianteServicio servicio = new ActualizarEstudianteServicio(repositorio,personaDAO);

        servicio.ejecutar(estudiante);
    }

}