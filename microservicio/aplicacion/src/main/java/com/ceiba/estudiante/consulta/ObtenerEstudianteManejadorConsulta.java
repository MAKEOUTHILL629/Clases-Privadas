package com.ceiba.estudiante.consulta;

import com.ceiba.estudiante.modelo.dto.EstudianteDTO;
import com.ceiba.estudiante.puerto.dao.EstudianteDAO;
import org.springframework.stereotype.Component;

@Component
public class ObtenerEstudianteManejadorConsulta {
    private final EstudianteDAO estudianteDAO;

    public ObtenerEstudianteManejadorConsulta(EstudianteDAO estudianteDAO) {
        this.estudianteDAO = estudianteDAO;
    }

    public EstudianteDTO ejecutar(Long id) {
        return this.estudianteDAO.obtener(id);
    }
}
