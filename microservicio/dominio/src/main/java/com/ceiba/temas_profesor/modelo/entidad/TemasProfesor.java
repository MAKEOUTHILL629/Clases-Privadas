package com.ceiba.temas_profesor.modelo.entidad;

import com.ceiba.profesor.modelo.entidad.Profesor;
import lombok.Getter;

import static com.ceiba.dominio.ValidadorArgumento.validarObligatorio;
@Getter
public class TemasProfesor {
    private static final String SE_DEBE_INGRESAR_EL_ID_DEL_PROFESOR ="Se debe ingresar la referencia al profesor";
    private static final String SE_DEBE_INGRESAR_EL_TEMA = "Se debe ingresar un tema";
    private Long id;
    private Profesor profesor;
    private String tema;

    public TemasProfesor(Long id, Profesor profesor, String tema) {
        validarObligatorio(profesor, SE_DEBE_INGRESAR_EL_ID_DEL_PROFESOR );
        validarObligatorio(tema, SE_DEBE_INGRESAR_EL_TEMA);
        this.id = id;
        this.profesor = profesor;
        this.tema = tema;
    }
}
