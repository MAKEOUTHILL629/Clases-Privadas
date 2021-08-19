package com.ceiba.estudiante.comando.comando;

import com.ceiba.estudiante.modelo.clasificacion.NivelEstudios;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class EstudianteComandActualizar {
    private NivelEstudios nivelEstudios;
}
