package com.ceiba.clase.servicio.utilidad;

import com.ceiba.estudiante.modelo.clasificacion.NivelEstudios;
import com.ceiba.estudiante.modelo.entidad.Estudiante;
import com.ceiba.estudiante.servicio.testdatabuilder.EstudianteTestDataBuilder;
import com.ceiba.persona.modelo.entidad.Persona;
import org.junit.Test;

import java.time.LocalDateTime;

import static org.junit.Assert.*;

public class GenerarValorTest {


    @Test
    public void validarDomingoYTarifaUniversidaEstudianteNuevo() {
        LocalDateTime localDateTime = LocalDateTime.of(2022,8,21,3,13);
        Boolean esNuevo = true;
        Estudiante estudiante = new EstudianteTestDataBuilder().setNivelEstudios(NivelEstudios.UNIVERSIDAD).build();
        Double tarifa = Tarifa.generarTarifa(estudiante.getNivelEstudios());

        Double valortTotal = GenerarValor.generarTotal(localDateTime,esNuevo,tarifa);

        assertEquals(69500D, valortTotal,0);
    }

    @Test
    public void validarSabadoYTarifaPrimariaEstudianteAntiguo() {
        LocalDateTime localDateTime = LocalDateTime.of(2022,8,20,3,13);
        Boolean esNuevo = false;
        Estudiante estudiante = new EstudianteTestDataBuilder().setNivelEstudios(NivelEstudios.PRIMARIA).build();
        Double tarifa = Tarifa.generarTarifa(estudiante.getNivelEstudios());

        Double valortTotal = GenerarValor.generarTotal(localDateTime,esNuevo,tarifa);

        assertEquals(58500D, valortTotal,0);
    }

    @Test
    public void validarEsHoyYTarifaSecundariaEstudianteNuevo() {
        LocalDateTime localDateTime = LocalDateTime.now().plusHours(1);
        Boolean esNuevo = true;
        Estudiante estudiante = new EstudianteTestDataBuilder().setNivelEstudios(NivelEstudios.SECUNDARIA).build();
        Double tarifa = Tarifa.generarTarifa(estudiante.getNivelEstudios());

        Double valortTotal = GenerarValor.generarTotal(localDateTime,esNuevo,tarifa);

        assertEquals(48250D, valortTotal,0);
    }
}