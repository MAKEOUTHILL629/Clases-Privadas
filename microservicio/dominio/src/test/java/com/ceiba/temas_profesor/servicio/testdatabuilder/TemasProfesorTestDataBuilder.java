package com.ceiba.temas_profesor.servicio.testdatabuilder;

import com.ceiba.profesor.modelo.entidad.Profesor;
import com.ceiba.profesor.servicio.testdatabuilder.ProfesorTestDataBuilder;
import com.ceiba.temas_profesor.modelo.entidad.TemasProfesor;

public class TemasProfesorTestDataBuilder {

    private Long id;
    private Profesor profesor;
    private String tema;

    public TemasProfesorTestDataBuilder() {
        this.id = 1l;
        this.profesor = new ProfesorTestDataBuilder().setId(2l).build();
        this.tema = "PROGRAMACION";
    }

    public TemasProfesorTestDataBuilder setId(Long id) {
        this.id = id;
        return this;
    }

    public TemasProfesorTestDataBuilder setProfesor(Profesor profesor) {
        this.profesor = profesor;
        return this;
    }

    public TemasProfesorTestDataBuilder setTema(String tema) {
        this.tema = tema;
        return this;
    }

    public TemasProfesor build(){
        TemasProfesor temasProfesor = new TemasProfesor(profesor,tema);
        temasProfesor.setId(id);
        return temasProfesor;
    }
}
