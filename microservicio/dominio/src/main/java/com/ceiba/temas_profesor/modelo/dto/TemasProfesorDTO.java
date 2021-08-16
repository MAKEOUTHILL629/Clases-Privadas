package com.ceiba.temas_profesor.modelo.dto;

import com.ceiba.profesor.modelo.dto.ProfesorDTO;
import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class TemasProfesorDTO {
    private Long id;
    private ProfesorDTO profesorDTO;
    private String tema;
}
