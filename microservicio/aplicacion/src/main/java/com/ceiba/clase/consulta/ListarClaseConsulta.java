package com.ceiba.clase.consulta;

import com.ceiba.clase.modelo.dto.ClaseDTO;
import com.ceiba.clase.puerto.dao.ClaseDAO;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class ListarClaseConsulta {
    private final ClaseDAO claseDAO;

    public ListarClaseConsulta(ClaseDAO claseDAO) {
        this.claseDAO = claseDAO;
    }

    public List<ClaseDTO> ejecutar() {
        return this.claseDAO.listar();
    }
}
