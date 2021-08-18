package com.ceiba.clase.servicio;

import com.ceiba.BasePrueba;
import com.ceiba.clase.modelo.entidad.Clase;
import com.ceiba.clase.puerto.repositorio.ClaseRepositorio;
import com.ceiba.clase.servicio.testdatabuilder.ClaseTestDataBuilder;
import com.ceiba.clase.servicio.utilidad.GenerarValor;
import com.ceiba.dominio.excepcion.ExcepcionDuplicidad;
import com.ceiba.dominio.excepcion.ExcepcionSinDatos;
import com.ceiba.estudiante.modelo.clasificacion.NivelEstudios;
import com.ceiba.estudiante.modelo.dto.EstudianteDTO;
import com.ceiba.estudiante.puerto.dao.EstudianteDAO;
import com.ceiba.estudiante.servicio.testdatabuilder.EstudianteTestDataBuilder;
import com.ceiba.persona.modelo.dto.PersonaDTO;
import com.ceiba.profesor.modelo.dto.ProfesorDTO;
import com.ceiba.profesor.puerto.dao.ProfesorDAO;
import org.junit.Test;

import java.time.LocalDateTime;

import static org.junit.Assert.*;
import static org.mockito.Matchers.anyObject;
import static org.mockito.Mockito.*;

public class CrearClaseServicioTest {

    @Test
    public void validarEsRepetidaLaClase() {
        Clase clase = new ClaseTestDataBuilder()
                .setEstudiante(new EstudianteTestDataBuilder().setNivelEstudios("UNIVERSIDAD").build())
                .setFecha(LocalDateTime.now().plusHours(2)).build();
        ClaseRepositorio claseRepositorio = mock(ClaseRepositorio.class);
        when(claseRepositorio.esRepetido(anyObject())).thenReturn(true);
        EstudianteDAO estudianteDAO = mock(EstudianteDAO.class);
        when(estudianteDAO.obtener(anyLong())).thenReturn(null);
        ProfesorDAO profesorDAO = mock(ProfesorDAO.class);
        when(profesorDAO.obtener(anyLong())).thenReturn(null);
        CrearClaseServicio servicio = new CrearClaseServicio(claseRepositorio, estudianteDAO, profesorDAO);

        BasePrueba.assertThrows(()-> servicio.ejecutar(clase) , ExcepcionDuplicidad.class, "La clase ya se encuentra en el sistema");
    }

    @Test
    public void validarEstudianteSinId() {
        Clase clase = new ClaseTestDataBuilder()
                .setEstudiante(new EstudianteTestDataBuilder().setNivelEstudios("UNIVERSIDAD").build())
                .setFecha(LocalDateTime.now().plusHours(2)).build();
        ClaseRepositorio claseRepositorio = mock(ClaseRepositorio.class);
        when(claseRepositorio.esRepetido(anyObject())).thenReturn(false);
        EstudianteDAO estudianteDAO = mock(EstudianteDAO.class);
        when(estudianteDAO.obtener(anyLong())).thenReturn(null);
        ProfesorDAO profesorDAO = mock(ProfesorDAO.class);
        when(profesorDAO.obtener(anyLong())).thenReturn(null);
        CrearClaseServicio crearClaseServicio = new CrearClaseServicio(claseRepositorio, estudianteDAO, profesorDAO);

        BasePrueba.assertThrows(()-> crearClaseServicio.ejecutar(clase) , ExcepcionSinDatos.class, "El id del profesor no se encuentra en el sistema");
    }

    @Test
    public void validarGuardarClaseNormal() {
        Clase clase = new ClaseTestDataBuilder()
                .setEstudiante(new EstudianteTestDataBuilder().setNivelEstudios("UNIVERSIDAD").build())
                .setFecha(LocalDateTime.now().plusHours(2)).build();
        ClaseRepositorio claseRepositorio = mock(ClaseRepositorio.class);
        when(claseRepositorio.esRepetido(anyObject())).thenReturn(false);
        EstudianteDAO estudianteDAO = mock(EstudianteDAO.class);
        ProfesorDAO profesorDAO = mock(ProfesorDAO.class);
        EstudianteDTO estudianteDTO = mock(EstudianteDTO.class);
        when(estudianteDTO.getNivelEstudios()).thenReturn(NivelEstudios.UNIVERSIDAD);
        when(estudianteDAO.obtener(anyLong())).thenReturn(estudianteDTO);
        ProfesorDTO profesorDTO = mock(ProfesorDTO.class);
        when(profesorDTO.getId()).thenReturn(1l);
        when(profesorDAO.obtener(anyLong())).thenReturn(profesorDTO);
        CrearClaseServicio crearClaseServicio = new CrearClaseServicio(claseRepositorio, estudianteDAO, profesorDAO);

        assertNotNull(crearClaseServicio.ejecutar(clase));
    }
}