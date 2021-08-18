package com.ceiba.clase.servicio.utilidad;

import com.ceiba.estudiante.modelo.entidad.Estudiante;
import com.ceiba.estudiante.servicio.testdatabuilder.EstudianteTestDataBuilder;
import org.junit.Test;

import static org.junit.Assert.*;

public class TarifaTest {

    @Test
    public void validarUniversitario() {
        Estudiante estudiante =new EstudianteTestDataBuilder().setNivelEstudios("UNIVERSIDAD").build();

        Double tarifa = Tarifa.generarTarifa(estudiante.getNivelEstudios());

        assertEquals(65000D,tarifa,0);
    }


    @Test
    public void validarSecundaria() {
        Estudiante estudiante =new EstudianteTestDataBuilder().setNivelEstudios("SECUNDARIA").build();

        Double tarifa = Tarifa.generarTarifa(estudiante.getNivelEstudios());

        assertEquals(55000D,tarifa,0);
    }

    @Test
    public void validarPrimaria() {
        Estudiante estudiante =new EstudianteTestDataBuilder().setNivelEstudios("PRIMARIA").build();

        Double tarifa = Tarifa.generarTarifa(estudiante.getNivelEstudios());

        assertEquals(45000D,tarifa,0);
    }
}