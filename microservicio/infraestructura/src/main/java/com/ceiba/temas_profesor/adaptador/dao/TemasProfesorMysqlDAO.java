package com.ceiba.temas_profesor.adaptador.dao;

import com.ceiba.infraestructura.jdbc.CustomNamedParameterJdbcTemplate;
import com.ceiba.infraestructura.jdbc.sqlstatement.SqlStatement;
import com.ceiba.temas_profesor.modelo.dto.TemasProfesorDTO;
import com.ceiba.temas_profesor.puerto.dao.TemasProfesorDAO;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class TemasProfesorMysqlDAO implements TemasProfesorDAO {
    private final CustomNamedParameterJdbcTemplate jdbcTemplate;

    @SqlStatement(namespace = "temas_profesor", value = "listar")
    private static String sqlListar;

    @SqlStatement(namespace = "temas_profesor", value = "obtener")
    private static String sqlObtener;

    public TemasProfesorMysqlDAO(CustomNamedParameterJdbcTemplate jdbcTemplate ) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public List<TemasProfesorDTO> listar() {
        return this.jdbcTemplate.getNamedParameterJdbcTemplate().query(sqlListar, new TemasProfesorMapeo());
    }

    @Override
    public List<TemasProfesorDTO> listarByProfesor(Long id) {
        MapSqlParameterSource source = new MapSqlParameterSource();
        source.addValue("id", id);

        return this.jdbcTemplate.getNamedParameterJdbcTemplate().query(sqlObtener, source, new TemasProfesorMapeo());
    }


}
