package com.ceiba.clase.servicio.utilidad;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;


public class ValidarFecha {

    private ValidarFecha(){
        throw new IllegalStateException("Utility class");
    }

    public static Boolean esDomingoOSabado(LocalDateTime fechaEvaluar){
        LocalDate date = fechaEvaluar.toLocalDate();
        return date.getDayOfWeek() == DayOfWeek.SATURDAY || date.getDayOfWeek() == DayOfWeek.SUNDAY;
    }

    public static Boolean esFechaHoyPeroMasTarde(LocalDateTime fechaEvaluar){

        LocalTime localTime = LocalTime.now();
        LocalTime actual = fechaEvaluar.toLocalTime();
        return localTime.isBefore(actual);
    }

    public static Boolean esPasado(LocalDateTime fechaEvaluar){
        LocalDate dateActual = LocalDate.now();
        LocalDate dateComparar = fechaEvaluar.toLocalDate();
        return dateActual.isAfter(dateComparar);
    }




}
