package com.ceiba.temas_profesor.comando.fabrica;

import com.ceiba.profesor.modelo.entidad.Profesor;
import com.ceiba.temas_profesor.comando.TemasProfesorComando;
import com.ceiba.temas_profesor.modelo.entidad.TemasProfesor;
import org.springframework.stereotype.Component;

@Component
public class TemasProfesorFabrica {
    public TemasProfesor crear(TemasProfesorComando comando) {
        return new TemasProfesor(
                comando.getId(),
                new Profesor(comando.getIdProfesor()),
                comando.getTema());
    }
}
