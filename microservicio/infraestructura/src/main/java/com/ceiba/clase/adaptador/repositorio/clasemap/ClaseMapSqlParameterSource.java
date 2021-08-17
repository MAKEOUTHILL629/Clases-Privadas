package com.ceiba.clase.adaptador.repositorio.clasemap;

import com.ceiba.clase.modelo.entidad.Clase;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;

public class ClaseMapSqlParameterSource {
    private MapSqlParameterSource paramSource;
    private Clase clase;

    public ClaseMapSqlParameterSource(Clase clase) {
        paramSource = new MapSqlParameterSource();
        this.clase = clase;
    }

    public MapSqlParameterSource mapearParametrosToSql(){
        paramSource.addValue("id", clase.getId());
        paramSource.addValue("id_profesor", clase.getProfesor().getId());
        paramSource.addValue("id_estudiante", clase.getEstudiante().getId());
        paramSource.addValue("fecha", clase.getFecha());
        paramSource.addValue("valor", clase.getValor());
        return this.paramSource;
    }
}
