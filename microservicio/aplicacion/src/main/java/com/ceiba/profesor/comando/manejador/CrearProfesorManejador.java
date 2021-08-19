package com.ceiba.profesor.comando.manejador;

import com.ceiba.ComandoRespuesta;
import com.ceiba.manejador.ManejadorComandoRespuesta;
import com.ceiba.profesor.comando.comando.ProfesorComandoCrear;
import com.ceiba.profesor.comando.fabrica.ProfesorFabrica;
import com.ceiba.profesor.modelo.entidad.Profesor;
import com.ceiba.profesor.servicio.CrearProfesorServicio;
import org.springframework.stereotype.Component;

@Component
public class CrearProfesorManejador implements ManejadorComandoRespuesta<ProfesorComandoCrear, ComandoRespuesta<Long>> {

    private final ProfesorFabrica fabrica;
    private final CrearProfesorServicio servicio;

    public CrearProfesorManejador(ProfesorFabrica fabrica, CrearProfesorServicio servicio) {
        this.fabrica = fabrica;
        this.servicio = servicio;
    }

    @Override
    public ComandoRespuesta<Long> ejecutar(ProfesorComandoCrear comando) {
        Profesor profesor = fabrica.crear(comando);
        return new ComandoRespuesta<>(this.servicio.ejecutar(profesor));
    }
}
