package com.ceiba.estudiante.servicio;


import com.ceiba.BasePrueba;
import com.ceiba.dominio.excepcion.ExcepcionDuplicidad;
import com.ceiba.estudiante.modelo.entidad.Estudiante;
import com.ceiba.estudiante.puerto.repositorio.EstudianteRepositorio;
import com.ceiba.estudiante.servicio.testdatabuilder.EstudianteTestDataBuilder;
import com.ceiba.persona.puerto.dao.PersonaDAO;
import org.junit.Test;

import static org.mockito.Matchers.anyLong;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class CrearEstudianteServicioTest {
    @Test
    public void validarEstudianteExistenciaPreviaTest() {
        Estudiante estudiante = new EstudianteTestDataBuilder().build();
        EstudianteRepositorio repositorio = mock(EstudianteRepositorio.class);
        when(repositorio.existe(anyLong())).thenReturn(true);
        PersonaDAO personaDAO = mock(PersonaDAO.class);
        CrearEstudianteServicio servicio = new CrearEstudianteServicio(repositorio,personaDAO);

        BasePrueba.assertThrows(()-> servicio.ejecutar(estudiante), ExcepcionDuplicidad.class, "La persona ya existe en el sistema");
    }
}