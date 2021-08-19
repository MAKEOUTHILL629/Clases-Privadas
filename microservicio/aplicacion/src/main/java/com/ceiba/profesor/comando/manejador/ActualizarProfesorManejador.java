package com.ceiba.profesor.comando.manejador;



import com.ceiba.profesor.comando.comando.ProfesorComandoActualizar;

import com.ceiba.profesor.comando.fabrica.ProfesorFabrica;
import com.ceiba.profesor.modelo.entidad.Profesor;
import com.ceiba.profesor.servicio.ActualizarProfesorServicio;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

@Component
public class ActualizarProfesorManejador  {
    private final ProfesorFabrica fabrica;
    private final ActualizarProfesorServicio servicio;

    public ActualizarProfesorManejador(ProfesorFabrica fabrica, ActualizarProfesorServicio servicio) {
        this.fabrica = fabrica;
        this.servicio = servicio;
    }

    @Transactional
    public void ejecutar(ProfesorComandoActualizar profesorComandoActualizar, Long id) {
        Profesor profesor = this.fabrica.crear(profesorComandoActualizar, id);
        this.servicio.ejecutar(profesor);
    }
}
