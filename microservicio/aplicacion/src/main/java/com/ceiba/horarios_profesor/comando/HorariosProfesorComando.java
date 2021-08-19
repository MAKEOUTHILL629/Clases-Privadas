package com.ceiba.horarios_profesor.comando;

import com.ceiba.horarios_profesor.modelo.clasificacion.DiasSemana;

import lombok.*;


@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class HorariosProfesorComando {
    private Long idProfesor;
    private DiasSemana diaSemana;
    private String hora;
}
