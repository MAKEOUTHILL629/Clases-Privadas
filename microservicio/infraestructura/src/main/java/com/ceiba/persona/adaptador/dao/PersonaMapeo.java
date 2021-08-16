package com.ceiba.persona.adaptador.dao;

import com.ceiba.infraestructura.jdbc.MapperResult;
import com.ceiba.persona.modelo.dto.PersonaDTO;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;


public class PersonaMapeo implements RowMapper<PersonaDTO>, MapperResult {

    @Override
    public PersonaDTO mapRow(ResultSet rs, int rowNum) throws SQLException {
        Long id = rs.getLong("id");
        String nombres = rs.getString("first_name");
        String apellidos = rs.getString("last_name");
        String cedula = rs.getString("cedula");

        return new PersonaDTO(id,nombres,apellidos,cedula);
    }
}
