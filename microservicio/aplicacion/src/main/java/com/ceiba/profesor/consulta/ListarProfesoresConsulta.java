package com.ceiba.profesor.consulta;

import com.ceiba.profesor.modelo.dto.ProfesorDTO;
import com.ceiba.profesor.puerto.dao.ProfesorDAO;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class ListarProfesoresConsulta {
    private final ProfesorDAO profesorDAO;

    public ListarProfesoresConsulta(ProfesorDAO profesorDAO) {
        this.profesorDAO = profesorDAO;
    }

    public List<ProfesorDTO> ejecutar(){
        return this.profesorDAO.listar();
    }
}
