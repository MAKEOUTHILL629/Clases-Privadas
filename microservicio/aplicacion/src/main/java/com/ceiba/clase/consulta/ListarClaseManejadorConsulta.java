package com.ceiba.clase.consulta;

import com.ceiba.clase.modelo.dto.ClaseDTO;
import com.ceiba.clase.puerto.dao.ClaseDAO;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class ListarClaseManejadorConsulta {
    private final ClaseDAO claseDAO;

    public ListarClaseManejadorConsulta(ClaseDAO claseDAO) {
        this.claseDAO = claseDAO;
    }

    public List<ClaseDTO> ejecutar() {
        return this.claseDAO.listar();
    }
}
