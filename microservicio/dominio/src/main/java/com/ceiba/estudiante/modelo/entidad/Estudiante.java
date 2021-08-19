package com.ceiba.estudiante.modelo.entidad;

import com.ceiba.estudiante.modelo.clasificacion.NivelEstudios;
import com.ceiba.persona.modelo.entidad.Persona;
import lombok.Getter;
import lombok.Setter;

import static com.ceiba.dominio.ValidadorArgumento.validarObligatorio;

@Getter
public class Estudiante {
    private static final String SE_DEBE_INGRESAR_EL_ID_DE_LA_PERSONA = "Se debe ingresar el id de la persona";
    private static final String SE_DEBE_INGRESAR_EL_NIVEL_DE_ESTUDIOS = "Se debe ingresar el nivel de estudios";
    @Setter
    private Long id;
    @Setter
    private Persona persona;
    private NivelEstudios nivelEstudios;

    public Estudiante(Long id) {
        this.id = id;
    }

    public Estudiante(NivelEstudios nivelEstudios) {
        validarObligatorio(nivelEstudios, SE_DEBE_INGRESAR_EL_NIVEL_DE_ESTUDIOS);
        this.nivelEstudios = nivelEstudios;
    }

    public Estudiante(Persona persona, NivelEstudios nivelEstudios) {
        validarObligatorio(persona, SE_DEBE_INGRESAR_EL_ID_DE_LA_PERSONA);
        validarObligatorio(nivelEstudios, SE_DEBE_INGRESAR_EL_NIVEL_DE_ESTUDIOS);

        this.id = id;
        this.persona = persona;
        this.nivelEstudios = nivelEstudios;
    }
}
