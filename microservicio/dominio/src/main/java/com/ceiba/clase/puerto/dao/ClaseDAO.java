package com.ceiba.clase.puerto.dao;

import com.ceiba.clase.modelo.dto.ClaseDTO;

import java.util.List;

public interface ClaseDAO {
    /**
     * Permite listar las clases
     * @return las clases
     */
    List<ClaseDTO> listar();

}
