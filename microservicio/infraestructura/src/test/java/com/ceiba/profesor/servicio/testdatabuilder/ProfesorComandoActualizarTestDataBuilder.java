package com.ceiba.profesor.servicio.testdatabuilder;

import com.ceiba.profesor.comando.comando.ProfesorComandoActualizar;

public class ProfesorComandoActualizarTestDataBuilder {
    private String profesion;

    public ProfesorComandoActualizarTestDataBuilder() {
        this.profesion = "SCRUM MASTER";
    }

    public ProfesorComandoActualizarTestDataBuilder setProfesion(String profesion) {
        this.profesion = profesion;
        return this;
    }

    public ProfesorComandoActualizar build(){
        return new ProfesorComandoActualizar(profesion);
    }
}
