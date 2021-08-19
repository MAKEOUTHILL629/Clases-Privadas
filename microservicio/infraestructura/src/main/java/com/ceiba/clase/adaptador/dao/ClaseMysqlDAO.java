package com.ceiba.clase.adaptador.dao;

import com.ceiba.clase.modelo.dto.ClaseDTO;
import com.ceiba.clase.puerto.dao.ClaseDAO;
import com.ceiba.estudiante.consulta.ObtenerEstudianteManejadorConsulta;
import com.ceiba.infraestructura.jdbc.CustomNamedParameterJdbcTemplate;
import com.ceiba.infraestructura.jdbc.sqlstatement.SqlStatement;
import com.ceiba.profesor.consulta.ObtenerProfesorManejadorConsulta;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class ClaseMysqlDAO implements ClaseDAO {
    private final CustomNamedParameterJdbcTemplate jdbcTemplate;
    private final ObtenerEstudianteManejadorConsulta obtenerEstudianteManejadorConsulta;
    private final ObtenerProfesorManejadorConsulta obtenerProfesorManejadorConsulta;


    @SqlStatement(namespace = "clase", value = "listar")
    private static String sqlListar;

    @SqlStatement(namespace = "clase", value = "obtener")
    private static String sqlObtener;

    public ClaseMysqlDAO(CustomNamedParameterJdbcTemplate jdbcTemplate, ObtenerEstudianteManejadorConsulta obtenerEstudianteManejadorConsulta, ObtenerProfesorManejadorConsulta obtenerProfesorManejadorConsulta) {
        this.jdbcTemplate = jdbcTemplate;
        this.obtenerEstudianteManejadorConsulta = obtenerEstudianteManejadorConsulta;
        this.obtenerProfesorManejadorConsulta = obtenerProfesorManejadorConsulta;
    }

    @Override
    public List<ClaseDTO> listar() {
        return this.jdbcTemplate.getNamedParameterJdbcTemplate().query(sqlListar, new ClaseMapeo(obtenerEstudianteManejadorConsulta, obtenerProfesorManejadorConsulta));
    }

    @Override
    public ClaseDTO obtener(Long id) {
        MapSqlParameterSource mapSqlParameterSource = new MapSqlParameterSource();
        mapSqlParameterSource.addValue("id", id);
        return this.jdbcTemplate.getNamedParameterJdbcTemplate().queryForObject(sqlObtener, mapSqlParameterSource, new ClaseMapeo(obtenerEstudianteManejadorConsulta, obtenerProfesorManejadorConsulta));
    }
}
