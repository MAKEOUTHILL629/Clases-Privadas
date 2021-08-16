package com.ceiba.profesor.comando.manejador;


import com.ceiba.manejador.ManejadorComando;
import com.ceiba.profesor.comando.ProfesorComando;
import com.ceiba.profesor.comando.fabrica.ProfesorFabrica;
import com.ceiba.profesor.modelo.entidad.Profesor;
import com.ceiba.profesor.servicio.ActualizarProfesorServicio;
import org.springframework.stereotype.Component;

@Component
public class ActualizarProfesorManejador implements ManejadorComando<ProfesorComando> {
    private final ProfesorFabrica fabrica;
    private final ActualizarProfesorServicio servicio;

    public ActualizarProfesorManejador(ProfesorFabrica fabrica, ActualizarProfesorServicio servicio) {
        this.fabrica = fabrica;
        this.servicio = servicio;
    }

    @Override
    public void ejecutar(ProfesorComando comando) {
        Profesor profesor = this.fabrica.crear(comando);
        this.servicio.ejecutar(profesor);
    }
}
