package com.ceiba.profesor.adaptador.dao;

import com.ceiba.infraestructura.jdbc.MapperResult;
import com.ceiba.persona.consulta.ObtenerPersonaConsulta;
import com.ceiba.profesor.modelo.dto.ProfesorDTO;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;


public class ProfesorMapeo implements RowMapper<ProfesorDTO>, MapperResult {
    private final ObtenerPersonaConsulta obtenerPersonaConsulta;

    public ProfesorMapeo(ObtenerPersonaConsulta obtenerPersonaConsulta) {
        this.obtenerPersonaConsulta = obtenerPersonaConsulta;
    }

    @Override
    public ProfesorDTO mapRow(ResultSet rs, int rowNum) throws SQLException {
        Long id = rs.getLong("id");
        Long idPersona = rs.getLong("id_persona");
        String profesion = rs.getString("profesion");

        return new ProfesorDTO(id, obtenerPersonaConsulta.ejecutar(idPersona), profesion);
    }
}
