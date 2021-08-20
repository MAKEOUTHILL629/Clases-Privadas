package com.ceiba.estudiante.servicio;


import com.ceiba.BasePrueba;
import com.ceiba.dominio.excepcion.ExcepcionDuplicidad;
import com.ceiba.dominio.excepcion.ExcepcionSinDatos;
import com.ceiba.estudiante.modelo.entidad.Estudiante;
import com.ceiba.estudiante.puerto.repositorio.EstudianteRepositorio;
import com.ceiba.estudiante.servicio.testdatabuilder.EstudianteTestDataBuilder;
import com.ceiba.persona.puerto.dao.PersonaDAO;
import com.ceiba.persona.servicio.testdatabuilder.PersonaTestDataBuilder;
import org.junit.Assert;
import org.junit.Test;

import static org.mockito.Matchers.anyLong;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class CrearEstudianteServicioTest {
    @Test
    public void validarExistenciaPersonaTest() {
        Estudiante estudiante = new EstudianteTestDataBuilder().build();
        EstudianteRepositorio repositorio = mock(EstudianteRepositorio.class);
        when(repositorio.existeConIdEstudiante(anyLong())).thenReturn(true);
        PersonaDAO personaDAO = mock(PersonaDAO.class);
        when(personaDAO.existe(anyLong())).thenReturn(false);
        CrearEstudianteServicio servicio = new CrearEstudianteServicio(repositorio, personaDAO);

        BasePrueba.assertThrows(() -> servicio.ejecutar(estudiante), ExcepcionSinDatos.class, "El id de la persona no se encuentra en el sistema");
    }

    @Test
    public void validarExisteEstudianteTest() {
        Estudiante estudiante = new EstudianteTestDataBuilder().setPersona(new PersonaTestDataBuilder().setId(1l).build()).build();
        EstudianteRepositorio repositorio = mock(EstudianteRepositorio.class);
        PersonaDAO personaDAO = mock(PersonaDAO.class);
        when(personaDAO.existe(anyLong())).thenReturn(true);
        when(repositorio.existeConIdPersona(anyLong())).thenReturn(true);
        CrearEstudianteServicio servicio = new CrearEstudianteServicio(repositorio, personaDAO);


        BasePrueba.assertThrows(()-> servicio.ejecutar(estudiante), ExcepcionDuplicidad.class, "El estudiante ya existe en el sistema");
    }


    @Test
    public void crearUnaPersonaNormamenteTest() {
        Estudiante estudiante = new EstudianteTestDataBuilder().setPersona(new PersonaTestDataBuilder().setId(1l).build()).build();
        EstudianteRepositorio repositorio = mock(EstudianteRepositorio.class);
        PersonaDAO personaDAO = mock(PersonaDAO.class);
        when(personaDAO.existe(anyLong())).thenReturn(true);
        when(repositorio.existeConIdPersona(anyLong())).thenReturn(false);
        CrearEstudianteServicio servicio = new CrearEstudianteServicio(repositorio, personaDAO);


        Assert.assertEquals(new  Long(0), servicio.ejecutar(estudiante));
    }
}