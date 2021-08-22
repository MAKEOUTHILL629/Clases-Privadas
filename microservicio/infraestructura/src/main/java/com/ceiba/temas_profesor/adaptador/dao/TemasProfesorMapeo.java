package com.ceiba.temas_profesor.adaptador.dao;

import com.ceiba.infraestructura.jdbc.MapperResult;
import com.ceiba.temas_profesor.modelo.dto.TemasProfesorDTO;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class TemasProfesorMapeo implements RowMapper<TemasProfesorDTO>, MapperResult {

    @Override
    public TemasProfesorDTO mapRow(ResultSet rs, int rowNum) throws SQLException {
        Long id = rs.getLong("id");
        Long idProfesor = rs.getLong("id_profesor");
        String tema = rs.getString("tema");

        return new TemasProfesorDTO(
                id,
                idProfesor,
                tema
        );
    }
}
