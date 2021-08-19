package com.ceiba.estudiante.servicio;

import com.ceiba.BasePrueba;
import com.ceiba.dominio.excepcion.ExcepcionDuplicidad;
import com.ceiba.estudiante.modelo.entidad.Estudiante;
import com.ceiba.estudiante.puerto.repositorio.EstudianteRepositorio;
import com.ceiba.estudiante.servicio.testdatabuilder.EstudianteTestDataBuilder;
import com.ceiba.persona.puerto.dao.PersonaDAO;
import org.junit.Test;

import static org.junit.Assert.*;
import static org.mockito.Matchers.anyLong;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class ActualizarEstudianteServicioTest {

    @Test
    public void validarEstudianteExistenciaPrevia() {
        Estudiante estudiante = new EstudianteTestDataBuilder().build();
        EstudianteRepositorio repositorio = mock(EstudianteRepositorio.class);
        when(repositorio.existe(anyLong())).thenReturn(true);
        PersonaDAO personaDAO = mock(PersonaDAO.class);

        ActualizarEstudianteServicio servicio = new ActualizarEstudianteServicio(repositorio,personaDAO);

        BasePrueba.assertThrows(()-> servicio.ejecutar(estudiante), ExcepcionDuplicidad.class, "El estudiante no existe en el sistema");
    }

}