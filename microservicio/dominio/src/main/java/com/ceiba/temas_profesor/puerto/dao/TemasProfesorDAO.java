package com.ceiba.temas_profesor.puerto.dao;

import com.ceiba.temas_profesor.modelo.entidad.TemasProfesor;

import java.util.List;

public interface TemasProfesorDAO {

    /**
     * Permite listar todos los temas que tratan los profesores
     *
     * @return los temas
     * */
    List<TemasProfesor> listar();

    /**
     * Permite obtener una lista de temas, por el id del profesor
     *
     * @return la lista de temas del profesor
     * */
    List<TemasProfesor> listarByProfesor(Long id);

}
