package com.ceiba.temas_profesor.adaptador.repositorio.temas_profesormap;

import com.ceiba.temas_profesor.modelo.entidad.TemasProfesor;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;

public class TemasProfesorMapSqlParameterSource {
    private MapSqlParameterSource paramSource;
    private TemasProfesor temasProfesor;

    public TemasProfesorMapSqlParameterSource(TemasProfesor temasProfesor) {
        paramSource = new MapSqlParameterSource();
        this.temasProfesor = temasProfesor;
    }

    public MapSqlParameterSource mapearParametrosToSql(){
        paramSource.addValue("id", temasProfesor.getId());
        paramSource.addValue("id_profesor", temasProfesor.getProfesor().getId());
        paramSource.addValue("tema", temasProfesor.getTema());

        return this.paramSource;
    }
}
