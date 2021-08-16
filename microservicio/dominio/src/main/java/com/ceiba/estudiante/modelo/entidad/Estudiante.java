package com.ceiba.estudiante.modelo.entidad;

import lombok.Getter;

import static com.ceiba.dominio.ValidadorArgumento.validarLongitud;
import static com.ceiba.dominio.ValidadorArgumento.validarObligatorio;
@Getter
public class Estudiante {
    private static final String SE_DEBE_INGRESAR_EL_NIVEL_DE_ESTUDIOS = "Se debe ingresar el nivel de estudios";
    private static final String LA_CLAVE_DEBE_TENER_UNA_LONGITUD_IGUAL_A = "La clave debe tener una longitud igual a 10";
    private static final String SE_DEBE_INGRESAR_LA_CEDULA = "Se debe ingresar la cedula";
    private static final String SE_DEBE_INGRESAR_EL_NOMBRE_DE_USUARIO = "Se debe ingresar el nombre de usuario";

    private static final int LONGITUD_CEDULA = 10;

    private Long id;
    private String first_name;
    private String last_name;
    private String cedula;
    private String nivel_estudios;


    public Estudiante(Long id, String first_name, String last_name, String cedula, String nivel_estudios) {
        validarObligatorio(first_name,SE_DEBE_INGRESAR_EL_NOMBRE_DE_USUARIO );
        validarObligatorio(last_name,SE_DEBE_INGRESAR_EL_NOMBRE_DE_USUARIO );
        validarObligatorio(cedula, SE_DEBE_INGRESAR_LA_CEDULA);
        validarLongitud(cedula, LONGITUD_CEDULA, LA_CLAVE_DEBE_TENER_UNA_LONGITUD_IGUAL_A);
        validarObligatorio(nivel_estudios,SE_DEBE_INGRESAR_EL_NIVEL_DE_ESTUDIOS );

        this.id = id;
        this.first_name = first_name;
        this.last_name = last_name;
        this.cedula = cedula;
        this.nivel_estudios = nivel_estudios;
    }
}
