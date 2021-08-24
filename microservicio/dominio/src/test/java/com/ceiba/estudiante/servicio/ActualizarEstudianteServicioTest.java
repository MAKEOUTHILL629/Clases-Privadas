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
import static org.mockito.Mockito.*;

public class ActualizarEstudianteServicioTest {



    @Test
    public void validarExistenciaPreviaTest() {
        Estudiante estudiante = new EstudianteTestDataBuilder().build();
        EstudianteRepositorio repositorio = mock(EstudianteRepositorio.class);
        when(repositorio.existeConIdEstudiante(anyLong())).thenReturn(false);
        ActualizarEstudianteServicio servicio = new ActualizarEstudianteServicio(repositorio);


        BasePrueba.assertThrows(()-> servicio.ejecutar(estudiante), ExcepcionDatoNoEncontrado.class, "El estudiante no existe en el sistema");
    }

    @Test
    public void validarActualizarEstudianteNormalTest() {
        Estudiante estudiante = new EstudianteTestDataBuilder().build();
        EstudianteRepositorio repositorio = mock(EstudianteRepositorio.class);
        when(repositorio.existeConIdEstudiante(anyLong())).thenReturn(true);
        ActualizarEstudianteServicio servicio = new ActualizarEstudianteServicio(repositorio);

        servicio.ejecutar(estudiante);
        verify(repositorio).actualizar(estudiante);
    }

}