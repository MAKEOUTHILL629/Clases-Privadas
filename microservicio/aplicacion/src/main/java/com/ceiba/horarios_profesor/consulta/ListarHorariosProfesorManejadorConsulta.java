package com.ceiba.horarios_profesor.consulta;

import com.ceiba.horarios_profesor.modelo.dto.HorariosProfesorDTO;
import com.ceiba.horarios_profesor.puerto.dao.HorariosProfesorDAO;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class ListarHorariosProfesorManejadorConsulta {
    private final HorariosProfesorDAO horariosProfesorDAO;

    public ListarHorariosProfesorManejadorConsulta(HorariosProfesorDAO horariosProfesorDAO) {
        this.horariosProfesorDAO = horariosProfesorDAO;
    }

    public List<HorariosProfesorDTO> ejecutar() {
        return this.horariosProfesorDAO.listar();
    }
}
