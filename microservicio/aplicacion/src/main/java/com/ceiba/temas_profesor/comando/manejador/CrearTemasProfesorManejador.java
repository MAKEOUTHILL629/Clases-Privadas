package com.ceiba.temas_profesor.comando.manejador;

import com.ceiba.ComandoRespuesta;
import com.ceiba.manejador.ManejadorComandoRespuesta;

import com.ceiba.temas_profesor.comando.TemasProfesorComando;
import com.ceiba.temas_profesor.comando.fabrica.TemasProfesorFabrica;
import com.ceiba.temas_profesor.modelo.entidad.TemasProfesor;
import com.ceiba.temas_profesor.servicio.CrearTemaProfesorServicio;
import org.springframework.stereotype.Component;

@Component
public class CrearTemasProfesorManejador implements ManejadorComandoRespuesta<TemasProfesorComando, ComandoRespuesta<Long>> {
    private final TemasProfesorFabrica fabrica;
    private final CrearTemaProfesorServicio servicio;

    public CrearTemasProfesorManejador(TemasProfesorFabrica fabrica, CrearTemaProfesorServicio servicio) {
        this.fabrica = fabrica;
        this.servicio = servicio;
    }

    @Override
    public ComandoRespuesta<Long> ejecutar(TemasProfesorComando comando) {
        TemasProfesor temasProfesor = this.fabrica.crear(comando);
        return new ComandoRespuesta<>(this.servicio.ejecutar(temasProfesor));
    }
}
