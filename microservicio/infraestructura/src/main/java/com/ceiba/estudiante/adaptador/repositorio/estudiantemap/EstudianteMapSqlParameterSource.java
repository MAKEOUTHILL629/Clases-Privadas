package com.ceiba.estudiante.adaptador.repositorio.estudiantemap;

import com.ceiba.estudiante.modelo.entidad.Estudiante;

import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;

public class EstudianteMapSqlParameterSource {
    private MapSqlParameterSource paramSource;
    private Estudiante estudiante;

    public EstudianteMapSqlParameterSource(Estudiante estudiante) {
        paramSource = new MapSqlParameterSource();
        this.estudiante = estudiante;
    }

    public MapSqlParameterSource mapearParametrosToSql() {
        paramSource.addValue("id", estudiante.getId());
        paramSource.addValue("id_persona", estudiante.getPersona().getId());
        paramSource.addValue("nivelEstudios", estudiante.getNivelEstudios().toString());

        return this.paramSource;
    }


}
