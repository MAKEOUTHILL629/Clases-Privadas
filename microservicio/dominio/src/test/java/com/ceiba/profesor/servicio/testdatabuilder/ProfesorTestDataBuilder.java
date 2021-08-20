package com.ceiba.profesor.servicio.testdatabuilder;

import com.ceiba.persona.modelo.entidad.Persona;
import com.ceiba.profesor.modelo.entidad.Profesor;

public class ProfesorTestDataBuilder {
    private Long id;
    private Persona persona;
    private String profesion;

    public ProfesorTestDataBuilder() {
        persona = new Persona("prueba_nom","prueba_apell","1234567890");
        persona.setId(1l);
        profesion = "profesion prueba";
    }

    public ProfesorTestDataBuilder setId(Long id) {
        this.id = id;
        return this;
    }

    public ProfesorTestDataBuilder setPersona(Persona persona) {
        this.persona = persona;
        return this;
    }

    public ProfesorTestDataBuilder setProfesion(String profesion) {
        this.profesion = profesion;
        return this;
    }

    public Profesor build(){
        Profesor profesor = new Profesor(persona,profesion);
        profesor.setId(id);
        return  profesor;
    }
}
