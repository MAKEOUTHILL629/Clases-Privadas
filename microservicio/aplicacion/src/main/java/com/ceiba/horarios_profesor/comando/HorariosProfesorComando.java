package com.ceiba.horarios_profesor.comando;

import lombok.Data;

import java.time.LocalTime;

@Data
public class HorariosProfesorComando {
    private Long id;
    private Long idProfesor;
    private String diaSemana;
    private LocalTime hora;
}
