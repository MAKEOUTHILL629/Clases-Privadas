package com.ceiba.estudiante.consulta;

import com.ceiba.estudiante.modelo.dto.EstudianteDTO;
import com.ceiba.estudiante.puerto.dao.EstudianteDAO;
import org.springframework.stereotype.Component;

@Component
public class ObtenerEstudianteConsulta {
    private final EstudianteDAO estudianteDAO;

    public ObtenerEstudianteConsulta(EstudianteDAO estudianteDAO) {
        this.estudianteDAO = estudianteDAO;
    }

    public EstudianteDTO ejecutar(Long id){
        return this.estudianteDAO.obtener(id);
    }
}
