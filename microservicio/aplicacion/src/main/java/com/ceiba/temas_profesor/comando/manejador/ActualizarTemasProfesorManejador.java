package com.ceiba.temas_profesor.comando.manejador;

import com.ceiba.temas_profesor.comando.TemasProfesorComando;
import com.ceiba.temas_profesor.comando.fabrica.TemasProfesorFabrica;
import com.ceiba.temas_profesor.modelo.entidad.TemasProfesor;
import com.ceiba.temas_profesor.servicio.ActualizarTemaProfesorServicio;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

@Component
public class ActualizarTemasProfesorManejador {
    private final TemasProfesorFabrica fabrica;
    private final ActualizarTemaProfesorServicio servicio;

    public ActualizarTemasProfesorManejador(TemasProfesorFabrica fabrica, ActualizarTemaProfesorServicio servicio) {
        this.fabrica = fabrica;
        this.servicio = servicio;
    }

    @Transactional
    public void ejecutar(TemasProfesorComando temasProfesorComando, Long id) {
        TemasProfesor temasProfesor = this.fabrica.crear(temasProfesorComando, id);
        this.servicio.ejecutar(temasProfesor);
    }
}
