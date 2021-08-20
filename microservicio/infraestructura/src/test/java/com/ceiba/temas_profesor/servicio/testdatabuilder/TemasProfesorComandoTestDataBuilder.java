package com.ceiba.temas_profesor.servicio.testdatabuilder;

import com.ceiba.temas_profesor.comando.TemasProfesorComando;

public class TemasProfesorComandoTestDataBuilder {
    private Long id;
    private Long idProfesor;
    private String tema;

    public TemasProfesorComandoTestDataBuilder() {
        this.idProfesor = 5l;
        this.tema = "Injeccion SQL";
    }

    public TemasProfesorComandoTestDataBuilder setId(Long id) {
        this.id = id;
        return this;
    }

    public TemasProfesorComandoTestDataBuilder setIdProfesor(Long idProfesor) {
        this.idProfesor = idProfesor;
        return this;
    }

    public TemasProfesorComandoTestDataBuilder setTema(String tema) {
        this.tema = tema;
        return this;
    }

    public TemasProfesorComando build(){
        return new TemasProfesorComando( idProfesor,tema);
    }
}
