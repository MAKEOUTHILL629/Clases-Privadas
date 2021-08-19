package com.ceiba.estudiante.adaptador.repositorio;

import com.ceiba.estudiante.adaptador.repositorio.estudiantemap.EstudianteMapSqlParameterSource;
import com.ceiba.estudiante.modelo.entidad.Estudiante;
import com.ceiba.estudiante.puerto.repositorio.EstudianteRepositorio;
import com.ceiba.infraestructura.jdbc.CustomNamedParameterJdbcTemplate;
import com.ceiba.infraestructura.jdbc.sqlstatement.SqlStatement;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Repository;

import java.util.Objects;

@Repository
public class EstudianteMysqlRepositorio implements EstudianteRepositorio {

    private final CustomNamedParameterJdbcTemplate customNamedParameterJdbcTemplate;

    @SqlStatement(namespace = "estudiante", value = "crear")
    private static String sqlCrear;

    @SqlStatement(namespace = "estudiante", value = "actualizar")
    private static String sqlActualizar;

    @SqlStatement(namespace = "estudiante", value = "eliminar")
    private static String sqlEliminar;


    @SqlStatement(namespace = "estudiante", value = "existe-persona")
    private static String sqlExisteConIdPersona;

    @SqlStatement(namespace = "estudiante", value = "existe-estudiante")
    private static String sqlExisteConIdEstudiante;

    public EstudianteMysqlRepositorio(CustomNamedParameterJdbcTemplate customNamedParameterJdbcTemplate) {
        this.customNamedParameterJdbcTemplate = customNamedParameterJdbcTemplate;
    }

    @Override
    public Long crear(Estudiante estudiante) {
        MapSqlParameterSource paramSource = new EstudianteMapSqlParameterSource(estudiante).mapearParametrosToSql();
        KeyHolder keyHolder = new GeneratedKeyHolder();

        this.customNamedParameterJdbcTemplate.getNamedParameterJdbcTemplate().update(sqlCrear, paramSource, keyHolder, new String[]{"id"});
        return Objects.requireNonNull(keyHolder.getKey()).longValue();
    }

    @Override
    public void actualizar(Estudiante estudiante) {
        MapSqlParameterSource paramSource = new EstudianteMapSqlParameterSource(estudiante).mapearParametrosToSql();

        this.customNamedParameterJdbcTemplate.getNamedParameterJdbcTemplate().update(sqlActualizar, paramSource);
    }

    @Override
    public void eliminar(Long id) {
        MapSqlParameterSource parameterSource = new MapSqlParameterSource();
        parameterSource.addValue("id", id);

        this.customNamedParameterJdbcTemplate.getNamedParameterJdbcTemplate().update(sqlEliminar, parameterSource);

    }


    @Override
    public Boolean existeConIdPersona(Long idPersona) {
        MapSqlParameterSource parameterSource = new MapSqlParameterSource();
        parameterSource.addValue("idPersona", idPersona);


        return this.customNamedParameterJdbcTemplate.getNamedParameterJdbcTemplate().queryForObject(sqlExisteConIdPersona, parameterSource, Boolean.class);
    }

    @Override
    public Boolean existeConIdEstudiante(Long idEstudiante) {
        MapSqlParameterSource parameterSource = new MapSqlParameterSource();
        parameterSource.addValue("idEstudiante", idEstudiante);


        return this.customNamedParameterJdbcTemplate.getNamedParameterJdbcTemplate().queryForObject(sqlExisteConIdEstudiante, parameterSource, Boolean.class);
    }
}
