package com.ceiba.estudiante.comando.fabrica;

import com.ceiba.estudiante.comando.comando.EstudianteComandActualizar;
import com.ceiba.estudiante.comando.comando.EstudianteComandoCrear;
import com.ceiba.estudiante.modelo.entidad.Estudiante;
import com.ceiba.persona.modelo.entidad.Persona;
import org.springframework.stereotype.Component;

@Component
public class EstudianteFabrica {

    public Estudiante crear(EstudianteComandoCrear estudianteComandoCrear) {
        return new Estudiante(
                new Persona(estudianteComandoCrear.getIdPersona()),
                estudianteComandoCrear.getNivelEstudios()
        );
    }

    public Estudiante crear(EstudianteComandActualizar estudianteComandActualizar, Long id) {
        Estudiante estudiante = new Estudiante(estudianteComandActualizar.getNivelEstudios());
        estudiante.setId(id);
        return estudiante;
    }


}
