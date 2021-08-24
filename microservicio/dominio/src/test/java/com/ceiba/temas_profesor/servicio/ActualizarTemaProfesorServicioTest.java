package com.ceiba.temas_profesor.servicio;

import com.ceiba.BasePrueba;
import com.ceiba.dominio.excepcion.ExcepcionDuplicidad;
import com.ceiba.dominio.excepcion.ExcepcionValorInvalido;
import com.ceiba.profesor.modelo.dto.ProfesorDTO;
import com.ceiba.profesor.puerto.dao.ProfesorDAO;
import com.ceiba.temas_profesor.modelo.entidad.TemasProfesor;
import com.ceiba.temas_profesor.puerto.repositorio.TemasProfesorRepositorio;
import com.ceiba.temas_profesor.servicio.testdatabuilder.TemasProfesorTestDataBuilder;
import org.junit.Test;

import static org.junit.Assert.*;
import static org.mockito.Matchers.anyLong;
import static org.mockito.Matchers.anyObject;
import static org.mockito.Mockito.*;

public class ActualizarTemaProfesorServicioTest {

    @Test
    public void validarExistenciaPreviaTemaTest() {
        TemasProfesor temasProfesor = new TemasProfesorTestDataBuilder().build();
        TemasProfesorRepositorio temasProfesorRepositorio = mock(TemasProfesorRepositorio.class);
        when(temasProfesorRepositorio.existe(anyObject())).thenReturn(false);
        ProfesorDAO profesorDAO = mock(ProfesorDAO.class);
        ProfesorDTO profesorDTO = mock(ProfesorDTO.class);
        when(profesorDAO.obtener(anyLong())).thenReturn(profesorDTO);
        ActualizarTemaProfesorServicio actualizarTemaProfesorServicio = new ActualizarTemaProfesorServicio(temasProfesorRepositorio, profesorDAO);

        BasePrueba.assertThrows(() -> actualizarTemaProfesorServicio.ejecutar(temasProfesor), ExcepcionDuplicidad.class, "El tema no existe en el sistema");
    }

    @Test
    public void validarExistenciaProfesorPreviaTest() {
        TemasProfesor temasProfesor = new TemasProfesorTestDataBuilder().build();
        TemasProfesorRepositorio temasProfesorRepositorio = mock(TemasProfesorRepositorio.class);
        when(temasProfesorRepositorio.existe(anyObject())).thenReturn(true);
        ProfesorDAO profesorDAO = mock(ProfesorDAO.class);
        when(profesorDAO.obtener(anyLong())).thenReturn(null);
        ActualizarTemaProfesorServicio actualizarTemaProfesorServicio = new ActualizarTemaProfesorServicio(temasProfesorRepositorio, profesorDAO);

        BasePrueba.assertThrows(() -> actualizarTemaProfesorServicio.ejecutar(temasProfesor), ExcepcionValorInvalido.class, "El id del profesor no existe");
    }

    @Test
    public void validarFlujoNormalActualizarTemaTest() {
        TemasProfesor temasProfesor = new TemasProfesorTestDataBuilder().build();
        TemasProfesorRepositorio temasProfesorRepositorio = mock(TemasProfesorRepositorio.class);
        when(temasProfesorRepositorio.existe(anyObject())).thenReturn(true);
        ProfesorDAO profesorDAO = mock(ProfesorDAO.class);
        ProfesorDTO profesorDTO = mock(ProfesorDTO.class);
        when(profesorDAO.obtener(anyLong())).thenReturn(profesorDTO);
        ActualizarTemaProfesorServicio actualizarTemaProfesorServicio = new ActualizarTemaProfesorServicio(temasProfesorRepositorio, profesorDAO);

        actualizarTemaProfesorServicio.ejecutar(temasProfesor);

        verify(temasProfesorRepositorio).actualizar(temasProfesor);
    }
}