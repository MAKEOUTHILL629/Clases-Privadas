package com.ceiba.estudiante.modelo.dto;

import com.ceiba.estudiante.modelo.clasificacion.NivelEstudios;
import com.ceiba.persona.modelo.dto.PersonaDTO;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class EstudianteDTO {
    private Long id;
    private PersonaDTO persona;
    private NivelEstudios nivelEstudios;
}

