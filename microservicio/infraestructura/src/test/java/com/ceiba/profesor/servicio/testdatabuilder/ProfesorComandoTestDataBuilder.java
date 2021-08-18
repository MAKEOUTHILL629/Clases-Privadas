package com.ceiba.profesor.servicio.testdatabuilder;

import com.ceiba.persona.modelo.entidad.Persona;
import com.ceiba.persona.servicio.testdatabuilder.PersonaComandoTestDataBuilder;
import com.ceiba.profesor.comando.ProfesorComando;

public class ProfesorComandoTestDataBuilder {
    private Long id;
    private Long idPersona;
    private String profesion;

    public ProfesorComandoTestDataBuilder() {
        this.idPersona = 3l;
        this.profesion = "Programador";
    }

    public ProfesorComandoTestDataBuilder setId(Long id) {
        this.id = id;
        return this;
    }

    public ProfesorComandoTestDataBuilder setIdPersona(Long idPersona) {
        this.idPersona = idPersona;
        return this;
    }

    public ProfesorComandoTestDataBuilder setProfesion(String profesion) {
        this.profesion = profesion;
        return this;
    }

    public ProfesorComando build(){
        return new ProfesorComando(id,idPersona,profesion);
    }
}
