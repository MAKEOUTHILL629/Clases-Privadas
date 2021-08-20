package com.ceiba.horarios_profesor.servicio;

import com.ceiba.BasePrueba;
import com.ceiba.dominio.excepcion.ExcepcionDuplicidad;
import com.ceiba.dominio.excepcion.ExcepcionValorInvalido;
import com.ceiba.horarios_profesor.modelo.entidad.HorariosProfesor;
import com.ceiba.horarios_profesor.puerto.repositorio.HorariosProfesorRepositorio;
import com.ceiba.horarios_profesor.servicio.testdatabuilder.HorariosProfesorTestDataBuilder;
import com.ceiba.profesor.modelo.dto.ProfesorDTO;
import com.ceiba.profesor.puerto.dao.ProfesorDAO;
import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.*;
import static org.mockito.Matchers.anyLong;
import static org.mockito.Matchers.anyObject;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class CrearHorarioProfesorServicioTest {

    @Test
    public void validarExistenciaPreviaHorarioTest() {
        HorariosProfesor horariosProfesor = new HorariosProfesorTestDataBuilder().build();
        HorariosProfesorRepositorio horariosProfesorRepositorio = mock(HorariosProfesorRepositorio.class);
        when(horariosProfesorRepositorio.existe(anyObject())).thenReturn(true);
        ProfesorDAO profesorDAO = mock(ProfesorDAO.class);
        ProfesorDTO profesorDTO = mock(ProfesorDTO.class);
        when(profesorDAO.obtener(anyLong())).thenReturn(profesorDTO);
        CrearHorarioProfesorServicio crearHorarioProfesorServicio = new CrearHorarioProfesorServicio(horariosProfesorRepositorio, profesorDAO);


        BasePrueba.assertThrows(() -> crearHorarioProfesorServicio.ejecutar(horariosProfesor), ExcepcionDuplicidad.class, "El horario ya existe en el sistema");
    }


    @Test
    public void validarExistenciaProfesorPreviaTest() {
        HorariosProfesor horariosProfesor = new HorariosProfesorTestDataBuilder().build();
        HorariosProfesorRepositorio horariosProfesorRepositorio = mock(HorariosProfesorRepositorio.class);
        when(horariosProfesorRepositorio.existe(anyObject())).thenReturn(false);
        ProfesorDAO profesorDAO = mock(ProfesorDAO.class);
        when(profesorDAO.obtener(anyLong())).thenReturn(null);
        CrearHorarioProfesorServicio crearHorarioProfesorServicio = new CrearHorarioProfesorServicio(horariosProfesorRepositorio, profesorDAO);

        BasePrueba.assertThrows(() -> crearHorarioProfesorServicio.ejecutar(horariosProfesor), ExcepcionValorInvalido.class, "El id del profesor no existe");

    }


    @Test
    public void validarFlujoCrearHorarioTest() {
        HorariosProfesor horariosProfesor = new HorariosProfesorTestDataBuilder().build();
        HorariosProfesorRepositorio horariosProfesorRepositorio = mock(HorariosProfesorRepositorio.class);
        when(horariosProfesorRepositorio.existe(anyObject())).thenReturn(false);
        ProfesorDAO profesorDAO = mock(ProfesorDAO.class);
        ProfesorDTO profesorDTO = mock(ProfesorDTO.class);
        when(profesorDAO.obtener(anyLong())).thenReturn(profesorDTO);
        CrearHorarioProfesorServicio crearHorarioProfesorServicio = new CrearHorarioProfesorServicio(horariosProfesorRepositorio, profesorDAO);

        Assert.assertEquals(new Long(0), crearHorarioProfesorServicio.ejecutar(horariosProfesor));
    }
}