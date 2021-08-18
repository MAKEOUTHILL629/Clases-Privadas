package com.ceiba.horarios_profesor.comando;

import lombok.*;

import java.time.LocalTime;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class HorariosProfesorComando {
    private Long id;
    private Long idProfesor;
    private String diaSemana;
    private LocalTime hora;
}
