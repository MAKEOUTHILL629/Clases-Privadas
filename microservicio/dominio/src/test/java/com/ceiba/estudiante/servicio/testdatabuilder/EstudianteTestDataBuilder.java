package com.ceiba.estudiante.servicio.testdatabuilder;

import com.ceiba.estudiante.modelo.clasificacion.NivelEstudios;
import com.ceiba.estudiante.modelo.entidad.Estudiante;
import com.ceiba.persona.modelo.entidad.Persona;

public class EstudianteTestDataBuilder {
    private Long id;
    private Persona persona;
    private NivelEstudios nivelEstudios;

    public EstudianteTestDataBuilder() {
        this.nivelEstudios = NivelEstudios.UNIVERSIDAD;
        this.persona = new Persona("prueba_nom", "prueba_apell", "1234567890");
        persona.setId(1l);
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

    public EstudianteTestDataBuilder setNivelEstudios(NivelEstudios nivelEstudios) {
        this.nivelEstudios = nivelEstudios;
        return this;
    }

    public Estudiante build() {
        Estudiante estudiante =  new Estudiante(persona, nivelEstudios);
        estudiante.setId(id);
        return  estudiante;
    }
}
