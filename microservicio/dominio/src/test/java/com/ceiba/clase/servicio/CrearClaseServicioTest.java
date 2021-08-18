package com.ceiba.clase.servicio;

import com.ceiba.clase.modelo.entidad.Clase;
import com.ceiba.clase.puerto.repositorio.ClaseRepositorio;
import com.ceiba.clase.servicio.testdatabuilder.ClaseTestDataBuilder;
import com.ceiba.clase.servicio.utilidad.GenerarValor;
import com.ceiba.estudiante.servicio.testdatabuilder.EstudianteTestDataBuilder;
import org.junit.Test;

import java.time.LocalDateTime;

import static org.junit.Assert.*;
import static org.mockito.Matchers.anyObject;
import static org.mockito.Mockito.*;

public class CrearClaseServicioTest {

    @Test
    public void validarExistenciaPrevia() {
        Clase clase = new ClaseTestDataBuilder()
                .setEstudiante(new EstudianteTestDataBuilder().setNivelEstudios("UNIVERSIDAD").build())
                .setFecha(LocalDateTime.now().plusHours(2)).build();
        ClaseRepositorio repositorio = mock(ClaseRepositorio.class);
        when(repositorio.existe(anyObject())).thenReturn(false);
       // CrearClaseServicio servicio = new CrearClaseServicio(repositorio);

        //servicio.ejecutar(clase);

        verify(repositorio).existe(anyLong());
    }
}