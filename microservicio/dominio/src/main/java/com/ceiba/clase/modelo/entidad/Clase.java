package com.ceiba.clase.modelo.entidad;

import com.ceiba.estudiante.modelo.entidad.Estudiante;
import com.ceiba.profesor.modelo.entidad.Profesor;
import lombok.Getter;

import java.time.LocalDateTime;

import static com.ceiba.dominio.ValidadorArgumento.validarObligatorio;
import static com.ceiba.dominio.ValidadorArgumento.validarPositivo;
@Getter
public class Clase {
    private static final String SE_DEBE_INGRESAR_UN_ID_REFERENTE_AL_PROFESOR = "Se debe ingresar el id del profesor";
    private static final String SE_DEBE_INGRESAR_UN_ID_REFERENTE_AL_ESTUDIANTE = "Se debe ingresar el id del estudiante";
    private static final String SE_DEBE_INGRESAR_LA_FECHA_DE_LA_CLASE = "Se debe ingresar la fecha de cuando se hizo la clase";
    private static final String SE_DEBE_INGRESAR_EL_VALOR_DE_LA_CLASE = "Se debe ingresar el valor de la clase privada";
    private static final String SE_DEBE_INGRESAR_UN_VALOR_POSITIVO = "Se debe ingresar un valor positivo";

    private Long id;
    private Estudiante estudiante;
    private Profesor profesor;
    private LocalDateTime fecha;
    private Double valor;


    public Clase(Long id, Estudiante estudiante, Profesor profesor, LocalDateTime fecha, Double valor) {
        validarObligatorio(estudiante, SE_DEBE_INGRESAR_UN_ID_REFERENTE_AL_ESTUDIANTE);
        validarObligatorio(profesor, SE_DEBE_INGRESAR_UN_ID_REFERENTE_AL_PROFESOR);
        validarObligatorio(fecha,SE_DEBE_INGRESAR_LA_FECHA_DE_LA_CLASE);


        this.id = id;
        this.estudiante = estudiante;
        this.profesor = profesor;
        this.fecha = fecha;
        this.valor = valor;
    }
}
