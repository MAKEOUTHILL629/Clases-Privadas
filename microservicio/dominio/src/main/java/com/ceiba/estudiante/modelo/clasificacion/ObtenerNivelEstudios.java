package com.ceiba.estudiante.modelo.clasificacion;

public class ObtenerNivelEstudios {
    private ObtenerNivelEstudios() {
        throw new IllegalStateException("Clase de utilidad");
    }

    public static NivelEstudios obtenerNivelEstudios(String nivelEstudios) {
        switch (nivelEstudios) {
            case "UNIVERSIDAD":
                return NivelEstudios.UNIVERSIDAD;
            case "SECUNDARIA":
                return NivelEstudios.SECUNDARIA;
            case "PRIMARIA":
                return NivelEstudios.PRIMARIA;
            default:
                return null;
        }
    }
}
