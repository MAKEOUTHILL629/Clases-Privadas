package com.ceiba.clase.servicio.utilidad;

import org.junit.Test;

import java.time.LocalDateTime;

import static org.junit.Assert.*;

public class ValidarFechaTest {

    @Test
    public void validarDomingo() {
        LocalDateTime fechaActual = LocalDateTime.of(2021, 8, 15, 2, 30);

        Boolean actual = ValidarFecha.esDomingoOSabado(fechaActual);

        assertTrue(actual);
    }

    @Test
    public void validarSabado() {
        LocalDateTime fechaActual = LocalDateTime.of(2021, 8, 14, 1, 45);

        Boolean actual = ValidarFecha.esDomingoOSabado(fechaActual);

        assertTrue(actual);
    }

    @Test
    public void validarDiaEntreSemana() {
        LocalDateTime fechaActual = LocalDateTime.of(2021, 8, 16, 1, 45);

        Boolean actual = ValidarFecha.esDomingoOSabado(fechaActual);

        assertFalse(actual);
    }

    @Test
    public void validarFechaEsHoyPeroMasTemprano() {
        LocalDateTime dateActual = LocalDateTime.now().plusHours(2);

        Boolean actual = ValidarFecha.esFechaHoyPeroMasTarde(dateActual);

        assertTrue(actual);
    }

    @Test
    public void validarFechaNoEsHoy() {
        LocalDateTime dateActual = LocalDateTime.now().plusDays(1);

        Boolean actual = ValidarFecha.esFechaHoyPeroMasTarde(dateActual);

        assertFalse(actual);
    }

    @Test
    public void validarFechaEsHoyPeroMasTarde() {
        LocalDateTime dateActual = LocalDateTime.now().plusHours(1);

        Boolean actual = ValidarFecha.esFechaHoyPeroMasTarde(dateActual);

        assertTrue(actual);
    }


    @Test
    public void validarEsAyer() {
        LocalDateTime dateActual = LocalDateTime.now().plusDays(-1);

        Boolean actual = ValidarFecha.esPasado(dateActual);

        assertTrue(actual);
    }


    @Test
    public void validarEsManiana() {
        LocalDateTime dateActual = LocalDateTime.now().plusDays(1);

        Boolean actual = ValidarFecha.esPasado(dateActual);

        assertFalse(actual);
    }
}