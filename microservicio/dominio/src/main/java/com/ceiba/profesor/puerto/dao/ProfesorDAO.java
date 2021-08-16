package com.ceiba.profesor.puerto.dao;


import com.ceiba.profesor.modelo.dto.ProfesorDTO;

import java.util.List;

public interface ProfesorDAO {

    /**
     * Permite listar los profesores
     *
     * @return los profesores
     */
    List<ProfesorDTO> listar();


    /**
     * Permite obtener un profesor con su id
     *
     * @return un profesor
     */
    ProfesorDTO obtener(Long id);
}
