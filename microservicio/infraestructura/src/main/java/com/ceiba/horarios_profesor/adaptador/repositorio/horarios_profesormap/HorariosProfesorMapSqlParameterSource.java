package com.ceiba.horarios_profesor.adaptador.repositorio.horarios_profesormap;

import com.ceiba.horarios_profesor.modelo.entidad.HorariosProfesor;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;

public class HorariosProfesorMapSqlParameterSource {
    private MapSqlParameterSource paramSource;
    private HorariosProfesor horariosProfesor;

    public HorariosProfesorMapSqlParameterSource(HorariosProfesor horariosProfesor) {
        paramSource = new MapSqlParameterSource();
        this.horariosProfesor = horariosProfesor;
    }

    public MapSqlParameterSource mapearParametrosToSql() {
        paramSource.addValue("id", horariosProfesor.getId());
        paramSource.addValue("idProfesor", horariosProfesor.getProfesor().getId());
        paramSource.addValue("diaSemana", horariosProfesor.getDiaSemana().name());
        paramSource.addValue("hora", horariosProfesor.getHora().toString()+ ":00");

        return this.paramSource;
    }
}
