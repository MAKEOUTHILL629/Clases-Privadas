package com.ceiba.clase.servicio.testdatabuilder;

import com.ceiba.clase.modelo.entidad.Clase;
import com.ceiba.estudiante.modelo.entidad.Estudiante;
import com.ceiba.profesor.modelo.entidad.Profesor;

import java.time.LocalDateTime;

public class ClaseTestDataBuilder {
    private Long id;
    private Estudiante estudiante;
    private Profesor profesor;
    private LocalDateTime fecha;
    private Double valor;

    public ClaseTestDataBuilder() {
        this.id = 1L;
        this.estudiante = new Estudiante(1L);
        this.profesor = new Profesor(1L);
        this.fecha = LocalDateTime.now();
        this.valor = 30000d;
    }

    public ClaseTestDataBuilder setId(Long id) {
        this.id = id;
        return  this;
    }

    public ClaseTestDataBuilder setEstudiante(Estudiante estudiante) {
        this.estudiante = estudiante;
        return  this;
    }

    public ClaseTestDataBuilder setProfesor(Profesor profesor) {
        this.profesor = profesor;
        return  this;
    }

    public ClaseTestDataBuilder setFecha(LocalDateTime fecha) {
        this.fecha = fecha;
        return  this;
    }

    public ClaseTestDataBuilder setValor(Double valor) {
        this.valor = valor;
        return  this;
    }

    public Clase build(){
        return new Clase(id,estudiante,profesor,fecha,valor);
    }
}
