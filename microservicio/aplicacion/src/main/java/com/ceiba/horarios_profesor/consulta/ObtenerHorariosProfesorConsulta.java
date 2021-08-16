package com.ceiba.horarios_profesor.consulta;

import com.ceiba.horarios_profesor.modelo.dto.HorariosProfesorDTO;
import com.ceiba.horarios_profesor.puerto.dao.HorariosProfesorDAO;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class ObtenerHorariosProfesorConsulta {
    private final HorariosProfesorDAO horariosProfesorDAO;

    public ObtenerHorariosProfesorConsulta(HorariosProfesorDAO horariosProfesorDAO) {
        this.horariosProfesorDAO = horariosProfesorDAO;
    }

    public List<HorariosProfesorDTO> ejecutar(Long id){
        return this.horariosProfesorDAO.listarByProfesor(id);
    }
}
