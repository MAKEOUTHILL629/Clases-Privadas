package com.ceiba.persona.servicio;

import com.ceiba.BasePrueba;
import com.ceiba.dominio.excepcion.ExcepcionDuplicidad;
import com.ceiba.dominio.excepcion.ExcepcionLongitudValor;
import com.ceiba.persona.modelo.entidad.Persona;
import com.ceiba.persona.puerto.repositorio.PersonaRepositorio;
import com.ceiba.persona.servicio.testdatabuilder.PersonaTestDataBuilder;
import org.junit.Test;

import static org.mockito.Matchers.anyString;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class CrearPersonaServicioTest {


    @Test
    public void validarCedulaLongitudMenor10Test() {
        PersonaTestDataBuilder personaTestDataBuilder = new PersonaTestDataBuilder().setCedula("123456789");

        BasePrueba.assertThrows(()-> personaTestDataBuilder.build(), ExcepcionLongitudValor.class, "La cedula debe tener una longitud igual a 10");
    }

    @Test
    public void validarCedulaLongitudMayor10Test() {
        PersonaTestDataBuilder personaTestDataBuilder = new PersonaTestDataBuilder().setCedula("12345678911");

        BasePrueba.assertThrows(()-> personaTestDataBuilder.build(), ExcepcionLongitudValor.class, "La cedula debe tener una longitud igual a 10");
    }


    @Test
    public void validarPersonaExistenciaPreviaTest() {
        Persona persona = new PersonaTestDataBuilder().build();
        PersonaRepositorio repositorio = mock(PersonaRepositorio.class);
        when(repositorio.existe(anyString())).thenReturn(true);
        CrearPersonaServicio servicio = new CrearPersonaServicio(repositorio);

        BasePrueba.assertThrows(()-> servicio.ejecutar(persona), ExcepcionDuplicidad.class, "La persona ya existe en el sistema");
    }
}