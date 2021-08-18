package com.ceiba.temas_profesor.consulta;

import com.ceiba.temas_profesor.modelo.dto.TemasProfesorDTO;
import com.ceiba.temas_profesor.puerto.dao.TemasProfesorDAO;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class ObtenerTemasProfesorConsulta {
    private final TemasProfesorDAO temasProfesorDAO;

    public ObtenerTemasProfesorConsulta(TemasProfesorDAO temasProfesorDAO) {
        this.temasProfesorDAO = temasProfesorDAO;
    }

    public List<TemasProfesorDTO> ejecutar(Long id) {
        return this.temasProfesorDAO.listarByProfesor(id);
    }
}
