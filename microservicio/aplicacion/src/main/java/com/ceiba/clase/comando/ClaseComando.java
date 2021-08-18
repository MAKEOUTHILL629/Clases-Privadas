package com.ceiba.clase.comando;

import lombok.*;

import java.time.LocalDateTime;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ClaseComando {
    private Long id;
    private Long idEstudiante;
    private Long idProfesor;
    private LocalDateTime fecha;
    private Double valor;
}
