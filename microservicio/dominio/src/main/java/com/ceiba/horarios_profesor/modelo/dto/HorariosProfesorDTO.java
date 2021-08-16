package com.ceiba.horarios_profesor.modelo.dto;

import com.ceiba.profesor.modelo.dto.ProfesorDTO;
import lombok.AllArgsConstructor;
import lombok.Getter;

import java.time.LocalTime;

@Getter
@AllArgsConstructor
public class HorariosProfesorDTO {
    private Long id;
    private ProfesorDTO profesorDTO;
    private String diaSemana;
    private LocalTime hora;

}
