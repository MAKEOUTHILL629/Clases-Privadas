package com.ceiba.profesor.servicio;

import com.ceiba.BasePrueba;
import com.ceiba.dominio.excepcion.ExcepcionDatoNoEncontrado;
import com.ceiba.dominio.excepcion.ExcepcionDuplicidad;
import com.ceiba.persona.puerto.dao.PersonaDAO;
import com.ceiba.profesor.modelo.entidad.Profesor;
import com.ceiba.profesor.puerto.repositorio.ProfesorRepositorio;
import com.ceiba.profesor.servicio.testdatabuilder.ProfesorTestDataBuilder;

import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.*;
import static org.mockito.Matchers.anyLong;
import static org.mockito.Matchers.anyObject;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class ActualizarProfesorServicioTest {



    @Test
    public void validarExistenciaProfesorPreviaTest() {
        Profesor profesor = new ProfesorTestDataBuilder().setId(1L).build();
        ProfesorRepositorio repositorio = mock(ProfesorRepositorio.class);
        when(repositorio.existeConIdProfesor(anyLong())).thenReturn(false);
        PersonaDAO personaDAO = mock(PersonaDAO.class);
        when(personaDAO.existe(anyObject())).thenReturn(true);
        ActualizarProfesorServicio servicio = new ActualizarProfesorServicio(repositorio);

        BasePrueba.assertThrows(()-> servicio.ejecutar(profesor), ExcepcionDatoNoEncontrado.class, "El profesor no existe en el sistema");
    }


    @Test
    public void validarFlujoNormalActualizarProfesorTest() {
        Profesor profesor = new ProfesorTestDataBuilder().setId(1L).build();
        ProfesorRepositorio repositorio = mock(ProfesorRepositorio.class);
        when(repositorio.existeConIdProfesor(anyLong())).thenReturn(true);
        PersonaDAO personaDAO = mock(PersonaDAO.class);
        when(personaDAO.existe(anyObject())).thenReturn(true);
        ActualizarProfesorServicio servicio = new ActualizarProfesorServicio(repositorio);

        servicio.ejecutar(profesor);


    }
}