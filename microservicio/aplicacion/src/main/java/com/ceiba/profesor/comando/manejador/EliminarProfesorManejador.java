package com.ceiba.profesor.comando.manejador;

import com.ceiba.manejador.ManejadorComando;
import com.ceiba.profesor.servicio.EliminarProfesorServicio;
import org.springframework.stereotype.Component;

@Component
public class EliminarProfesorManejador implements ManejadorComando<Long> {
    private final EliminarProfesorServicio servicio;

    public EliminarProfesorManejador(EliminarProfesorServicio servicio) {
        this.servicio = servicio;
    }


    @Override
    public void ejecutar(Long comando) {
        servicio.ejecutar(comando);
    }
}
