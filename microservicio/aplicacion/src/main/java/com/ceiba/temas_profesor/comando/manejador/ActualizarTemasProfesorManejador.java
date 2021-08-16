package com.ceiba.temas_profesor.comando.manejador;

import com.ceiba.manejador.ManejadorComando;

import com.ceiba.temas_profesor.comando.TemasProfesorComando;
import com.ceiba.temas_profesor.comando.fabrica.TemasProfesorFabrica;
import com.ceiba.temas_profesor.modelo.entidad.TemasProfesor;
import com.ceiba.temas_profesor.servicio.ActualizarTemaProfesorServicio;
import org.springframework.stereotype.Component;

@Component
public class ActualizarTemasProfesorManejador implements ManejadorComando<TemasProfesorComando> {
    private final TemasProfesorFabrica fabrica;
    private final ActualizarTemaProfesorServicio servicio;

    public ActualizarTemasProfesorManejador(TemasProfesorFabrica fabrica, ActualizarTemaProfesorServicio servicio) {
        this.fabrica = fabrica;
        this.servicio = servicio;
    }

    @Override
    public void ejecutar(TemasProfesorComando comando) {
        TemasProfesor temasProfesor = this.fabrica.crear(comando);
        this.servicio.ejecutar(temasProfesor);
    }
}
