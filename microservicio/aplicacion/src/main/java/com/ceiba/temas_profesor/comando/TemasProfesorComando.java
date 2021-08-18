package com.ceiba.temas_profesor.comando;

import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class TemasProfesorComando {
    private Long id;
    private Long idProfesor;
    private String tema;
}
