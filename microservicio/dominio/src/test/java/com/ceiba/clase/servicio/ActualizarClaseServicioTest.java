package com.ceiba.clase.servicio;

import com.ceiba.BasePrueba;
import com.ceiba.clase.modelo.entidad.Clase;
import com.ceiba.clase.puerto.repositorio.ClaseRepositorio;
import com.ceiba.clase.servicio.testdatabuilder.ClaseTestDataBuilder;
import com.ceiba.dominio.excepcion.ExcepcionDuplicidad;
import org.junit.Test;


import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;


public class ActualizarClaseServicioTest {
    @Test
    public void validarUsuarioExistenciaPreviaTest() {
        Clase clase = new ClaseTestDataBuilder().setId(1l).build();
        ClaseRepositorio repositorio = mock(ClaseRepositorio.class);
        when(repositorio.existe(clase)).thenReturn(false);
        ActualizarClaseServicio servicio = new ActualizarClaseServicio(repositorio);

        BasePrueba.assertThrows(()-> servicio.ejecutar(clase), ExcepcionDuplicidad.class,"La clase no existe en el sistema" );
    }
}