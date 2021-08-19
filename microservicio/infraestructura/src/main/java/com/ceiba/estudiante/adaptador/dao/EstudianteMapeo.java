package com.ceiba.estudiante.adaptador.dao;


import com.ceiba.estudiante.modelo.clasificacion.NivelEstudios;
import com.ceiba.persona.consulta.ObtenerPersonaManejadorConsulta;

import org.springframework.jdbc.core.RowMapper;
import com.ceiba.estudiante.modelo.dto.EstudianteDTO;
import com.ceiba.infraestructura.jdbc.MapperResult;


import java.sql.ResultSet;
import java.sql.SQLException;


public class EstudianteMapeo implements RowMapper<EstudianteDTO>, MapperResult {
    private final ObtenerPersonaManejadorConsulta obtenerPersonaManejadorConsulta;

    public EstudianteMapeo(ObtenerPersonaManejadorConsulta obtenerPersonaManejadorConsulta) {
        this.obtenerPersonaManejadorConsulta = obtenerPersonaManejadorConsulta;
    }

    @Override
    public EstudianteDTO mapRow(ResultSet rs, int rowNum) throws SQLException {
        Long id = rs.getLong("id");
        Long idPersona = rs.getLong("id_persona");
        String nivelEstudios = rs.getString("nivel_estudios");

        return new EstudianteDTO(id, obtenerPersonaManejadorConsulta.ejecutar(idPersona), NivelEstudios.valueOf(nivelEstudios));
    }
}
