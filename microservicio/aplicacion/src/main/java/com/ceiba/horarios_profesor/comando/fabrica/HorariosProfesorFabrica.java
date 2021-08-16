package com.ceiba.horarios_profesor.comando.fabrica;

import com.ceiba.horarios_profesor.comando.HorariosProfesorComando;
import com.ceiba.horarios_profesor.modelo.entidad.HorariosProfesor;
import com.ceiba.profesor.modelo.entidad.Profesor;

public class HorariosProfesorFabrica {
    public HorariosProfesor crear(HorariosProfesorComando comando){
        return new HorariosProfesor(
                comando.getId(),
                new Profesor(comando.getIdProfesor()),
                comando.getDiaSemana(),
                comando.getHora()
                );
    }
}
