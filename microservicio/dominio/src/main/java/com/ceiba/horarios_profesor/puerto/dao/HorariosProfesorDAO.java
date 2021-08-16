package com.ceiba.horarios_profesor.puerto.dao;

import com.ceiba.horarios_profesor.modelo.entidad.HorariosProfesor;

import java.util.List;

public interface HorariosProfesorDAO {

    /**
     * Permite listar todos los horarios de los profesores
     *
     * @return los horarios
     * */
    List<HorariosProfesor> listar();

    /**
     * Permite listar los horarios del profesor en concreto
     * @param id
     * @return la listar de horarios del profesor
     */
    List<HorariosProfesor> listarByProfesor(Long id);
}
