package com.ceiba.profesor.servicio;

import com.ceiba.BasePrueba;
import com.ceiba.dominio.excepcion.ExcepcionDuplicidad;
import com.ceiba.profesor.modelo.entidad.Profesor;
import com.ceiba.profesor.puerto.repositorio.ProfesorRepositorio;
import com.ceiba.profesor.servicio.testdatabuilder.ProfesorTestDataBuilder;

import org.junit.Test;

import static org.junit.Assert.*;
import static org.mockito.Matchers.anyLong;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class ActualizarProfesorServicioTest {

    @Test
    public void validarProfesorExistenciaPrevia() {
        Profesor profesor = new ProfesorTestDataBuilder().setId(1L).build();
        ProfesorRepositorio repositorio = mock(ProfesorRepositorio.class);
        when(repositorio.existe(anyLong())).thenReturn(false);
        ActualizarProfesorServicio servicio = new ActualizarProfesorServicio(repositorio);

        BasePrueba.assertThrows(()-> servicio.ejecutar(profesor), ExcepcionDuplicidad.class, "El profesor no existe en el sistema");
    }
}