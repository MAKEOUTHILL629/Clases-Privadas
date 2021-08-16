package com.ceiba.profesor.puerto.repositorio;

import com.ceiba.profesor.modelo.entidad.Profesor;

public interface ProfesorRepositorio {

    /**
     * Permite crear un Profesor
     *
     * @param profesor
     * @return el id generado
     */
    Long crear(Profesor profesor);

    /**
     * Permite actualizar un Estudiante
     *
     * @param profesor
     */
    void actualizar(Profesor profesor);

    /**
     * Permite eliminar un profesor
     *
     * @param id
     */
    void eliminar(Long id);

    /**
     * Permite validar si existe un profesor con un id
     *
     * @param id
     * @return si existe o no
     */
    boolean existe(Long id);

}
