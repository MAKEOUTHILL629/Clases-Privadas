package com.ceiba.profesor.servicio;


import com.ceiba.BasePrueba;
import com.ceiba.dominio.excepcion.ExcepcionDuplicidad;
import com.ceiba.dominio.excepcion.ExcepcionSinDatos;
import com.ceiba.persona.puerto.dao.PersonaDAO;
import com.ceiba.profesor.modelo.entidad.Profesor;
import com.ceiba.profesor.puerto.repositorio.ProfesorRepositorio;
import com.ceiba.profesor.servicio.testdatabuilder.ProfesorTestDataBuilder;
import org.junit.Assert;
import org.junit.Test;
import org.junit.jupiter.api.DisplayName;

import static org.mockito.Matchers.anyLong;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class CrearProfesorServicioTest {

    @Test
    @DisplayName("Evaluar que el profesor no se repita en la percistencia")
    public void validarProfesorExistenciaPreviaTest() {
        Profesor profesor = new ProfesorTestDataBuilder().build();
        ProfesorRepositorio repositorio = mock(ProfesorRepositorio.class);
        when(repositorio.existeConIdPersona(anyLong())).thenReturn(true);
        PersonaDAO personaDAO = mock(PersonaDAO.class);
        when(personaDAO.existe(anyLong())).thenReturn(true);
        CrearProfesorServicio servicio = new CrearProfesorServicio(repositorio, personaDAO);

        BasePrueba.assertThrows(() -> servicio.ejecutar(profesor), ExcepcionDuplicidad.class, "El profesor ya existe en el sistema");
    }

    @Test
    public void validarExistenciaPreviaPersonaTest() {
        Profesor profesor = new ProfesorTestDataBuilder().build();
        ProfesorRepositorio repositorio = mock(ProfesorRepositorio.class);
        when(repositorio.existeConIdPersona(anyLong())).thenReturn(false);
        PersonaDAO personaDAO = mock(PersonaDAO.class);
        when(personaDAO.existe(anyLong())).thenReturn(false);
        CrearProfesorServicio servicio = new CrearProfesorServicio(repositorio, personaDAO);

        BasePrueba.assertThrows(() -> servicio.ejecutar(profesor), ExcepcionSinDatos.class, "El id de la persona no se encuentra en el sistema");
    }

    @Test
    public void validarFlujoNormaCrearProfesor() {
        Profesor profesor = new ProfesorTestDataBuilder().build();
        ProfesorRepositorio repositorio = mock(ProfesorRepositorio.class);
        when(repositorio.existeConIdPersona(anyLong())).thenReturn(false);
        PersonaDAO personaDAO = mock(PersonaDAO.class);
        when(personaDAO.existe(anyLong())).thenReturn(true);
        CrearProfesorServicio servicio = new CrearProfesorServicio(repositorio, personaDAO);

        Assert.assertEquals(new Long(0), servicio.ejecutar(profesor));
    }
}