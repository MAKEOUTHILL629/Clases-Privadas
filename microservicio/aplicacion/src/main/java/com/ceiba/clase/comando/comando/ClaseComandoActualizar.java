package com.ceiba.clase.comando.comando;

import lombok.*;

import java.time.LocalDateTime;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ClaseComandoActualizar {

    private Long idEstudiante;
    private Long idProfesor;
    private LocalDateTime fecha;


}
