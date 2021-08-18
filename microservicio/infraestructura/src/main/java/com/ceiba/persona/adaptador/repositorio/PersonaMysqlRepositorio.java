package com.ceiba.persona.adaptador.repositorio;

import com.ceiba.infraestructura.jdbc.CustomNamedParameterJdbcTemplate;
import com.ceiba.infraestructura.jdbc.sqlstatement.SqlStatement;
import com.ceiba.persona.modelo.entidad.Persona;
import com.ceiba.persona.puerto.repositorio.PersonaRepositorio;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.stereotype.Repository;

@Repository
public class PersonaMysqlRepositorio implements PersonaRepositorio {

    private final CustomNamedParameterJdbcTemplate jdbcTemplate;

    @SqlStatement(namespace = "persona", value = "crear")
    private static String sqlCrear;

    @SqlStatement(namespace = "persona", value = "actualizar")
    private static String sqlActualizar;

    @SqlStatement(namespace = "persona", value = "eliminar")
    private static String sqlEliminar;

    @SqlStatement(namespace = "persona", value = "existe")
    private static String sqlExiste;

    @SqlStatement(namespace = "persona", value = "existeExcluyendoId")
    private static String sqlExisteExcluyendoId;

    public PersonaMysqlRepositorio(CustomNamedParameterJdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public Long crear(Persona persona) {
        return this.jdbcTemplate.crear(persona, sqlCrear);
    }

    @Override
    public void actualizar(Persona persona) {
        this.jdbcTemplate.actualizar(persona, sqlActualizar);
    }

    @Override
    public void eliminar(Long id) {
        MapSqlParameterSource parameterSource = new MapSqlParameterSource();
        parameterSource.addValue("id", id);

        this.jdbcTemplate.getNamedParameterJdbcTemplate().update(sqlEliminar, parameterSource);
    }

    @Override
    public boolean existe(String cedula) {
        MapSqlParameterSource parameterSource = new MapSqlParameterSource();
        parameterSource.addValue("cedula", cedula);

        return this.jdbcTemplate.getNamedParameterJdbcTemplate().queryForObject(sqlExiste, parameterSource, Boolean.class);
    }

    @Override
    public boolean existeExcluyendoId(Long id) {
        MapSqlParameterSource parameterSource = new MapSqlParameterSource();
        parameterSource.addValue("id", id);

        return this.jdbcTemplate.getNamedParameterJdbcTemplate().queryForObject(sqlExisteExcluyendoId, parameterSource, Boolean.class);
    }
}
