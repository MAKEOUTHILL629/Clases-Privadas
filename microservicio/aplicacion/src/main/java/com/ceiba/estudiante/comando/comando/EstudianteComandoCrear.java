package com.ceiba.estudiante.comando.comando;

import com.ceiba.estudiante.modelo.clasificacion.NivelEstudios;
import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class EstudianteComandoCrear {
    private Long idPersona;
    private NivelEstudios nivelEstudios;
}
