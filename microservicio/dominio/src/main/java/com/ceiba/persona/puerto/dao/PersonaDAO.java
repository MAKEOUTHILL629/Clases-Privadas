package com.ceiba.persona.puerto.dao;

import com.ceiba.persona.modelo.dto.PersonaDTO;


import java.util.List;


public interface PersonaDAO {
    /**
     * Permite listar persona
     *
     * @return los personas
     */
    List<PersonaDTO> listar();

    /**
     * Permite obtener una persona con su id
     *
     * @return una persona
     */
    PersonaDTO obtener(Long id);


    /**
     * Permite saber si la persona existe en el sistema, con el id
     *
     * @return existe si o no
     */
    Boolean existe(Long id);
}
