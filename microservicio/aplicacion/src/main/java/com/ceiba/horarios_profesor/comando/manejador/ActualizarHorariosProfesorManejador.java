package com.ceiba.horarios_profesor.comando.manejador;

import com.ceiba.horarios_profesor.comando.HorariosProfesorComando;
import com.ceiba.horarios_profesor.comando.fabrica.HorariosProfesorFabrica;
import com.ceiba.horarios_profesor.modelo.entidad.HorariosProfesor;
import com.ceiba.horarios_profesor.servicio.ActualizarHorarioProfesorServicio;
import com.ceiba.manejador.ManejadorComando;

import org.springframework.stereotype.Component;

@Component
public class ActualizarHorariosProfesorManejador implements ManejadorComando<HorariosProfesorComando> {
    private final HorariosProfesorFabrica fabrica;
    private final ActualizarHorarioProfesorServicio servicio;

    public ActualizarHorariosProfesorManejador(HorariosProfesorFabrica fabrica, ActualizarHorarioProfesorServicio servicio) {
        this.fabrica = fabrica;
        this.servicio = servicio;
    }

    @Override
    public void ejecutar(HorariosProfesorComando comando) {
        HorariosProfesor horariosProfesor = fabrica.crear(comando);

        this.servicio.ejecutar(horariosProfesor);
    }
}
