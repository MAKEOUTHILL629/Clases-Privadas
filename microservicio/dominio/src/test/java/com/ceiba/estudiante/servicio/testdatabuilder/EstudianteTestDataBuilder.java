package com.ceiba.estudiante.servicio.testdatabuilder;

import com.ceiba.estudiante.modelo.entidad.Estudiante;
import com.ceiba.persona.modelo.entidad.Persona;

public class EstudianteTestDataBuilder {
    private Long id;
    private Persona persona;
    private String nivelEstudios;

    public EstudianteTestDataBuilder() {
        this.nivelEstudios = "Universidad";
        this.persona = new Persona(1L, "prueba_nom", "prueba_apell", "1234567890");
        this.id = 1L;
    }

    public EstudianteTestDataBuilder setId(Long id) {
        this.id = id;
        return this;
    }

    public EstudianteTestDataBuilder setPersona(Persona persona) {
        this.persona = persona;
        return this;
    }

    public EstudianteTestDataBuilder setNivelEstudios(String nivelEstudios) {
        this.nivelEstudios = nivelEstudios;
        return this;
    }

    public Estudiante build(){
        return new Estudiante(id, persona, nivelEstudios);
    }
}
