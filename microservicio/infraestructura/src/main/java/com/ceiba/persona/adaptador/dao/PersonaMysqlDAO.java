package com.ceiba.persona.adaptador.dao;

import com.ceiba.infraestructura.jdbc.CustomNamedParameterJdbcTemplate;
import com.ceiba.infraestructura.jdbc.sqlstatement.SqlStatement;
import com.ceiba.persona.modelo.dto.PersonaDTO;
import com.ceiba.persona.puerto.dao.PersonaDAO;

import java.util.List;

public class PersonaMysqlDAO implements PersonaDAO {

    private final CustomNamedParameterJdbcTemplate jdbcTemplate;
    @SqlStatement(namespace = "persona", value = "listar")
    private static String sqlListar;

    public PersonaMysqlDAO(CustomNamedParameterJdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public List<PersonaDTO> listar() {
        return this.jdbcTemplate.getNamedParameterJdbcTemplate().query(sqlListar, new PersonaMapeo());
    }
}
