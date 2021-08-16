package com.ceiba.profesor.adaptador.dao;

import com.ceiba.infraestructura.jdbc.CustomNamedParameterJdbcTemplate;
import com.ceiba.infraestructura.jdbc.sqlstatement.SqlStatement;
import com.ceiba.persona.consulta.ObtenerPersonaConsulta;
import com.ceiba.profesor.modelo.dto.ProfesorDTO;
import com.ceiba.profesor.puerto.dao.ProfesorDAO;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class ProfesorMysqlDAO implements ProfesorDAO {
    private final CustomNamedParameterJdbcTemplate jdbcTemplate;
    private final ObtenerPersonaConsulta obtenerPersonaConsulta;

    @SqlStatement(namespace = "profesor", value = "listar")
    private static String sqlListar;

    public ProfesorMysqlDAO(CustomNamedParameterJdbcTemplate jdbcTemplate, ObtenerPersonaConsulta obtenerPersonaConsulta) {
        this.jdbcTemplate = jdbcTemplate;
        this.obtenerPersonaConsulta = obtenerPersonaConsulta;
    }


    @Override
    public List<ProfesorDTO> listar() {
        return this.jdbcTemplate.getNamedParameterJdbcTemplate().query(sqlListar, new ProfesorMapeo(obtenerPersonaConsulta));
    }
}
