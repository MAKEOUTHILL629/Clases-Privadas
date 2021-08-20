package com.ceiba.profesor.adaptador.repositorio.profesormap;

import com.ceiba.profesor.modelo.entidad.Profesor;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;

public class ProfesorMapSqlParameterSource {
    private MapSqlParameterSource paramSource;
    private Profesor profesor;

    public ProfesorMapSqlParameterSource(Profesor profesor) {
        paramSource = new MapSqlParameterSource();
        this.profesor = profesor;
    }

    public MapSqlParameterSource mapearParametrosToSql() {
        paramSource.addValue("id", profesor.getId());

        if(profesor.getPersona() != null) {
            paramSource.addValue("id_persona", profesor.getPersona().getId());
        }
        paramSource.addValue("profesion", profesor.getProfesion());

        return this.paramSource;
    }


}
