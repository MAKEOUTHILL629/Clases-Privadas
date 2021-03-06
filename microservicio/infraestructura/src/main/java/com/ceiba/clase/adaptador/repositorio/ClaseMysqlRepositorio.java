package com.ceiba.clase.adaptador.repositorio;

import com.ceiba.clase.adaptador.repositorio.clasemap.ClaseMapSqlParameterSource;
import com.ceiba.clase.modelo.entidad.Clase;
import com.ceiba.clase.puerto.repositorio.ClaseRepositorio;
import com.ceiba.infraestructura.jdbc.CustomNamedParameterJdbcTemplate;
import com.ceiba.infraestructura.jdbc.sqlstatement.SqlStatement;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Repository;

import java.util.Objects;

@Repository
public class ClaseMysqlRepositorio implements ClaseRepositorio {

    private final CustomNamedParameterJdbcTemplate jdbcTemplate;

    @SqlStatement(namespace = "clase", value = "crear")
    private static String sqlCrear;

    @SqlStatement(namespace = "clase", value = "actualizar")
    private static String sqlActualizar;

    @SqlStatement(namespace = "clase", value = "eliminar")
    private static String sqlEliminar;

    @SqlStatement(namespace = "clase", value = "existe")
    private static String sqlExiste;

    @SqlStatement(namespace = "clase", value = "repetido")
    private static String sqlRepetido;


    public ClaseMysqlRepositorio(CustomNamedParameterJdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public Long crear(Clase clase) {

        MapSqlParameterSource parameterSource = new ClaseMapSqlParameterSource(clase).mapearParametrosToSql();
        KeyHolder keyHolder = new GeneratedKeyHolder();

        this.jdbcTemplate.getNamedParameterJdbcTemplate().update(sqlCrear, parameterSource, keyHolder, new String[]{"id"});
        return Objects.requireNonNull(keyHolder.getKey())
                .longValue();
    }

    @Override
    public void actualizar(Clase clase) {
        MapSqlParameterSource parameterSource = new ClaseMapSqlParameterSource(clase).mapearParametrosToSql();

        this.jdbcTemplate.getNamedParameterJdbcTemplate().update(sqlActualizar, parameterSource);
    }

    @Override
    public void eliminar(Long id) {
        MapSqlParameterSource paramSource = new MapSqlParameterSource();
        paramSource.addValue("id", id);

        this.jdbcTemplate.getNamedParameterJdbcTemplate().update(sqlEliminar, paramSource);
    }

    @Override
    public boolean existe(Clase clase) {
        MapSqlParameterSource parameterSource = new ClaseMapSqlParameterSource(clase).mapearParametrosToSql();
        return this.jdbcTemplate.getNamedParameterJdbcTemplate().queryForObject(sqlExiste, parameterSource, Boolean.class);
    }

    @Override
    public boolean esRepetido(Clase clase) {
        MapSqlParameterSource parameterSource = new ClaseMapSqlParameterSource(clase).mapearParametrosToSql();
        return this.jdbcTemplate.getNamedParameterJdbcTemplate().queryForObject(sqlRepetido, parameterSource, Boolean.class);
    }
}
