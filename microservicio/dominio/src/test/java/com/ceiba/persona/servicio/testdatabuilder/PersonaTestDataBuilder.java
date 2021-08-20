package com.ceiba.persona.servicio.testdatabuilder;

import com.ceiba.persona.modelo.entidad.Persona;

public class PersonaTestDataBuilder {
    private Long id;
    private String nombres;
    private String apellidos;
    private String cedula;

    public PersonaTestDataBuilder() {
        this.id = 1l;
        this.nombres = "prueba_nom";
        this.apellidos = "prueba_apell";
        this.cedula = "1234567890";
    }

    public PersonaTestDataBuilder setId(Long id) {
        this.id = id;
        return this;
    }

    public PersonaTestDataBuilder setNombres(String nombres) {
        this.nombres = nombres;
        return this;
    }

    public PersonaTestDataBuilder setApellidos(String apellidos) {
        this.apellidos = apellidos;
        return this;
    }

    public PersonaTestDataBuilder setCedula(String cedula) {
        this.cedula = cedula;
        return this;
    }

    public Persona build() {
        Persona persona =  new Persona(nombres, apellidos, cedula);
        persona.setId(id);
        return persona;
    }


}
