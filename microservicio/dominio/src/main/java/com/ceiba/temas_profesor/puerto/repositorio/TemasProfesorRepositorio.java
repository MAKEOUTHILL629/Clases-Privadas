package com.ceiba.temas_profesor.puerto.repositorio;


import com.ceiba.temas_profesor.modelo.entidad.TemasProfesor;

public interface TemasProfesorRepositorio {

    /**
     * Permite crear un tema
     *
     * @param tema
     * @return el id generado
     */
    Long crear(TemasProfesor tema);

    /**
     * Permite actualizar un Estudiante
     *
     * @param tema
     */
    void actualizar(TemasProfesor tema);

    /**
     * Permite eliminar un tema
     *
     * @param id
     */
    void eliminar(Long id);

    /**
     * Permite validar si existe un tema con un id
     *
     * @param id
     * @return si existe o no
     */
    boolean existe(Long id);
}
