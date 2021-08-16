package com.ceiba.estudiante.adaptador.dao;

import com.ceiba.estudiante.modelo.dto.EstudianteDTO;
import com.ceiba.estudiante.puerto.dao.EstudianteDAO;
import com.ceiba.infraestructura.jdbc.CustomNamedParameterJdbcTemplate;
import com.ceiba.infraestructura.jdbc.sqlstatement.SqlStatement;
import com.ceiba.persona.consulta.ObtenerPersonaConsulta;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class EstudianteMysqlDAO implements EstudianteDAO {
    private final CustomNamedParameterJdbcTemplate jdbcTemplate;
    private final ObtenerPersonaConsulta obtenerPersonaConsulta;

    @SqlStatement(namespace = "estudiante", value = "listar")
    private static String sqlListar;

    @SqlStatement(namespace = "estudiante", value = "obtener")
    private static String sqlObtener;

    public EstudianteMysqlDAO(CustomNamedParameterJdbcTemplate jdbcTemplate, ObtenerPersonaConsulta obtenerPersonaConsulta) {
        this.jdbcTemplate = jdbcTemplate;
        this.obtenerPersonaConsulta = obtenerPersonaConsulta;
    }

    @Override
    public List<EstudianteDTO> listar() {
        return this.jdbcTemplate.getNamedParameterJdbcTemplate().query(sqlListar, new EstudianteMapeo(obtenerPersonaConsulta));
    }

    @Override
    public EstudianteDTO obtener(Long id) {
        MapSqlParameterSource source = new MapSqlParameterSource();
        source.addValue("id", id);

        return this.jdbcTemplate.getNamedParameterJdbcTemplate().queryForObject(sqlObtener, source, new EstudianteMapeo(obtenerPersonaConsulta));
    }
}
