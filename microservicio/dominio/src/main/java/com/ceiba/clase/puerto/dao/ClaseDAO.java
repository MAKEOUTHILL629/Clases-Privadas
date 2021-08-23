package com.ceiba.clase.puerto.dao;

import com.ceiba.clase.modelo.dto.ClaseDTO;

import java.util.List;

public interface ClaseDAO {
    /**
     * Permite listar las clases
     *
     * @return las clases
     */
    List<ClaseDTO> listar();


    /**
     * Permite obtener una clase con su id
     * @param id id de la clase a consultar
     * @return una clase
     */
    ClaseDTO obtener(Long id);

    /**
     * Permite obtener un listados de clases por el id del estudiante
     * @param  id id del estudiante a consultar
     * @return un listado de clases
     * */
    List<ClaseDTO> obtenerClasesIdEstudiante(Long id);

}
