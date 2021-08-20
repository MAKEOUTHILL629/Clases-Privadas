package com.ceiba.horarios_profesor.puerto.repositorio;

import com.ceiba.horarios_profesor.modelo.entidad.HorariosProfesor;

public interface HorariosProfesorRepositorio {
    /**
     * Permite crear un horario
     *
     * @param horarios
     * @return el id generado
     */
    Long crear(HorariosProfesor horarios);

    /**
     * Permite actualizar un horario
     *
     * @param horarios
     */
    void actualizar(HorariosProfesor horarios);

    /**
     * Permite eliminar un horario
     *
     * @param id
     */
    void eliminar(Long id);

    /**
     * Permite validar si existe un horario, a partir del id del profesor y de la hora y el dia
     *
     * @param horariosProfesor
     * @return si existe o no
     */
    boolean existeSinIdHorariosProfesor(HorariosProfesor horariosProfesor);


    /**
     * Permite validar si existe un horario, a partir del id del horario
     *
     * @param id del horario
     * @return si existe o no
     */
    boolean existeConId(Long id);
}
