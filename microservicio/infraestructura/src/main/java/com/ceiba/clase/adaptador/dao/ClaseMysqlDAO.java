package com.ceiba.clase.adaptador.dao;

import com.ceiba.clase.modelo.dto.ClaseDTO;
import com.ceiba.clase.modelo.entidad.Clase;
import com.ceiba.clase.puerto.dao.ClaseDAO;
import com.ceiba.estudiante.consulta.ObtenerEstudianteConsulta;
import com.ceiba.infraestructura.jdbc.CustomNamedParameterJdbcTemplate;
import com.ceiba.infraestructura.jdbc.sqlstatement.SqlStatement;
import com.ceiba.profesor.consulta.ObtenerProfesorConsulta;

import java.util.List;

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

    @Override
    public List<ClaseDTO> listar() {
        return this.jdbcTemplate.getNamedParameterJdbcTemplate().query(sqlListar, new ClaseMapeo(obtenerEstudianteConsulta,obtenerProfesorConsulta));
    }
}
