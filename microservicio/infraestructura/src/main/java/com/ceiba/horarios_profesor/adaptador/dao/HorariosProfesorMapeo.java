package com.ceiba.horarios_profesor.adaptador.dao;

import com.ceiba.horarios_profesor.modelo.dto.HorariosProfesorDTO;
import com.ceiba.infraestructura.jdbc.MapperResult;
import com.ceiba.profesor.consulta.ObtenerProfesorConsulta;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalTime;

public class HorariosProfesorMapeo implements RowMapper<HorariosProfesorDTO>, MapperResult {
    private final ObtenerProfesorConsulta obtenerProfesorConsulta;

    public HorariosProfesorMapeo(ObtenerProfesorConsulta obtenerProfesorConsulta) {
        this.obtenerProfesorConsulta = obtenerProfesorConsulta;
    }


    @Override
    public HorariosProfesorDTO mapRow(ResultSet rs, int rowNum) throws SQLException {
        Long id = rs.getLong("id");
        Long idProfesor = rs.getLong("id_profesor");
        String diaSemana = rs.getString("dia_semana");
        LocalTime hora = rs.getTime("hora").toLocalTime();

        return  new HorariosProfesorDTO(
                id,
                obtenerProfesorConsulta.ejecutar(idProfesor),
                diaSemana,
                hora);
    }
}
