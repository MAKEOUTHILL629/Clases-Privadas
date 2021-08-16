package com.ceiba.temas_profesor.adaptador.repositorio;

import com.ceiba.infraestructura.jdbc.CustomNamedParameterJdbcTemplate;
import com.ceiba.infraestructura.jdbc.sqlstatement.SqlStatement;
import com.ceiba.temas_profesor.modelo.entidad.TemasProfesor;
import com.ceiba.temas_profesor.puerto.repositorio.TemasProfesorRepositorio;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;

public class TemasProfesorMysqlRespositorio implements TemasProfesorRepositorio {

    private final CustomNamedParameterJdbcTemplate jdbcTemplate;

    @SqlStatement(namespace="profesor", value="crear")
    private static String sqlCrear;

    @SqlStatement(namespace="profesor", value="actualizar")
    private static String sqlActualizar;

    @SqlStatement(namespace="profesor", value="eliminar")
    private static String sqlEliminar;

    @SqlStatement(namespace="profesor", value="existe")
    private static String sqlExiste;

    public TemasProfesorMysqlRespositorio(CustomNamedParameterJdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public Long crear(TemasProfesor tema) {
        return this.jdbcTemplate.crear(tema,sqlCrear);
    }

    @Override
    public void actualizar(TemasProfesor tema) {
        this.jdbcTemplate.actualizar(tema, sqlActualizar);
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
