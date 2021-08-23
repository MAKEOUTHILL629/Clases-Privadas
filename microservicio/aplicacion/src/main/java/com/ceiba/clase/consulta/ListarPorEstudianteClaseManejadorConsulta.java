package com.ceiba.clase.consulta;

import com.ceiba.clase.modelo.dto.ClaseDTO;
import com.ceiba.clase.puerto.dao.ClaseDAO;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class ListarPorEstudianteClaseManejadorConsulta {
    private final ClaseDAO claseDAO;

    public ListarPorEstudianteClaseManejadorConsulta(ClaseDAO claseDAO) {
        this.claseDAO = claseDAO;
    }

    public List<ClaseDTO> ejecutar(Long id) {
        return this.claseDAO.obtenerClasesIdEstudiante(id);
    }
}
