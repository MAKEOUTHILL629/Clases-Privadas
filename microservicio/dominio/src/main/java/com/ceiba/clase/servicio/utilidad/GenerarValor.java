package com.ceiba.clase.servicio.utilidad;

import com.ceiba.dominio.excepcion.ExcepcionValorInvalido;

import java.time.LocalDateTime;

public class GenerarValor {
    private static final int AUMENTO_TARIFA_SABADOS_DOMINGOS = 30;
    private static final int AUMENTO_TARIFA_DIA_ACTUAL = 15;
    private static final Double DESCUENTO_PRIMERA_CLASE = 15000D;


    private GenerarValor(){
        throw new IllegalStateException("Clase de utilidad");
    }

    public static Double generarTotal(LocalDateTime time, Boolean esEstudianteNuevo, Double tarifa){
        if(time.isBefore(LocalDateTime.now())){
            throw new ExcepcionValorInvalido("La fecha ya paso");
        }

        Double total = tarifa;


        if(ValidarFecha.esFechaHoyPeroMasTarde(time).booleanValue()){
            total += (total * AUMENTO_TARIFA_DIA_ACTUAL) /100;
        }

        if(ValidarFecha.esDomingoOSabado(time).booleanValue()){
            total += (total * AUMENTO_TARIFA_SABADOS_DOMINGOS) /100;
        }

        if(esEstudianteNuevo.booleanValue()){
            total -= DESCUENTO_PRIMERA_CLASE;
        }

        return total;
    }

}
