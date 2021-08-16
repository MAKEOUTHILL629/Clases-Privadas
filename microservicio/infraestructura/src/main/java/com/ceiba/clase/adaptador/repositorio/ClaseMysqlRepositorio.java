package com.ceiba.clase.adaptador.repositorio;

import com.ceiba.clase.modelo.entidad.Clase;
import com.ceiba.clase.puerto.repositorio.ClaseRepositorio;
import com.ceiba.infraestructura.jdbc.CustomNamedParameterJdbcTemplate;
import com.ceiba.infraestructura.jdbc.sqlstatement.SqlStatement;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.stereotype.Repository;

@Repository
public class ClaseMysqlRepositorio implements ClaseRepositorio {
    private final CustomNamedParameterJdbcTemplate jdbcTemplate;

    @SqlStatement(namespace="clase", value="crear")
    private static String sqlCrear;

    @SqlStatement(namespace="clase", value="actualizar")
    private static String sqlActualizar;

    @SqlStatement(namespace="clase", value="eliminar")
    private static String sqlEliminar;

    @SqlStatement(namespace="clase", value="existe")
    private static String sqlExiste;


    public ClaseMysqlRepositorio(CustomNamedParameterJdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public Long crear(Clase clase) {
        return this.jdbcTemplate.crear(clase,sqlCrear);
    }

    @Override
    public void actualizar(Clase clase) {
        this.jdbcTemplate.actualizar(clase, sqlActualizar);
    }

    @Override
    public void eliminar(Long id) {
        MapSqlParameterSource paramSource = new MapSqlParameterSource();
        paramSource.addValue("id", id);

        this.jdbcTemplate.getNamedParameterJdbcTemplate().update(sqlEliminar,paramSource);
    }

    @Override
    public boolean existe(Long id) {
        MapSqlParameterSource paramSource = new MapSqlParameterSource();
        paramSource.addValue("id", id);
        return this.jdbcTemplate.getNamedParameterJdbcTemplate().queryForObject(sqlExiste,paramSource, Boolean.class);
    }
}
