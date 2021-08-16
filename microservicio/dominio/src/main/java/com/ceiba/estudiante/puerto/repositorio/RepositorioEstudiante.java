package com.ceiba.estudiante.puerto.repositorio;

import com.ceiba.estudiante.modelo.entidad.Estudiante;
import com.ceiba.usuario.modelo.entidad.Usuario;

public interface RepositorioEstudiante {

    /**
     * Permite crear un Estudiante
     * @param estudiante
     * @return el id generado
     */
    Long crear(Estudiante estudiante);

    /**
     * Permite actualizar un Estudiante
     * @param estudiante
     */
    void actualizar(Estudiante estudiante);

    /**
     * Permite eliminar un estudiante
     * @param id
     */
    void eliminar(Long id);

    /**
     * Permite validar si existe un usuario con un nombre
     * @param nombre
     * @return si existe o no
     */
    boolean existe(String nombre);

    /**
     * Permite validar si existe un usuario con un nombre excluyendo un id
     * @param nombre
     * @return si existe o no
     */
    boolean existeExcluyendoId(Long id,String nombre);



}
