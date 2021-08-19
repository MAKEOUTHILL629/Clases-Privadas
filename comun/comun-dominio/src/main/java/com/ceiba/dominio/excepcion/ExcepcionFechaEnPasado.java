package com.ceiba.dominio.excepcion;

public class ExcepcionFechaEnPasado extends RuntimeException {
    private static final long serialVersionUID = 1L;

    public ExcepcionFechaEnPasado(String message) {
        super(message);
    }
}
