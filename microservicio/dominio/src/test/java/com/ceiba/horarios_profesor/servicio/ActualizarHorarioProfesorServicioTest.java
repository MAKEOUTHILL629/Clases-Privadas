package com.ceiba.horarios_profesor.servicio;

import com.ceiba.BasePrueba;
import com.ceiba.dominio.excepcion.ExcepcionDuplicidad;
import com.ceiba.dominio.excepcion.ExcepcionValorInvalido;
import com.ceiba.horarios_profesor.modelo.entidad.HorariosProfesor;
import com.ceiba.horarios_profesor.puerto.repositorio.HorariosProfesorRepositorio;
import com.ceiba.horarios_profesor.servicio.testdatabuilder.HorariosProfesorTestDataBuilder;
import com.ceiba.profesor.modelo.dto.ProfesorDTO;
import com.ceiba.profesor.puerto.dao.ProfesorDAO;
import org.junit.Test;

import static org.mockito.Matchers.anyLong;
import static org.mockito.Matchers.anyObject;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class ActualizarHorarioProfesorServicioTest {

    @Test
    public void validarExistenciaPreviaHorarioTest() {
        HorariosProfesor horariosProfesor = new HorariosProfesorTestDataBuilder().build();
        HorariosProfesorRepositorio horariosProfesorRepositorio = mock(HorariosProfesorRepositorio.class);
        when(horariosProfesorRepositorio.existeConId(anyObject())).thenReturn(false);
        ProfesorDAO profesorDAO = mock(ProfesorDAO.class);
        ProfesorDTO profesorDTO = mock(ProfesorDTO.class);
        when(profesorDAO.obtener(anyLong())).thenReturn(profesorDTO);
        ActualizarHorarioProfesorServicio actualizarHorarioProfesorServicio = new ActualizarHorarioProfesorServicio(horariosProfesorRepositorio, profesorDAO);


        BasePrueba.assertThrows(() -> actualizarHorarioProfesorServicio.ejecutar(horariosProfesor), ExcepcionDuplicidad.class, "El horario no existe en el sistema");
    }


    @Test
    public void validarExistenciaPreviaProfesorTest() {
        HorariosProfesor horariosProfesor = new HorariosProfesorTestDataBuilder().build();
        HorariosProfesorRepositorio horariosProfesorRepositorio = mock(HorariosProfesorRepositorio.class);
        when(horariosProfesorRepositorio.existeConId(anyObject())).thenReturn(true);
        ProfesorDAO profesorDAO = mock(ProfesorDAO.class);
        when(profesorDAO.obtener(anyLong())).thenReturn(null);
        ActualizarHorarioProfesorServicio actualizarHorarioProfesorServicio = new ActualizarHorarioProfesorServicio(horariosProfesorRepositorio, profesorDAO);


        BasePrueba.assertThrows(() -> actualizarHorarioProfesorServicio.ejecutar(horariosProfesor), ExcepcionValorInvalido.class, "El id del profesor no existe");
    }

    @Test
    public void validarFlujoNormalIngresarHorario() {
        HorariosProfesor horariosProfesor = new HorariosProfesorTestDataBuilder().build();
        HorariosProfesorRepositorio horariosProfesorRepositorio = mock(HorariosProfesorRepositorio.class);
        when(horariosProfesorRepositorio.existeConId(anyObject())).thenReturn(true);
        ProfesorDAO profesorDAO = mock(ProfesorDAO.class);
        ProfesorDTO profesorDTO = mock(ProfesorDTO.class);
        when(profesorDAO.obtener(anyLong())).thenReturn(profesorDTO);
        ActualizarHorarioProfesorServicio actualizarHorarioProfesorServicio = new ActualizarHorarioProfesorServicio(horariosProfesorRepositorio, profesorDAO);

        actualizarHorarioProfesorServicio.ejecutar(horariosProfesor);

    }
}