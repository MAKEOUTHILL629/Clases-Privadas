package com.ceiba.estudiante.adaptador.dao;


import com.ceiba.estudiante.modelo.clasificacion.ObtenerNivelEstudios;
import com.ceiba.persona.consulta.ObtenerPersonaConsulta;

import org.springframework.jdbc.core.RowMapper;
import com.ceiba.estudiante.modelo.dto.EstudianteDTO;
import com.ceiba.infraestructura.jdbc.MapperResult;


import java.sql.ResultSet;
import java.sql.SQLException;


public class EstudianteMapeo implements RowMapper<EstudianteDTO>, MapperResult {
    private final ObtenerPersonaConsulta obtenerPersonaConsulta;

    public EstudianteMapeo(ObtenerPersonaConsulta obtenerPersonaConsulta) {
        this.obtenerPersonaConsulta = obtenerPersonaConsulta;
    }

    @Override
    public EstudianteDTO mapRow(ResultSet rs, int rowNum) throws SQLException {
        Long id = rs.getLong("id");
        Long idPersona = rs.getLong("id_persona");
        String nivelEstudios = rs.getString("nivel_estudios");

        return new EstudianteDTO(id, obtenerPersonaConsulta.ejecutar(idPersona), ObtenerNivelEstudios.obtenerNivelEstudios(nivelEstudios));
    }
}
