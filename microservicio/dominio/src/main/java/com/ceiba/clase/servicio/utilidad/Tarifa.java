package com.ceiba.clase.servicio.utilidad;

public class Tarifa {
    private static final Double TARIFA_UNIVERSIDAD = 65000D;
    private static final Double TARIFA_SECUNDARIA = 55000D;
    private static final Double TARIFA_PRIMARIA = 45000D;

    private Tarifa() {
        throw new IllegalStateException("Utility class");
    }

    public static Double generarTarifa(String nivelEstudios) {
        switch (nivelEstudios) {
            case "UNIVERSIDAD":
                return TARIFA_UNIVERSIDAD;

            case "SECUNDARIA":
                return TARIFA_SECUNDARIA;

            case "PRIMARIA":
                return TARIFA_PRIMARIA;

            default:
                return 1D;
        }
    }
}
