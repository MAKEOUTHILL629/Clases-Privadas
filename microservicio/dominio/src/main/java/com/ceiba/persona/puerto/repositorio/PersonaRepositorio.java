package com.ceiba.persona.puerto.repositorio;

import com.ceiba.persona.modelo.entidad.Persona;


public interface PersonaRepositorio {
    /**
     * Permite crear un usuario
     *
     * @param persona
     * @return el id generado
     */
    Long crear(Persona persona);

    /**
     * Permite actualizar una persona
     *
     * @param persona
     */
    void actualizar(Persona persona);

    /**
     * Permite eliminar una persona
     *
     * @param id
     */
    void eliminar(Long id);

    /**
     * Permite validar si existe una persona con un cedula
     *
     * @param cedula
     * @return si existe o no
     */
    boolean existe(String cedula);

    /**
     * Permite validar si existe una persona con un id
     *
     * @param id
     * @return si existe o no
     */
    boolean existeExcluyendoId(Long id);
}
