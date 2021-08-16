package com.ceiba.estudiante.puerto.dao;

import com.ceiba.estudiante.modelo.dto.EstudianteDTO;


import java.util.List;

public interface EstudianteDAO {
    /**
     * Permite listar los estudiantes
     * @return los estudiantes
     */
    List<EstudianteDTO> listar();
}
