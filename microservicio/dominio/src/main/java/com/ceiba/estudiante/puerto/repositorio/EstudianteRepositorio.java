package com.ceiba.estudiante.puerto.repositorio;

import com.ceiba.estudiante.modelo.entidad.Estudiante;


public interface EstudianteRepositorio {

    /**
     * Permite crear un Estudiante
     *
     * @param estudiante
     * @return el id generado
     */
    Long crear(Estudiante estudiante);

    /**
     * Permite actualizar un Estudiante
     *
     * @param estudiante
     */
    void actualizar(Estudiante estudiante);

    /**
     * Permite eliminar un estudiante
     *
     * @param id
     */
    void eliminar(Long id);



    /**
     * Permite validar si existe un estudiante con un id con el id de la persona
     *
     * @param id de la persona
     * @return si existe o no
     */
    Boolean existeConIdPersona(Long id);

    /**
     * Permite validar si existe un estudiante con el id del estudiante
     * @param id del estudiante
     * @return si existe o no
     * */
    Boolean existeConIdEstudiante(Long id);


}
