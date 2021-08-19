package com.ceiba.profesor.adaptador.dao;

import com.ceiba.infraestructura.jdbc.MapperResult;
import com.ceiba.persona.consulta.ObtenerPersonaManejadorConsulta;
import com.ceiba.profesor.modelo.dto.ProfesorDTO;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;


public class ProfesorMapeo implements RowMapper<ProfesorDTO>, MapperResult {
    private final ObtenerPersonaManejadorConsulta obtenerPersonaManejadorConsulta;

    public ProfesorMapeo(ObtenerPersonaManejadorConsulta obtenerPersonaManejadorConsulta) {
        this.obtenerPersonaManejadorConsulta = obtenerPersonaManejadorConsulta;
    }

    @Override
    public ProfesorDTO mapRow(ResultSet rs, int rowNum) throws SQLException {
        Long id = rs.getLong("id");
        Long idPersona = rs.getLong("id_persona");
        String profesion = rs.getString("profesion");

        return new ProfesorDTO(id, obtenerPersonaManejadorConsulta.ejecutar(idPersona), profesion);
    }
}
