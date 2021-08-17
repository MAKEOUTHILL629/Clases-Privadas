package com.ceiba.temas_profesor.adaptador.repositorio;

import com.ceiba.horarios_profesor.adaptador.repositorio.horarios_profesormap.HorariosProfesorMapSqlParameterSource;
import com.ceiba.infraestructura.jdbc.CustomNamedParameterJdbcTemplate;
import com.ceiba.infraestructura.jdbc.sqlstatement.SqlStatement;
import com.ceiba.temas_profesor.adaptador.repositorio.temas_profesormap.TemasProfesorMapSqlParameterSource;
import com.ceiba.temas_profesor.modelo.entidad.TemasProfesor;
import com.ceiba.temas_profesor.puerto.repositorio.TemasProfesorRepositorio;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Repository;

@Repository
public class TemasProfesorMysqlRespositorio implements TemasProfesorRepositorio {

    private final CustomNamedParameterJdbcTemplate jdbcTemplate;

    @SqlStatement(namespace = "temas_profesor", value = "crear")
    private static String sqlCrear;

    @SqlStatement(namespace = "temas_profesor", value = "actualizar")
    private static String sqlActualizar;

    @SqlStatement(namespace = "temas_profesor", value = "eliminar")
    private static String sqlEliminar;

    @SqlStatement(namespace = "temas_profesor", value = "existe")
    private static String sqlExiste;

    public TemasProfesorMysqlRespositorio(CustomNamedParameterJdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public Long crear(TemasProfesor tema) {
        MapSqlParameterSource paramSource = new TemasProfesorMapSqlParameterSource(tema).mapearParametrosToSql();
        KeyHolder keyHolder = new GeneratedKeyHolder();

        this.jdbcTemplate.getNamedParameterJdbcTemplate().update(sqlCrear, paramSource, keyHolder, new String[]{"id"});
        return keyHolder.getKey().longValue();
    }

    @Override
    public void actualizar(TemasProfesor tema) {
        MapSqlParameterSource paramSource = new TemasProfesorMapSqlParameterSource(tema).mapearParametrosToSql();

        this.jdbcTemplate.getNamedParameterJdbcTemplate().update(sqlActualizar, paramSource);
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
