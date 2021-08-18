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
     * Permite validar si existe una clase con un el id del estudiante
     *
     * @param clase
     * @return si existe o no
     */
    boolean existe(Clase clase);


    /**
     * Permite validar si existe una clase con todos los parametros que utiliza
     *
     * @param clase
     * @return si existe o no
     */
    boolean esRepetido(Clase clase);
}
