package com.ceiba.estudiante.comando.fabrica;

import com.ceiba.estudiante.comando.EstudianteComando;
import com.ceiba.estudiante.modelo.clasificacion.NivelEstudios;
import com.ceiba.estudiante.modelo.clasificacion.ObtenerNivelEstudios;
import com.ceiba.estudiante.modelo.entidad.Estudiante;
import com.ceiba.persona.modelo.entidad.Persona;
import org.springframework.stereotype.Component;

@Component
public class EstudianteFabrica {

    public Estudiante crear(EstudianteComando comandoEstudiante) {
        return new Estudiante(
                comandoEstudiante.getId(),
                new Persona(comandoEstudiante.getIdPersona()),
                ObtenerNivelEstudios.obtenerNivelEstudios(comandoEstudiante.getNivelEstudios())
        );
    }


}
