package com.ceiba.temas_profesor.consulta;

import com.ceiba.temas_profesor.modelo.dto.TemasProfesorDTO;
import com.ceiba.temas_profesor.puerto.dao.TemasProfesorDAO;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class ListarTemasProfesorConsulta {
    private final TemasProfesorDAO temasProfesorDAO;


    public ListarTemasProfesorConsulta(TemasProfesorDAO temasProfesorDAO) {
        this.temasProfesorDAO = temasProfesorDAO;
    }

    public List<TemasProfesorDTO> ejecutar() {
        return this.temasProfesorDAO.listar();
    }
}
