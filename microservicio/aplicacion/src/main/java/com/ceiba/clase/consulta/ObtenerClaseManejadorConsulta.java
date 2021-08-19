package com.ceiba.clase.consulta;

import com.ceiba.clase.modelo.dto.ClaseDTO;
import com.ceiba.clase.puerto.dao.ClaseDAO;
import org.springframework.stereotype.Component;

@Component
public class ObtenerClaseManejadorConsulta {
    private final ClaseDAO claseDAO;

    public ObtenerClaseManejadorConsulta(ClaseDAO claseDAO) {
        this.claseDAO = claseDAO;
    }

    public ClaseDTO ejecutar(Long id) {
        return this.claseDAO.obtener(id);
    }
}
