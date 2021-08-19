package com.ceiba.horarios_profesor.comando.manejador;

import com.ceiba.horarios_profesor.comando.HorariosProfesorComando;
import com.ceiba.horarios_profesor.comando.fabrica.HorariosProfesorFabrica;
import com.ceiba.horarios_profesor.modelo.entidad.HorariosProfesor;
import com.ceiba.horarios_profesor.servicio.ActualizarHorarioProfesorServicio;


import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

@Component
public class ActualizarHorariosProfesorManejador {
    private final HorariosProfesorFabrica horariosProfesorFabrica;
    private final ActualizarHorarioProfesorServicio actualizarHorarioProfesorServicio;

    public ActualizarHorariosProfesorManejador(HorariosProfesorFabrica horariosProfesorFabrica, ActualizarHorarioProfesorServicio actualizarHorarioProfesorServicio) {
        this.horariosProfesorFabrica = horariosProfesorFabrica;
        this.actualizarHorarioProfesorServicio = actualizarHorarioProfesorServicio;
    }

    @Transactional
    public void ejecutar(HorariosProfesorComando horariosProfesorComando, Long id) {
        HorariosProfesor horariosProfesor = horariosProfesorFabrica.crear(horariosProfesorComando, id);

        this.actualizarHorarioProfesorServicio.ejecutar(horariosProfesor);
    }
}
