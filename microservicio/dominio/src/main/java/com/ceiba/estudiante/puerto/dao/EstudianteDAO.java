package com.ceiba.estudiante.puerto.dao;

import com.ceiba.estudiante.modelo.dto.EstudianteDTO;
import com.ceiba.usuario.modelo.dto.DtoUsuario;

import java.util.List;

public interface EstudianteDAO {
    /**
     * Permite listar los estudiantes
     * @return los estudiantes
     */
    List<EstudianteDTO> listar();
}
