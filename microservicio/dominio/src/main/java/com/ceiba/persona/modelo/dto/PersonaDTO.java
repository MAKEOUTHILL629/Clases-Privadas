package com.ceiba.persona.modelo.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class PersonaDTO {
    private Long id;
    private String nombres;
    private String apellidos;
    private String cedula;

    public PersonaDTO(Long id) {
        this.id = id;
    }
}
