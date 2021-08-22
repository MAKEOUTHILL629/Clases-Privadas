package com.ceiba.horarios_profesor.modelo.dto;


import lombok.AllArgsConstructor;
import lombok.Getter;

import java.time.LocalTime;

@Getter
@AllArgsConstructor
public class HorariosProfesorDTO {
    private Long id;
    private Long idProfesor;
    private String diaSemana;
    private LocalTime hora;

}
