package com.ceiba.clase.adaptador.dao;

import com.ceiba.clase.modelo.dto.ClaseDTO;
import com.ceiba.clase.puerto.dao.ClaseDAO;
import com.ceiba.estudiante.consulta.ObtenerEstudianteConsulta;
import com.ceiba.infraestructura.jdbc.CustomNamedParameterJdbcTemplate;
import com.ceiba.infraestructura.jdbc.sqlstatement.SqlStatement;
import com.ceiba.profesor.consulta.ObtenerProfesorConsulta;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class ClaseMysqlDAO implements ClaseDAO {
    private final CustomNamedParameterJdbcTemplate jdbcTemplate;
    private final ObtenerEstudianteConsulta obtenerEstudianteConsulta;
    private final ObtenerProfesorConsulta obtenerProfesorConsulta;

    public ClaseMysqlDAO(CustomNamedParameterJdbcTemplate jdbcTemplate, ObtenerEstudianteConsulta obtenerEstudianteConsulta, ObtenerProfesorConsulta obtenerProfesorConsulta) {
        this.jdbcTemplate = jdbcTemplate;
        this.obtenerEstudianteConsulta = obtenerEstudianteConsulta;
        this.obtenerProfesorConsulta = obtenerProfesorConsulta;
    }

    @SqlStatement(namespace = "clase", value = "listar")
    private static String sqlListar;

    @SqlStatement(namespace = "clase", value = "obtener")
    private static String sqlObtener;

    @Override
    public List<ClaseDTO> listar() {
        return this.jdbcTemplate.getNamedParameterJdbcTemplate().query(sqlListar, new ClaseMapeo(obtenerEstudianteConsulta, obtenerProfesorConsulta));
    }

    @Override
    public ClaseDTO obtener(Long id) {
        MapSqlParameterSource source = new MapSqlParameterSource();
        source.addValue("id", id);
        return this.jdbcTemplate.getNamedParameterJdbcTemplate().queryForObject(sqlObtener, source, new ClaseMapeo(obtenerEstudianteConsulta, obtenerProfesorConsulta));
    }
}
