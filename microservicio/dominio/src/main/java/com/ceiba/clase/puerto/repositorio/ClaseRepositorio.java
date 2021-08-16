package com.ceiba.clase.puerto.repositorio;

import com.ceiba.clase.modelo.entidad.Clase;


public interface ClaseRepositorio {
    /**
     * Permite crear una clase
     *
     * @param clase
     * @return el id generado
     */
    Long crear(Clase clase);

    /**
     * Permite actualizar una clase
     *
     * @param clase
     */
    void actualizar(Clase clase);

    /**
     * Permite eliminar una clase
     *
     * @param id
     */
    void eliminar(Long id);

    /**
     * Permite validar si existe una clase con un id
     *
     * @param id
     * @return si existe o no
     */
    boolean existe(Long id);
}
