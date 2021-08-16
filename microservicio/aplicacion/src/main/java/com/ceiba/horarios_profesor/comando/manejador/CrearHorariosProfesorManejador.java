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
    private final HorariosProfesorFabrica fabrica;
    private final CrearHorarioProfesorServicio servicio;

    public CrearHorariosProfesorManejador(HorariosProfesorFabrica fabrica, CrearHorarioProfesorServicio servicio) {
        this.fabrica = fabrica;
        this.servicio = servicio;
    }

    @Override
    public ComandoRespuesta<Long> ejecutar(HorariosProfesorComando comando) {
        HorariosProfesor horariosProfesor = fabrica.crear(comando);
        return new ComandoRespuesta<>(this.servicio.ejecutar(horariosProfesor));
    }
}
