package com.ceiba.clase.servicio.utilidad;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;


public class ValidarFecha {

    public static Boolean esDomingoOSabado(LocalDateTime dateTime){
        LocalDate date = dateTime.toLocalDate();
        return date.getDayOfWeek() == DayOfWeek.SATURDAY || date.getDayOfWeek() == DayOfWeek.SUNDAY;
    }

    public static Boolean esFechaHoyPeroMasTarde(LocalDateTime dateTime){

        LocalTime localTime = LocalTime.now();
        LocalTime actual = dateTime.toLocalTime();
        return localTime.isBefore(actual);
    }

    public static Boolean esPasado(LocalDateTime dateTime){
        LocalDate dateActual = LocalDate.now();
        LocalDate dateComparar = dateTime.toLocalDate();
        return dateActual.isAfter(dateComparar);
    }




}
