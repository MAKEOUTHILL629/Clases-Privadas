package com.ceiba.clase.puerto.dao;

import com.ceiba.clase.modelo.dto.ClaseDTO;

import java.util.List;

public interface ClaseDAO {
    /**
     * Permite listar las clases
     * @return las clases
     */
    List<ClaseDTO> listar();


    /**
     * Permite obtener una clase con su id
     * @return  una clase
     */
    ClaseDTO obtener(Long id);

}
