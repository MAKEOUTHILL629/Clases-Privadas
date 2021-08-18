package com.ceiba.estudiante.comando;

import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class EstudianteComando {
    private Long id;
    private Long idPersona;
    private String nivelEstudios;
}
