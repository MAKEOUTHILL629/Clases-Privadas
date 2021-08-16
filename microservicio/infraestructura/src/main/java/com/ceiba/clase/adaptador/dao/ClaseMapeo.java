package com.ceiba.clase.adaptador.dao;

import com.ceiba.clase.modelo.dto.ClaseDTO;
import com.ceiba.estudiante.consulta.ObtenerEstudianteConsulta;
import com.ceiba.infraestructura.jdbc.MapperResult;
import com.ceiba.profesor.consulta.ObtenerProfesorConsulta;

import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDateTime;

public class ClaseMapeo implements RowMapper<ClaseDTO>, MapperResult {
    private final ObtenerEstudianteConsulta obtenerEstudianteConsulta;
    private final ObtenerProfesorConsulta obtenerProfesorConsulta;

    public ClaseMapeo(ObtenerEstudianteConsulta obtenerEstudianteConsulta, ObtenerProfesorConsulta obtenerProfesorConsulta) {
        this.obtenerEstudianteConsulta = obtenerEstudianteConsulta;
        this.obtenerProfesorConsulta = obtenerProfesorConsulta;
    }

    @Override
    public ClaseDTO mapRow(ResultSet rs, int rowNum) throws SQLException {
        Long id = rs.getLong("id");
        Long idEstudiante = rs.getLong("id_estudiante");
        Long idProfesor = rs.getLong("id_profesor");
        LocalDateTime fecha = extraerLocalDateTime(rs, "fecha");
        Double valor = rs.getDouble("valor");
        return new ClaseDTO(id,
                obtenerEstudianteConsulta.ejecutar(idEstudiante),
                obtenerProfesorConsulta.ejecutar(idProfesor),
                fecha,
                valor
                );
    }
}
