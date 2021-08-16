package com.ceiba.estudiante.comando.fabrica;

import com.ceiba.estudiante.comando.ComandoEstudiante;
import com.ceiba.estudiante.modelo.entidad.Estudiante;
import org.springframework.stereotype.Component;

@Component
public class FabricaEstudiante {

    public Estudiante crear(ComandoEstudiante comandoEstudiante) {

        return new Estudiante(
                comandoEstudiante.getId(),
                comandoEstudiante.getFirst_name(),
                comandoEstudiante.getLast_name(),
                comandoEstudiante.getCedula(),
                comandoEstudiante.getNivel_estudios());
    }
}
