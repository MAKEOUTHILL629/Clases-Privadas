package com.ceiba.persona.servicio;

import com.ceiba.BasePrueba;
import com.ceiba.dominio.excepcion.ExcepcionDuplicidad;
import com.ceiba.persona.modelo.entidad.Persona;
import com.ceiba.persona.puerto.repositorio.PersonaRepositorio;
import com.ceiba.persona.servicio.testdatabuilder.PersonaTestDataBuilder;
import org.junit.Test;
import org.junit.jupiter.api.DisplayName;
import org.mockito.Mockito;

import static org.mockito.Matchers.anyLong;
import static org.mockito.Mockito.*;

public class ActualizarPersonaServicioTest {

    @Test
    @DisplayName("Valida la existencia de la persona en la base de datos antes")
    public void validarExistenciaPersonaSistemaTest() {
        Persona persona = new PersonaTestDataBuilder().setId(1L).build();
        PersonaRepositorio repositorio = mock(PersonaRepositorio.class);
        when(repositorio.existeExcluyendoId(anyLong()))
                .thenReturn(false);
        ActualizarPersonaServicio servicio = new ActualizarPersonaServicio(repositorio);

        BasePrueba.assertThrows(() -> servicio.ejecutar(persona), ExcepcionDuplicidad.class, "La persona no existe en el sistema");

    }

    @Test
    public void validarFlujoNormaActualizacionTest() {
        Persona persona = new PersonaTestDataBuilder().setId(1L).build();
        PersonaRepositorio repositorio = mock(PersonaRepositorio.class);
        when(repositorio.existeExcluyendoId(anyLong()))
                .thenReturn(true);
        ActualizarPersonaServicio servicio = new ActualizarPersonaServicio(repositorio);

        servicio.ejecutar(persona);
        verify(repositorio).actualizar(persona);
    }
}