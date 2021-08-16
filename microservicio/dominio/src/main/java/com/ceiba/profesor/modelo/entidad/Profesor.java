package com.ceiba.profesor.modelo.entidad;

import com.ceiba.persona.modelo.entidad.Persona;
import lombok.Getter;

import static com.ceiba.dominio.ValidadorArgumento.validarObligatorio;

@Getter
public class Profesor {

    private static final String SE_DEBE_INGRESAR_EL_ID_DE_LA_PERSONA = "Se debe ingresar el id de la persona";
    private static final String SE_DEBE_INGRESAR_LA_PROFESION = "Se debe ingresar la profesion";

    private Long id;
    private Persona persona;
    private String profesion;

    public Profesor(Long id) {
        this.id = id;
    }

    public Profesor(Long id, Persona persona, String profesion) {
        validarObligatorio(persona, SE_DEBE_INGRESAR_EL_ID_DE_LA_PERSONA);
        validarObligatorio(profesion, SE_DEBE_INGRESAR_LA_PROFESION);

        this.id = id;
        this.persona = persona;
        this.profesion = profesion;
    }

}
