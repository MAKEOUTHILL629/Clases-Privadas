package com.ceiba.clase.servicio.testdatabuilder;

import com.ceiba.clase.comando.ClaseComando;

import java.time.LocalDateTime;

public class ClaseComandoTestDataBuilder {

    private Long idEstudiante;
    private Long idProfesor;
    private LocalDateTime fecha;


    public ClaseComandoTestDataBuilder() {
        this.idEstudiante = 6l;
        this.idProfesor = 3l;
        this.fecha = LocalDateTime.now().plusHours(2);

    }


    public ClaseComandoTestDataBuilder setIdEstudiante(Long idEstudiante) {
        this.idEstudiante = idEstudiante;
        return this;
    }

    public ClaseComandoTestDataBuilder setIdProfesor(Long idProfesor) {
        this.idProfesor = idProfesor;
        return this;
    }

    public ClaseComandoTestDataBuilder setFecha(LocalDateTime fecha) {
        this.fecha = fecha;
        return this;
    }


    public ClaseComando build() {
        return new ClaseComando(idEstudiante, idProfesor, fecha);
    }
}
