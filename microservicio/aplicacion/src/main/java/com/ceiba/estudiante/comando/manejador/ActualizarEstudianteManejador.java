package com.ceiba.estudiante.comando.manejador;

import com.ceiba.estudiante.comando.EstudianteComando;
import com.ceiba.estudiante.comando.fabrica.EstudianteFabrica;
import com.ceiba.estudiante.modelo.entidad.Estudiante;
import com.ceiba.estudiante.servicio.ActualizarEstudianteServicio;
import com.ceiba.manejador.ManejadorComando;
import org.springframework.stereotype.Component;

@Component
public class ActualizarEstudianteManejador implements ManejadorComando<EstudianteComando> {

    private final EstudianteFabrica fabrica;
    private final ActualizarEstudianteServicio servicio;


    public ActualizarEstudianteManejador(EstudianteFabrica fabrica, ActualizarEstudianteServicio servicio) {
        this.fabrica = fabrica;
        this.servicio = servicio;
    }


    @Override
    public void ejecutar(EstudianteComando comando) {
        Estudiante estudiante = this.fabrica.crear(comando);
        this.servicio.ejecutar(estudiante);
    }
}
