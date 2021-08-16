package com.ceiba.estudiante.comando.manejador;

import com.ceiba.ComandoRespuesta;
import com.ceiba.estudiante.comando.EstudianteComando;
import com.ceiba.estudiante.comando.fabrica.EstudianteFabrica;
import com.ceiba.estudiante.modelo.entidad.Estudiante;
import com.ceiba.estudiante.servicio.CrearEstudianteServicio;
import com.ceiba.manejador.ManejadorComandoRespuesta;
import org.springframework.stereotype.Component;

@Component
public class CrearEstudianteManejador implements ManejadorComandoRespuesta<EstudianteComando, ComandoRespuesta<Long>> {
    private final EstudianteFabrica fabrica;
    private final CrearEstudianteServicio servicio;


    public CrearEstudianteManejador(EstudianteFabrica fabrica, CrearEstudianteServicio servicio) {
        this.fabrica = fabrica;
        this.servicio = servicio;
    }


    @Override
    public ComandoRespuesta<Long> ejecutar(EstudianteComando comando) {
        Estudiante estudiante = this.fabrica.crear(comando);
        return new ComandoRespuesta<>(this.servicio.ejecutar(estudiante));
    }
}
