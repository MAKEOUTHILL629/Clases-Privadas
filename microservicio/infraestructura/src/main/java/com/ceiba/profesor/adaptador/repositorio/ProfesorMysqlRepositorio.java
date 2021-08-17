package com.ceiba.profesor.adaptador.repositorio;

import com.ceiba.infraestructura.jdbc.CustomNamedParameterJdbcTemplate;
import com.ceiba.infraestructura.jdbc.sqlstatement.SqlStatement;
import com.ceiba.profesor.modelo.entidad.Profesor;
import com.ceiba.profesor.puerto.repositorio.ProfesorRepositorio;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.stereotype.Repository;

@Repository
public class ProfesorMysqlRepositorio implements ProfesorRepositorio {
    private final CustomNamedParameterJdbcTemplate jdbcTemplate;

    @SqlStatement(namespace="profesor", value="crear")
    private static String sqlCrear;

    @SqlStatement(namespace="profesor", value="actualizar")
    private static String sqlActualizar;

    @SqlStatement(namespace="profesor", value="eliminar")
    private static String sqlEliminar;

    @SqlStatement(namespace="profesor", value="existe")
    private static String sqlExiste;

    public ProfesorMysqlRepositorio(CustomNamedParameterJdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public Long crear(Profesor profesor) {
        return this.jdbcTemplate.crear(profesor, sqlCrear);
    }

    @Override
    public void actualizar(Profesor profesor) {


        this.jdbcTemplate.actualizar(profesor, sqlActualizar);
    }

    @Override
    public void eliminar(Long id) {
        MapSqlParameterSource parameterSource = new MapSqlParameterSource();
        parameterSource.addValue("id", id);

        this.jdbcTemplate.getNamedParameterJdbcTemplate().update(sqlEliminar, parameterSource);
    }

    @Override
    public boolean existe(Long id) {
        MapSqlParameterSource parameterSource = new MapSqlParameterSource();
        parameterSource.addValue("id", id);


        return this.jdbcTemplate.getNamedParameterJdbcTemplate().queryForObject(sqlExiste, parameterSource, Boolean.class);
    }
}
