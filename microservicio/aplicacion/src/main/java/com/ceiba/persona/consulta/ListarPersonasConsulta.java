package com.ceiba.persona.consulta;


import com.ceiba.persona.modelo.dto.PersonaDTO;
import com.ceiba.persona.puerto.dao.PersonaDAO;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class ListarPersonasConsulta {
    private final PersonaDAO personaDAO;

    public ListarPersonasConsulta(PersonaDAO personaDAO) {
        this.personaDAO = personaDAO;
    }

    public List<PersonaDTO> ejecutar(){
        return this.personaDAO.listar();
    }
}
