package com.ceiba.estudiante.adaptador.repositorio;

import com.ceiba.estudiante.modelo.entidad.Estudiante;
import com.ceiba.estudiante.puerto.repositorio.EstudianteRepositorio;
import com.ceiba.infraestructura.jdbc.CustomNamedParameterJdbcTemplate;
import com.ceiba.infraestructura.jdbc.sqlstatement.SqlStatement;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.stereotype.Repository;

@Repository
public class EstudianteMysqlRepositorio implements EstudianteRepositorio {

    private final CustomNamedParameterJdbcTemplate jdbcTemplate;

    @SqlStatement(namespace="estudiante", value="crear")
    private static String sqlCrear;

    @SqlStatement(namespace="estudiante", value="actualizar")
    private static String sqlActualizar;

    @SqlStatement(namespace="estudiante", value="eliminar")
    private static String sqlEliminar;

    @SqlStatement(namespace="estudiante", value="existe")
    private static String sqlExiste;

    public EstudianteMysqlRepositorio(CustomNamedParameterJdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public Long crear(Estudiante estudiante) {
        return this.jdbcTemplate.crear(estudiante, sqlCrear);
    }

    @Override
    public void actualizar(Estudiante estudiante) {
        this.jdbcTemplate.actualizar(estudiante, sqlActualizar);
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
