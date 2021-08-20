package com.ceiba.estudiante.comando.manejador;

import com.ceiba.estudiante.comando.comando.EstudianteComandActualizar;
import com.ceiba.estudiante.comando.fabrica.EstudianteFabrica;
import com.ceiba.estudiante.modelo.entidad.Estudiante;
import com.ceiba.estudiante.servicio.ActualizarEstudianteServicio;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

@Component
public class ActualizarEstudianteManejador {

    private final EstudianteFabrica estudianteFabrica;
    private final ActualizarEstudianteServicio actualizarEstudianteServicio;


    public ActualizarEstudianteManejador(EstudianteFabrica estudianteFabrica, ActualizarEstudianteServicio actualizarEstudianteServicio) {
        this.estudianteFabrica = estudianteFabrica;
        this.actualizarEstudianteServicio = actualizarEstudianteServicio;
    }

    @Transactional
    public void ejecutar(EstudianteComandActualizar estudianteComandoCrear, Long id) {
        Estudiante estudiante = this.estudianteFabrica.crear(estudianteComandoCrear, id);
        this.actualizarEstudianteServicio.ejecutar(estudiante);
    }
}
