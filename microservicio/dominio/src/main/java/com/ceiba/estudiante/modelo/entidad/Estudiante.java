package com.ceiba.estudiante.modelo.entidad;

import com.ceiba.persona.modelo.entidad.Persona;
import lombok.Getter;

import static com.ceiba.dominio.ValidadorArgumento.validarLongitud;
import static com.ceiba.dominio.ValidadorArgumento.validarObligatorio;

@Getter
public class Estudiante {
    private static final String SE_DEBE_INGRESAR_EL_ID_DE_LA_PERSONA = "Se debe ingresar el id de la persona";
    private static final String SE_DEBE_INGRESAR_EL_NIVEL_DE_ESTUDIOS = "Se debe ingresar el nivel de estudios";

    private Long id;
    private Persona persona;
    private String nivelEstudios;

    public Estudiante(Long id) {
        this.id = id;
    }

    public Estudiante(Long id, Persona persona, String nivelEstudios) {
        validarObligatorio(persona, SE_DEBE_INGRESAR_EL_ID_DE_LA_PERSONA);
        validarObligatorio(nivelEstudios, SE_DEBE_INGRESAR_EL_NIVEL_DE_ESTUDIOS);

        this.id = id;
        this.persona = persona;
        this.nivelEstudios = nivelEstudios;
    }
}
