package com.ceiba.estudiante.servicio.testdatabuilder;

import com.ceiba.estudiante.comando.comando.EstudianteComandoCrear;
import com.ceiba.estudiante.modelo.clasificacion.NivelEstudios;

public class EstudianteComandoCrearTestDataBuilder {
    private Long idPersona;
    private NivelEstudios nivelEstudios;

    public EstudianteComandoCrearTestDataBuilder() {
        this.idPersona = 20L;
        this.nivelEstudios = NivelEstudios.PRIMARIA;
    }


    public EstudianteComandoCrearTestDataBuilder setIdPersona(Long idPersona) {
        this.idPersona = idPersona;
        return this;
    }

    public EstudianteComandoCrearTestDataBuilder setNivelEstudios(NivelEstudios nivelEstudios) {
        this.nivelEstudios = nivelEstudios;
        return this;
    }

    public EstudianteComandoCrear build(){
        return new EstudianteComandoCrear(idPersona,nivelEstudios);
    }
}
