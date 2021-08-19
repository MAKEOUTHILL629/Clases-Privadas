package com.ceiba.clase.servicio.testdatabuilder;

import java.time.LocalDateTime;

public class ClaseComandoTestDataBuilder {
    private Long id;
    private Long idEstudiante;
    private Long idProfesor;
    private LocalDateTime fecha;
    private Double valor;

    public ClaseComandoTestDataBuilder() {
        this.idEstudiante = 6l;
        this.idProfesor = 3l;
        this.fecha = LocalDateTime.now().plusHours(2);
        this.valor = 65000D;
    }

    public ClaseComandoTestDataBuilder setId(Long id) {
        this.id = id;
        return this;
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

    public ClaseComandoTestDataBuilder setValor(Double valor) {
        this.valor = valor;
        return this;
    }

    public ClaseComandoActualizar build(){
      return new ClaseComandoActualizar(idEstudiante,idProfesor,fecha);
    }
}
