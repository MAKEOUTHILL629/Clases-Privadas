package com.ceiba.persona.consulta;


import com.ceiba.estudiante.puerto.dao.EstudianteDAO;
import com.ceiba.persona.modelo.dto.PersonaDTO;
import com.ceiba.persona.puerto.dao.PersonaDAO;
import org.springframework.stereotype.Component;

@Component
public class ObtenerPersonaConsulta {
    private final PersonaDAO personaDAO;

    public ObtenerPersonaConsulta(PersonaDAO personaDAO) {
        this.personaDAO = personaDAO;
    }

    public PersonaDTO ejecutar(Long id){
       return this.personaDAO.obtener(id);
    }
}
