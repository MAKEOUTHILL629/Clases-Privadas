package com.ceiba.profesor.servicio;


import com.ceiba.BasePrueba;
import com.ceiba.dominio.excepcion.ExcepcionDuplicidad;
import com.ceiba.profesor.modelo.entidad.Profesor;
import com.ceiba.profesor.puerto.repositorio.ProfesorRepositorio;
import com.ceiba.profesor.servicio.testdatabuilder.ProfesorTestDataBuilder;
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
        when(repositorio.existe(anyLong())).thenReturn(false);
        CrearProfesorServicio servicio = new CrearProfesorServicio(repositorio);

        BasePrueba.assertThrows(()-> servicio.ejecutar(profesor), ExcepcionDuplicidad.class, "El profesor ya existe en el sistema");
    }
}