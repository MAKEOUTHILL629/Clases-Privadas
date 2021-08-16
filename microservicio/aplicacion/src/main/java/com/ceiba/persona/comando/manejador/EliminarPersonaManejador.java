package com.ceiba.persona.comando.manejador;

import com.ceiba.manejador.ManejadorComando;
import com.ceiba.persona.servicio.EliminarPersonaServicio;
import org.springframework.stereotype.Component;

@Component
public class EliminarPersonaManejador implements ManejadorComando<Long> {

    private final EliminarPersonaServicio servicio;

    public EliminarPersonaManejador(EliminarPersonaServicio servicio) {
        this.servicio = servicio;
    }

    @Override
    public void ejecutar(Long id) {
        this.servicio.ejecutar(id);
    }
}
