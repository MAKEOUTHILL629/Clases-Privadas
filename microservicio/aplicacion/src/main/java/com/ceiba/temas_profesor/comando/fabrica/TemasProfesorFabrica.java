package com.ceiba.temas_profesor.comando.fabrica;

import com.ceiba.profesor.modelo.entidad.Profesor;
import com.ceiba.temas_profesor.comando.TemasProfesorComando;
import com.ceiba.temas_profesor.modelo.entidad.TemasProfesor;
import org.springframework.stereotype.Component;

@Component
public class TemasProfesorFabrica {
    public TemasProfesor crear(TemasProfesorComando temasProfesorComando) {
        return new TemasProfesor(
                new Profesor(temasProfesorComando.getIdProfesor()),
                temasProfesorComando.getTema());
    }


    public TemasProfesor crear(TemasProfesorComando temasProfesorComando, Long id) {
        TemasProfesor temasProfesor = new TemasProfesor(
                new Profesor(temasProfesorComando.getIdProfesor()),
                temasProfesorComando.getTema());

        temasProfesor.setId(id);
        return temasProfesor;
    }
}


