package com.ceiba.horarios_profesor.adaptador.dao;

import com.ceiba.horarios_profesor.modelo.dto.HorariosProfesorDTO;
import com.ceiba.horarios_profesor.puerto.dao.HorariosProfesorDAO;
import com.ceiba.infraestructura.jdbc.CustomNamedParameterJdbcTemplate;
import com.ceiba.infraestructura.jdbc.sqlstatement.SqlStatement;
import com.ceiba.profesor.consulta.ObtenerProfesorConsulta;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.stereotype.Component;

import java.util.List;
@Component
public class HorariosProfesorMysqlDAO implements HorariosProfesorDAO {
    private final CustomNamedParameterJdbcTemplate jdbcTemplate;
    private final ObtenerProfesorConsulta obtenerProfesorConsulta;

    @SqlStatement(namespace = "horarios_profesor", value = "listar")
    private static String sqlListar;

    @SqlStatement(namespace = "horarios_profesor", value = "obtener")
    private static String sqlObtener;


    public HorariosProfesorMysqlDAO(CustomNamedParameterJdbcTemplate jdbcTemplate, ObtenerProfesorConsulta obtenerProfesorConsulta) {
        this.jdbcTemplate = jdbcTemplate;
        this.obtenerProfesorConsulta = obtenerProfesorConsulta;
    }

    @Override
    public List<HorariosProfesorDTO> listar() {
        return this.jdbcTemplate.getNamedParameterJdbcTemplate().query(sqlListar, new HorariosProfesorMapeo(obtenerProfesorConsulta));
    }

    @Override
    public List<HorariosProfesorDTO> listarByProfesor(Long id) {
         MapSqlParameterSource source = new MapSqlParameterSource();
        source.addValue("id", id);;

        return this.jdbcTemplate.getNamedParameterJdbcTemplate().query(sqlObtener, source, new HorariosProfesorMapeo(obtenerProfesorConsulta));
    }
}
