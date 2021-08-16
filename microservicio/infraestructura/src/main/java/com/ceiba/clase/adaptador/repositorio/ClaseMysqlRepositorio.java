package com.ceiba.clase.adaptador.repositorio;

import com.ceiba.clase.modelo.entidad.Clase;
import com.ceiba.clase.puerto.repositorio.ClaseRepositorio;
import com.ceiba.infraestructura.jdbc.CustomNamedParameterJdbcTemplate;

public class ClaseMysqlRepositorio implements ClaseRepositorio {
    private final CustomNamedParameterJdbcTemplate jdbcTemplate;

    public ClaseMysqlRepositorio(CustomNamedParameterJdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public Long crear(Clase clase) {
        return null;
    }

    @Override
    public void actualizar(Clase clase) {

    }

    @Override
    public void eliminar(Long id) {

    }

    @Override
    public boolean existe(Long id) {
        return false;
    }
}
