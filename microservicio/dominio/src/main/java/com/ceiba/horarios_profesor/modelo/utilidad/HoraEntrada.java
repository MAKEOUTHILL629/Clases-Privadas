package com.ceiba.horarios_profesor.modelo.utilidad;

import lombok.AllArgsConstructor;

import java.time.LocalTime;

import static com.ceiba.dominio.ValidadorArgumento.validarNumeroSeEncuentreEnUnRango;


public class HoraEntrada {


    public static final String LA_HORA_NO_ES_VALIDA = "La hora no es valida";

    private  HoraEntrada(){
         throw new IllegalStateException("Clase de utilidad");
    }
    public static LocalTime parsearHora(String horaParsear){
        String[] horaDividada = horaParsear.split(":");
        Long hora =  Long.parseLong(horaDividada[0]);
        validarNumeroSeEncuentreEnUnRango(hora , 0l,24l,  LA_HORA_NO_ES_VALIDA);
        Long minutos = Long.parseLong(horaDividada[1]);
        validarNumeroSeEncuentreEnUnRango(minutos , 0l,60l,  LA_HORA_NO_ES_VALIDA);
        return LocalTime.of(hora.intValue(), minutos.intValue());
    }
}
