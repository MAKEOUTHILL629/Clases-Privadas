package com.ceiba.profesor.adaptador.repositorio;

import com.ceiba.infraestructura.jdbc.CustomNamedParameterJdbcTemplate;
import com.ceiba.infraestructura.jdbc.sqlstatement.SqlStatement;
import com.ceiba.profesor.adaptador.repositorio.profesormap.ProfesorMapSqlParameterSource;
import com.ceiba.profesor.modelo.entidad.Profesor;
import com.ceiba.profesor.puerto.repositorio.ProfesorRepositorio;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Repository;

import java.util.Objects;

@Repository
public class ProfesorMysqlRepositorio implements ProfesorRepositorio {
    private final CustomNamedParameterJdbcTemplate jdbcTemplate;

    @SqlStatement(namespace = "profesor", value = "crear")
    private static String sqlCrear;

    @SqlStatement(namespace = "profesor", value = "actualizar")
    private static String sqlActualizar;

    @SqlStatement(namespace = "profesor", value = "eliminar")
    private static String sqlEliminar;

    @SqlStatement(namespace = "profesor", value = "existe-profesor")
    private static String sqlExisteProfesor;

    @SqlStatement(namespace = "profesor", value = "existe-persona")
    private static String sqlExistePersona;


    public ProfesorMysqlRepositorio(CustomNamedParameterJdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public Long crear(Profesor profesor) {
        MapSqlParameterSource paramSource = new ProfesorMapSqlParameterSource(profesor).mapearParametrosToSql();
        KeyHolder keyHolder = new GeneratedKeyHolder();

        this.jdbcTemplate.getNamedParameterJdbcTemplate().update(sqlCrear, paramSource, keyHolder, new String[]{"id"});
        return Objects.requireNonNull(keyHolder.getKey()).longValue();
    }

    @Override
    public void actualizar(Profesor profesor) {
        MapSqlParameterSource parameterSource = new ProfesorMapSqlParameterSource(profesor).mapearParametrosToSql();

        this.jdbcTemplate.getNamedParameterJdbcTemplate().update(sqlActualizar, parameterSource);
    }

    @Override
    public void eliminar(Long id) {
        MapSqlParameterSource parameterSource = new MapSqlParameterSource();
        parameterSource.addValue("id", id);

        this.jdbcTemplate.getNamedParameterJdbcTemplate().update(sqlEliminar, parameterSource);
    }


    @Override
    public Boolean existeConIdPersona(Long idPersona) {
        MapSqlParameterSource parameterSource = new MapSqlParameterSource();
        parameterSource.addValue("idPersona", idPersona);


        return this.jdbcTemplate.getNamedParameterJdbcTemplate().queryForObject(sqlExistePersona, parameterSource, Boolean.class);
    }

    @Override
    public Boolean existeConIdProfesor(Long idProfesor) {
        MapSqlParameterSource parameterSource = new MapSqlParameterSource();
        parameterSource.addValue("idProfesor", idProfesor);

        return this.jdbcTemplate.getNamedParameterJdbcTemplate().queryForObject(sqlExisteProfesor, parameterSource, Boolean.class);
    }
}
