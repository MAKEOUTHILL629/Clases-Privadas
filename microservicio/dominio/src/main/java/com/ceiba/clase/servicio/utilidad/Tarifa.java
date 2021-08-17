package com.ceiba.clase.servicio.utilidad;

import com.ceiba.estudiante.modelo.entidad.Estudiante;

public class Tarifa {
    private static final Double TARIFA_UNIVERSIDAD = 65000D;
    private static final Double TARIFA_SECUNDARIA = 55000D;
    private static final Double TARIFA_PRIMARIA = 45000D;

    public static Double generarTarifa(Estudiante estudiante){
        switch (estudiante.getNivelEstudios()){
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
