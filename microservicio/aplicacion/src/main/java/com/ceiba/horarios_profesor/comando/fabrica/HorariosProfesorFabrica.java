package com.ceiba.horarios_profesor.comando.fabrica;

import com.ceiba.horarios_profesor.comando.HorariosProfesorComando;
import com.ceiba.horarios_profesor.modelo.clasificacion.DiasSemana;
import com.ceiba.horarios_profesor.modelo.entidad.HorariosProfesor;
import com.ceiba.horarios_profesor.modelo.utilidad.HoraEntrada;
import com.ceiba.profesor.modelo.entidad.Profesor;
import org.springframework.stereotype.Component;

@Component
public class HorariosProfesorFabrica {
    public HorariosProfesor crear(HorariosProfesorComando horariosProfesorComando) {
        return new HorariosProfesor(
                new Profesor(horariosProfesorComando.getIdProfesor()),
                horariosProfesorComando.getDiaSemana(),
                HoraEntrada.parsearHora(horariosProfesorComando.getHora())
        );
    }

    public HorariosProfesor crear(HorariosProfesorComando horariosProfesorComando, Long id) {
        HorariosProfesor horariosProfesor = new HorariosProfesor(
                new Profesor(horariosProfesorComando.getIdProfesor()),
                horariosProfesorComando.getDiaSemana(),
                HoraEntrada.parsearHora(horariosProfesorComando.getHora())
        );

        horariosProfesor.setId(id);
        return horariosProfesor;
    }
}
