package com.ceiba.persona.adaptador.dao;


import com.ceiba.infraestructura.jdbc.CustomNamedParameterJdbcTemplate;
import com.ceiba.infraestructura.jdbc.sqlstatement.SqlStatement;
import com.ceiba.persona.modelo.dto.PersonaDTO;
import com.ceiba.persona.puerto.dao.PersonaDAO;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.stereotype.Component;

import java.util.List;


@Component
public class PersonaMysqlDAO implements PersonaDAO {

    private final CustomNamedParameterJdbcTemplate jdbcTemplate;
    @SqlStatement(namespace = "persona", value = "listar")
    private static String sqlListar;
    @SqlStatement(namespace = "persona", value = "obtener")
    private static String sqlObtener;

    @SqlStatement(namespace = "persona", value = "persona-existe")
    private static String sqlExistePersona;

    public PersonaMysqlDAO(CustomNamedParameterJdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public List<PersonaDTO> listar() {
        return this.jdbcTemplate.getNamedParameterJdbcTemplate().query(sqlListar, new PersonaMapeo());
    }

    @Override
    public PersonaDTO obtener(Long id) {
        MapSqlParameterSource source = new MapSqlParameterSource();
        source.addValue("id", id);

        return this.jdbcTemplate.getNamedParameterJdbcTemplate().queryForObject(sqlObtener, source, new PersonaMapeo());
    }

    @Override
    public Boolean existe(Long id) {
        MapSqlParameterSource parameterSource = new MapSqlParameterSource();
        parameterSource.addValue("id", id);

        return this.jdbcTemplate.getNamedParameterJdbcTemplate().queryForObject(sqlExistePersona, parameterSource, Boolean.class);
    }
}
