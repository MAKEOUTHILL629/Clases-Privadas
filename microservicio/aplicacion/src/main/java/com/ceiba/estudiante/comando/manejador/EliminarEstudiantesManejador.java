package com.ceiba.estudiante.comando.manejador;

import com.ceiba.estudiante.servicio.EliminarEstudianteServicio;
import com.ceiba.manejador.ManejadorComando;
import org.springframework.stereotype.Component;

@Component
public class EliminarEstudiantesManejador implements ManejadorComando<Long> {
    private final EliminarEstudianteServicio servicio;

    public EliminarEstudiantesManejador(EliminarEstudianteServicio servicio) {
        this.servicio = servicio;
    }

    @Override
    public void ejecutar(Long comando) {
        this.servicio.ejecutar(comando);
    }
}
