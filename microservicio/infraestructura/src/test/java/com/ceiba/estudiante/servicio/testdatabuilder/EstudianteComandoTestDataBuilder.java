package com.ceiba.estudiante.servicio.testdatabuilder;

import com.ceiba.estudiante.comando.EstudianteComando;

public class EstudianteComandoTestDataBuilder {
    private Long id;
    private Long idPersona;
    private String nivelEstudios;

    public EstudianteComandoTestDataBuilder() {
        this.idPersona = 20L;
        this.nivelEstudios = "PRIMARIA";
    }

    public EstudianteComandoTestDataBuilder setId(Long id) {
        this.id = id;
        return this;
    }

    public EstudianteComandoTestDataBuilder setIdPersona(Long idPersona) {
        this.idPersona = idPersona;
        return this;
    }

    public EstudianteComandoTestDataBuilder setNivelEstudios(String nivelEstudios) {
        this.nivelEstudios = nivelEstudios;
        return this;
    }

    public EstudianteComando build(){
        return new EstudianteComando(id,idPersona,nivelEstudios);
    }
}