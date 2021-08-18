package com.ceiba.estudiante.consulta;


import com.ceiba.estudiante.modelo.dto.EstudianteDTO;
import com.ceiba.estudiante.puerto.dao.EstudianteDAO;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class ListarEstudiantesConsulta {
    private final EstudianteDAO estudianteDAO;
    
    public ListarEstudiantesConsulta(EstudianteDAO estudianteDAO) {
        this.estudianteDAO = estudianteDAO;
    }

    public List<EstudianteDTO> ejecutar() {
        return this.estudianteDAO.listar();
    }

}
