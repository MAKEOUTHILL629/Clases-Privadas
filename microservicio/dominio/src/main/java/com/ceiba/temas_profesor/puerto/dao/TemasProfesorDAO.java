package com.ceiba.temas_profesor.puerto.dao;

import com.ceiba.temas_profesor.modelo.dto.TemasProfesorDTO;


import java.util.List;

public interface TemasProfesorDAO {

    /**
     * Permite listar todos los temas que tratan los profesores
     *
     * @return los temas
     * */
    List<TemasProfesorDTO> listar();

    /**
     * Permite obtener una lista de temas, por el id del profesor
     *
     * @return la lista de temas del profesor
     * */
    List<TemasProfesorDTO> listarByProfesor(Long id);

}
