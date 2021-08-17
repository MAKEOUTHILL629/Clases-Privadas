package com.ceiba.persona.modelo.entidad;


import lombok.Getter;

import static com.ceiba.dominio.ValidadorArgumento.*;

@Getter
public class Persona {

    private static final String LA_CEDULA_DEBE_TENER_UNA_LONGITUD_IGUAL_A = "La cedula debe tener una longitud igual a 10";
    private static final String SE_DEBE_INGRESAR_LA_CEDULA = "Se debe ingresar la cedula";
    private static final String SE_DEBE_INGRESAR_EL_NOMBRE_DE_USUARIO = "Se debe ingresar los nombres de usuario";
    private static final String SE_DEBE_INGRESAR_EL_APELLIDOS_DE_USUARIO = "Se debe ingresar los apellidos de usuario";
    private static final int LONGITUD_CEDULA = 10;

    private Long id;
    private String nombres;
    private String apellidos;
    private String cedula;

    public Persona(Long id){
        this.id =id;

    }

    public Persona(Long id, String nombres, String apellidos, String cedula) {
        validarObligatorio(nombres, SE_DEBE_INGRESAR_EL_NOMBRE_DE_USUARIO);
        validarObligatorio(apellidos, SE_DEBE_INGRESAR_EL_APELLIDOS_DE_USUARIO);
        validarObligatorio(cedula, SE_DEBE_INGRESAR_LA_CEDULA);
        validarLongitudExacta(cedula, LONGITUD_CEDULA, LA_CEDULA_DEBE_TENER_UNA_LONGITUD_IGUAL_A);


        this.id = id;
        this.nombres = nombres;
        this.apellidos = apellidos;
        this.cedula = cedula;

    }


}
