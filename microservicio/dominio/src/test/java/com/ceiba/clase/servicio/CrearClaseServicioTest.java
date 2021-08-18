package com.ceiba.clase.servicio;

import com.ceiba.BasePrueba;
import com.ceiba.clase.modelo.entidad.Clase;
import com.ceiba.clase.puerto.repositorio.ClaseRepositorio;
import com.ceiba.clase.servicio.testdatabuilder.ClaseTestDataBuilder;
import com.ceiba.clase.servicio.utilidad.GenerarValor;
import com.ceiba.dominio.excepcion.ExcepcionDuplicidad;
import com.ceiba.estudiante.puerto.dao.EstudianteDAO;
import com.ceiba.estudiante.servicio.testdatabuilder.EstudianteTestDataBuilder;
import org.junit.Test;

import java.time.LocalDateTime;

import static org.junit.Assert.*;
import static org.mockito.Matchers.anyObject;
import static org.mockito.Mockito.*;

public class CrearClaseServicioTest {

    @Test
    public void validarEsRepetida() {
        Clase clase = new ClaseTestDataBuilder()
                .setEstudiante(new EstudianteTestDataBuilder().setNivelEstudios("UNIVERSIDAD").build())
                .setFecha(LocalDateTime.now().plusHours(2)).build();
        ClaseRepositorio repositorio = mock(ClaseRepositorio.class);
        when(repositorio.esRepetido(anyObject())).thenReturn(true);
        EstudianteDAO estudianteDAO = mock(EstudianteDAO.class);
        when(estudianteDAO.obtener(anyLong())).thenReturn(anyObject());
        CrearClaseServicio servicio = new CrearClaseServicio(repositorio, estudianteDAO);

        BasePrueba.assertThrows(()-> servicio.ejecutar(clase) , ExcepcionDuplicidad.class, "La clase ya se encuentra en el sistema");
    }
}