package com.ceiba.clase.modelo.entidad;

import com.ceiba.estudiante.modelo.entidad.Estudiante;
import com.ceiba.profesor.modelo.entidad.Profesor;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

import static com.ceiba.dominio.ValidadorArgumento.validarObligatorio;
import static com.ceiba.dominio.ValidadorArgumento.validarPositivo;
import static com.ceiba.excepcion.ValidacionArgumento.validarFechaFuturo;
import static com.ceiba.excepcion.ValidacionArgumento.validarNumeroMayorUno;

@Getter
public class Clase {
    private static final String SE_DEBE_INGRESAR_UN_ID_REFERENTE_AL_PROFESOR = "Se debe ingresar el id del profesor";
    private static final String SE_DEBE_INGRESAR_UN_ID_REFERENTE_AL_ESTUDIANTE = "Se debe ingresar el id del estudiante";
    private static final String SE_DEBE_INGRESAR_LA_FECHA_DE_LA_CLASE = "Se debe ingresar la fecha de cuando se hizo la clase";
    private static final String LA_FECHA_DEBE_ESTAR_EN_FUTURO = "Se debe ingresar una fecha en futuro, para agendar la clase";
    private static final String EL_ID_DEL_PROFESOR_DEBE_EXISTIR = "El id del profesor no es valido ";
    private static final String EL_ID_DEL_ESTUDIANTE_DEBE_EXISTIR = "El id del estudiante no es valido ";
    @Setter
    private Long id;
    private Estudiante estudiante;
    private Profesor profesor;
    private LocalDateTime fecha;
    @Setter
    private Double valor;

    public Clase(Estudiante estudiante, Profesor profesor, LocalDateTime fecha) {
        validarObligatorio(estudiante, SE_DEBE_INGRESAR_UN_ID_REFERENTE_AL_ESTUDIANTE);
        validarNumeroMayorUno(estudiante.getId(), EL_ID_DEL_ESTUDIANTE_DEBE_EXISTIR);
        validarObligatorio(profesor, SE_DEBE_INGRESAR_UN_ID_REFERENTE_AL_PROFESOR);
        validarNumeroMayorUno(profesor.getId(), EL_ID_DEL_PROFESOR_DEBE_EXISTIR);
        validarObligatorio(fecha, SE_DEBE_INGRESAR_LA_FECHA_DE_LA_CLASE);
        validarFechaFuturo(fecha, LA_FECHA_DEBE_ESTAR_EN_FUTURO);
        this.estudiante = estudiante;
        this.profesor = profesor;
        this.fecha = fecha;
    }
}
