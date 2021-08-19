package com.ceiba.estudiante.comando.manejador;

import com.ceiba.ComandoRespuesta;
import com.ceiba.estudiante.comando.comando.EstudianteComandoCrear;
import com.ceiba.estudiante.comando.fabrica.EstudianteFabrica;
import com.ceiba.estudiante.modelo.entidad.Estudiante;
import com.ceiba.estudiante.servicio.CrearEstudianteServicio;
import com.ceiba.manejador.ManejadorComandoRespuesta;
import org.springframework.stereotype.Component;

@Component
public class CrearEstudianteManejador implements ManejadorComandoRespuesta<EstudianteComandoCrear, ComandoRespuesta<Long>> {
    private final EstudianteFabrica estudianteFabrica;
    private final CrearEstudianteServicio crearEstudianteServicio;


    public CrearEstudianteManejador(EstudianteFabrica estudianteFabrica, CrearEstudianteServicio crearEstudianteServicio) {
        this.estudianteFabrica = estudianteFabrica;
        this.crearEstudianteServicio = crearEstudianteServicio;
    }


    @Override
    public ComandoRespuesta<Long> ejecutar(EstudianteComandoCrear estudianteComandoCrear) {
        Estudiante estudiante = this.estudianteFabrica.crear(estudianteComandoCrear);
        return new ComandoRespuesta<>(this.crearEstudianteServicio.ejecutar(estudiante));
    }
}
