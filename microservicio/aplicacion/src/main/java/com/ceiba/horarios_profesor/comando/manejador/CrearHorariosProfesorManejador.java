package com.ceiba.horarios_profesor.comando.manejador;

import com.ceiba.ComandoRespuesta;
import com.ceiba.horarios_profesor.comando.HorariosProfesorComando;
import com.ceiba.horarios_profesor.comando.fabrica.HorariosProfesorFabrica;
import com.ceiba.horarios_profesor.modelo.entidad.HorariosProfesor;
import com.ceiba.horarios_profesor.servicio.CrearHorarioProfesorServicio;
import com.ceiba.manejador.ManejadorComandoRespuesta;
import org.springframework.stereotype.Component;

@Component
public class CrearHorariosProfesorManejador implements ManejadorComandoRespuesta<HorariosProfesorComando, ComandoRespuesta<Long>> {
    private final HorariosProfesorFabrica horariosProfesorFabrica;
    private final CrearHorarioProfesorServicio crearHorarioProfesorServicio;

    public CrearHorariosProfesorManejador(HorariosProfesorFabrica horariosProfesorFabrica, CrearHorarioProfesorServicio crearHorarioProfesorServicio) {
        this.horariosProfesorFabrica = horariosProfesorFabrica;
        this.crearHorarioProfesorServicio = crearHorarioProfesorServicio;
    }

    @Override
    public ComandoRespuesta<Long> ejecutar(HorariosProfesorComando horariosProfesorComando) {
        HorariosProfesor horariosProfesor = horariosProfesorFabrica.crear(horariosProfesorComando);
        return new ComandoRespuesta<>(this.crearHorarioProfesorServicio.ejecutar(horariosProfesor));
    }
}

