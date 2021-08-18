package com.ceiba.persona.servicio.testdatabuilder;

import com.ceiba.persona.comando.PersonaComando;

public class PersonaComandoTestDataBuilder {
    private Long id;
    private String nombres;
    private String apellidos;
    private String cedula;

    public PersonaComandoTestDataBuilder() {
        this.nombres = "Luis Felipe";
        this.apellidos = "Hernandez Chica";
        this.cedula = "1000784940";
    }

    public PersonaComandoTestDataBuilder setId(Long id) {
        this.id = id;
        return this;
    }

    public PersonaComandoTestDataBuilder setNombres(String nombres) {
        this.nombres = nombres;
        return this;
    }

    public PersonaComandoTestDataBuilder setApellidos(String apellidos) {
        this.apellidos = apellidos;
        return this;
    }

    public PersonaComandoTestDataBuilder setCedula(String cedula) {
        this.cedula = cedula;
        return this;
    }

    public PersonaComando build(){
        return new PersonaComando(id,nombres,apellidos,cedula);
    }
}
