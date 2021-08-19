package com.ceiba.estudiante.comando.manejador;

import com.ceiba.estudiante.servicio.EliminarEstudianteServicio;
import com.ceiba.manejador.ManejadorComando;
import org.springframework.stereotype.Component;

@Component
public class EliminarEstudiantesManejador implements ManejadorComando<Long> {
    private final EliminarEstudianteServicio eliminarEstudianteServicio;

    public EliminarEstudiantesManejador(EliminarEstudianteServicio eliminarEstudianteServicio) {
        this.eliminarEstudianteServicio = eliminarEstudianteServicio;
    }

    @Override
    public void ejecutar(Long id) {
        this.eliminarEstudianteServicio.ejecutar(id);
    }
}
