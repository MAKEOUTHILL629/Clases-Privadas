package com.ceiba.clase.adaptador.dao;

import com.ceiba.clase.modelo.dto.ClaseDTO;
import com.ceiba.estudiante.consulta.ObtenerEstudianteManejadorConsulta;
import com.ceiba.infraestructura.jdbc.MapperResult;
import com.ceiba.profesor.consulta.ObtenerProfesorManejadorConsulta;

import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDateTime;

public class ClaseMapeo implements RowMapper<ClaseDTO>, MapperResult {
    private final ObtenerEstudianteManejadorConsulta obtenerEstudianteManejadorConsulta;
    private final ObtenerProfesorManejadorConsulta obtenerProfesorManejadorConsulta;

    public ClaseMapeo(ObtenerEstudianteManejadorConsulta obtenerEstudianteManejadorConsulta, ObtenerProfesorManejadorConsulta obtenerProfesorManejadorConsulta) {
        this.obtenerEstudianteManejadorConsulta = obtenerEstudianteManejadorConsulta;
        this.obtenerProfesorManejadorConsulta = obtenerProfesorManejadorConsulta;
    }

    @Override
    public ClaseDTO mapRow(ResultSet rs, int rowNum) throws SQLException {
        Long id = rs.getLong("id");
        Long idEstudiante = rs.getLong("id_estudiante");
        Long idProfesor = rs.getLong("id_profesor");
        LocalDateTime fecha = extraerLocalDateTime(rs, "fecha");
        Double valor = rs.getDouble("valor");
        return new ClaseDTO(id,
                obtenerEstudianteManejadorConsulta.ejecutar(idEstudiante),
                obtenerProfesorManejadorConsulta.ejecutar(idProfesor),
                fecha,
                valor
        );
    }
}
