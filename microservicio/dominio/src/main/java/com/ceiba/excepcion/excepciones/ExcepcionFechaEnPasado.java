package com.ceiba.excepcion.excepciones;

public class ExcepcionFechaEnPasado extends RuntimeException{
    private static final long serialVersionUID = 1L;

    public ExcepcionFechaEnPasado(String message) {
        super(message);
    }
}
