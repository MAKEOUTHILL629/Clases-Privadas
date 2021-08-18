package com.ceiba.clase.servicio.testdatabuilder;

import com.ceiba.clase.comando.comando.ClaseComandoCrear;

import java.time.LocalDateTime;

public class ClaseComandoCrearTestDataBuilder {
    private Long idEstudiante;
    private Long idProfesor;
    private LocalDateTime fecha;

    public ClaseComandoCrearTestDataBuilder() {
        this.idEstudiante = 1l;
        this.idProfesor = 2l;
        this.fecha = LocalDateTime.now().plusHours(2);
    }

    public ClaseComandoCrearTestDataBuilder setIdEstudiante(Long idEstudiante) {
        this.idEstudiante = idEstudiante;
        return this;
    }

    public ClaseComandoCrearTestDataBuilder setIdProfesor(Long idProfesor) {
        this.idProfesor = idProfesor;
        return this;
    }

    public ClaseComandoCrearTestDataBuilder setFecha(LocalDateTime fecha) {
        this.fecha = fecha;
        return this;
    }

    public ClaseComandoCrear build(){
        return new ClaseComandoCrear(idEstudiante,idProfesor,fecha);
    }
}
