package com.ceiba.temas_profesor.adaptador.dao;

import com.ceiba.infraestructura.jdbc.CustomNamedParameterJdbcTemplate;
import com.ceiba.infraestructura.jdbc.sqlstatement.SqlStatement;
import com.ceiba.profesor.consulta.ObtenerProfesorConsulta;
import com.ceiba.profesor.modelo.dto.ProfesorDTO;
import com.ceiba.profesor.puerto.dao.ProfesorDAO;
import com.ceiba.temas_profesor.modelo.dto.TemasProfesorDTO;
import com.ceiba.temas_profesor.puerto.dao.TemasProfesorDAO;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.stereotype.Component;

import java.util.List;
@Component
public class TemasProfesorMysqlDAO implements TemasProfesorDAO {
    private final CustomNamedParameterJdbcTemplate jdbcTemplate;
    private final ObtenerProfesorConsulta obtenerProfesorConsulta;

    @SqlStatement(namespace = "temas_profesor", value = "listar")
    private static String sqlListar;

    @SqlStatement(namespace = "temas_profesor", value = "obtener")
    private static String sqlObtener;

    public TemasProfesorMysqlDAO(CustomNamedParameterJdbcTemplate jdbcTemplate, ObtenerProfesorConsulta obtenerProfesorConsulta) {
        this.jdbcTemplate = jdbcTemplate;
        this.obtenerProfesorConsulta = obtenerProfesorConsulta;
    }

    @Override
    public List<TemasProfesorDTO> listar() {
        return this.jdbcTemplate.getNamedParameterJdbcTemplate().query(sqlListar, new TemasProfesorMapeo(obtenerProfesorConsulta));
    }

    @Override
    public List<TemasProfesorDTO> listarByProfesor(Long id) {
        MapSqlParameterSource source = new MapSqlParameterSource();
        source.addValue("id", id);

        return this.jdbcTemplate.getNamedParameterJdbcTemplate().query(sqlObtener,source,new TemasProfesorMapeo(obtenerProfesorConsulta));
    }


}
