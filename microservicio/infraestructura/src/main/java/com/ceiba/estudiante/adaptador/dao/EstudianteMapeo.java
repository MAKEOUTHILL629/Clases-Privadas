package com.ceiba.estudiante.adaptador.dao;



import com.ceiba.persona.consulta.ObtenerPersonaConsulta;
import com.ceiba.persona.modelo.dto.PersonaDTO;
import com.ceiba.persona.modelo.entidad.Persona;

import com.ceiba.persona.puerto.dao.PersonaDAO;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.RowMapper;
import com.ceiba.estudiante.modelo.dto.EstudianteDTO;
import com.ceiba.infraestructura.jdbc.MapperResult;
import org.springframework.stereotype.Component;

import java.sql.ResultSet;
import java.sql.SQLException;


public class EstudianteMapeo implements RowMapper<EstudianteDTO>, MapperResult {


    private Log LOGGER = LogFactory.getLog(EstudianteMapeo.class);

    @Override
    public EstudianteDTO mapRow(ResultSet rs, int rowNum) throws SQLException {
        Long id = rs.getLong("id");
        Long idPersona = rs.getLong("id_persona");
        String nivelEstudios = rs.getString("nivel_estudios");

        return new EstudianteDTO(id, new PersonaDTO(idPersona), nivelEstudios);
    }
}
