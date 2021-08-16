package com.ceiba.horarios_profesor.modelo.entidad;

import com.ceiba.profesor.modelo.entidad.Profesor;
import lombok.Getter;

import java.time.LocalTime;

import static com.ceiba.dominio.ValidadorArgumento.validarObligatorio;

@Getter
public class HorariosProfesor {
    private static final String SE_DEBE_INGRESAR_EL_ID_DEL_PROFESOR ="Se debe ingresar la referencia al profesor";
    private static final String SE_DEBE_INGRESAR_EL_DIA_DISPONIBLE = "Se debe ingresar el dia que disponible";
    private static final String SE_DEBE_INGRESAR_LA_HORA_DISPONIBLE = "Se debe ingresar la hora disponible";
    private Long id;
    private Profesor profesor;
    private String diaSemana;
    private LocalTime hora;

    public HorariosProfesor(Long id, Profesor profesor, String diaSemana, LocalTime hora) {
        validarObligatorio(profesor, SE_DEBE_INGRESAR_EL_ID_DEL_PROFESOR );
        validarObligatorio(diaSemana, SE_DEBE_INGRESAR_EL_DIA_DISPONIBLE);
        validarObligatorio(hora, SE_DEBE_INGRESAR_LA_HORA_DISPONIBLE);
        this.id = id;
        this.profesor = profesor;
        this.diaSemana = diaSemana;
        this.hora = hora;
    }
}
