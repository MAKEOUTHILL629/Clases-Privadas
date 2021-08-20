package com.ceiba.estudiante.servicio.testdatabuilder;

import com.ceiba.estudiante.comando.comando.EstudianteComandActualizar;
import com.ceiba.estudiante.modelo.clasificacion.NivelEstudios;

public class EstudianteComandoActualizarTestDataBuilder {
    private NivelEstudios nivelEstudios;

    public EstudianteComandoActualizarTestDataBuilder() {
        this.nivelEstudios = NivelEstudios.SECUNDARIA;
    }

    public EstudianteComandoActualizarTestDataBuilder setNivelEstudios(NivelEstudios nivelEstudios) {
        this.nivelEstudios = nivelEstudios;
        return this;
    }

    public EstudianteComandActualizar build(){
        return new EstudianteComandActualizar(nivelEstudios);
    }
}
