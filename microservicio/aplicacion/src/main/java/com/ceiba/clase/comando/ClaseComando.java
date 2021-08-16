package com.ceiba.clase.comando;

import lombok.Data;

import java.time.LocalDateTime;

@Data
public class ClaseComando {
    private Long id;
    private Long idEstudiante;
    private Long idProfesor;
    private LocalDateTime fecha;
    private Double valor;
}
