package com.ceiba.clase.comando;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ClaseComando {
    private Long idEstudiante;
    private Long idProfesor;
    private LocalDateTime fecha;
}
