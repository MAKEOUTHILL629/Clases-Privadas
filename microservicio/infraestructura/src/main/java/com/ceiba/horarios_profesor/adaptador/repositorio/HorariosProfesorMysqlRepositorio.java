package com.ceiba.horarios_profesor.adaptador.repositorio;

import com.ceiba.horarios_profesor.adaptador.repositorio.horarios_profesormap.HorariosProfesorMapSqlParameterSource;
import com.ceiba.horarios_profesor.modelo.entidad.HorariosProfesor;
import com.ceiba.horarios_profesor.puerto.repositorio.HorariosProfesorRepositorio;
import com.ceiba.infraestructura.jdbc.CustomNamedParameterJdbcTemplate;
import com.ceiba.infraestructura.jdbc.sqlstatement.SqlStatement;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Repository;

import java.util.Objects;

@Repository
public class HorariosProfesorMysqlRepositorio implements HorariosProfesorRepositorio {
    private final CustomNamedParameterJdbcTemplate jdbcTemplate;

    @SqlStatement(namespace = "horarios_profesor", value = "crear")
    private static String sqlCrear;

    @SqlStatement(namespace = "horarios_profesor", value = "actualizar")
    private static String sqlActualizar;

    @SqlStatement(namespace = "horarios_profesor", value = "eliminar")
    private static String sqlEliminar;

    @SqlStatement(namespace = "horarios_profesor", value = "existe")
    private static String sqlExiste;

    public HorariosProfesorMysqlRepositorio(CustomNamedParameterJdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public Long crear(HorariosProfesor horarios) {
        MapSqlParameterSource paramSource = new HorariosProfesorMapSqlParameterSource(horarios).mapearParametrosToSql();
        KeyHolder keyHolder = new GeneratedKeyHolder();

        this.jdbcTemplate.getNamedParameterJdbcTemplate().update(sqlCrear, paramSource, keyHolder, new String[]{"id"});
        return Objects.requireNonNull(keyHolder.getKey()).longValue();
    }

    @Override
    public void actualizar(HorariosProfesor horarios) {
        MapSqlParameterSource paramSource = new HorariosProfesorMapSqlParameterSource(horarios).mapearParametrosToSql();

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
