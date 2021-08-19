package com.ceiba.persona.consulta;


import com.ceiba.persona.modelo.dto.PersonaDTO;
import com.ceiba.persona.puerto.dao.PersonaDAO;
import org.springframework.stereotype.Component;


@Component
public class ObtenerPersonaManejadorConsulta {
    private PersonaDAO obtenerPersonaServicio;

    public ObtenerPersonaManejadorConsulta(PersonaDAO obtenerPersonaServicio) {
        this.obtenerPersonaServicio = obtenerPersonaServicio;
    }

    public PersonaDTO ejecutar(Long id) {
        return this.obtenerPersonaServicio.obtener(id);
    }
}
