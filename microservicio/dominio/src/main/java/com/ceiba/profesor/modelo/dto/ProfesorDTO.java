package com.ceiba.profesor.modelo.dto;

import com.ceiba.persona.modelo.dto.PersonaDTO;
import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class ProfesorDTO {
    private Long id;
    private PersonaDTO persona;
    private String profesion;
}
