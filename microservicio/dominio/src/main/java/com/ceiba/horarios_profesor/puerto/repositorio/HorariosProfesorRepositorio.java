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
     * Permite validar si existe un horario con un id
     *
     * @param id
     * @return si existe o no
     */
    boolean existe(Long id);
}
