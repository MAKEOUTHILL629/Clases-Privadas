package com.ceiba.clase.modelo.dto;

import com.ceiba.estudiante.modelo.dto.EstudianteDTO;
import com.ceiba.profesor.modelo.dto.ProfesorDTO;
import lombok.AllArgsConstructor;
import lombok.Getter;


import java.time.LocalDateTime;

@Getter
@AllArgsConstructor
public class ClaseDTO {
    private Long id;
    private EstudianteDTO estudianteDTO;
    private ProfesorDTO profesorDTO;
    private LocalDateTime fecha;
    private Double valor;
}
