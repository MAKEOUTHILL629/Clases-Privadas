package com.ceiba.estudiante.adaptador.dao;

import com.ceiba.estudiante.modelo.dto.EstudianteDTO;
import com.ceiba.estudiante.puerto.dao.EstudianteDAO;
import com.ceiba.infraestructura.jdbc.CustomNamedParameterJdbcTemplate;
import com.ceiba.infraestructura.jdbc.sqlstatement.SqlStatement;
import com.ceiba.persona.consulta.ObtenerPersonaManejadorConsulta;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class EstudianteMysqlDAO implements EstudianteDAO {
    private final CustomNamedParameterJdbcTemplate customNamedParameterJdbcTemplate;
    private final ObtenerPersonaManejadorConsulta obtenerPersonaManejadorConsulta;

    @SqlStatement(namespace = "estudiante", value = "listar")
    private static String sqlListar;

    @SqlStatement(namespace = "estudiante", value = "obtener")
    private static String sqlObtener;

    public EstudianteMysqlDAO(CustomNamedParameterJdbcTemplate customNamedParameterJdbcTemplate, ObtenerPersonaManejadorConsulta obtenerPersonaManejadorConsulta) {
        this.customNamedParameterJdbcTemplate = customNamedParameterJdbcTemplate;
        this.obtenerPersonaManejadorConsulta = obtenerPersonaManejadorConsulta;
    }

    @Override
    public List<EstudianteDTO> listar() {
        return this.customNamedParameterJdbcTemplate.getNamedParameterJdbcTemplate().query(sqlListar, new EstudianteMapeo(obtenerPersonaManejadorConsulta));
    }

    @Override
    public EstudianteDTO obtener(Long id) {
        MapSqlParameterSource source = new MapSqlParameterSource();
        source.addValue("id", id);

        return this.customNamedParameterJdbcTemplate.getNamedParameterJdbcTemplate().queryForObject(sqlObtener, source, new EstudianteMapeo(obtenerPersonaManejadorConsulta));
    }
}
