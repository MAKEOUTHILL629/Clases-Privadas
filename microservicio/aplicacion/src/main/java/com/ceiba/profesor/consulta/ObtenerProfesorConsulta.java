package com.ceiba.profesor.consulta;

import com.ceiba.profesor.modelo.dto.ProfesorDTO;
import com.ceiba.profesor.puerto.dao.ProfesorDAO;
import org.springframework.stereotype.Component;

@Component
public class ObtenerProfesorConsulta {
    private final ProfesorDAO profesorDAO;

    public ObtenerProfesorConsulta(ProfesorDAO profesorDAO) {
        this.profesorDAO = profesorDAO;
    }

    public ProfesorDTO ejecutar(Long id) {
        return this.profesorDAO.obtener(id);
    }
}
