package com.ceiba.excepcion;

import com.ceiba.dominio.excepcion.ExcepcionValorInvalido;
import com.ceiba.excepcion.excepciones.ExcepcionFechaEnPasado;

import java.time.LocalDateTime;

public class ValidacionArgumento {

    private ValidacionArgumento(){

    }
    public static void validarFechaFuturo(LocalDateTime fecha, String mensaje){
        if(LocalDateTime.now().isAfter(fecha)){
            throw new ExcepcionFechaEnPasado(mensaje);
        }
    }

    public static  void validarNumeroMayorUno(Long id, String mensaje){
        if(id <= 0){
            throw new ExcepcionValorInvalido(mensaje);
        }
    }
}
