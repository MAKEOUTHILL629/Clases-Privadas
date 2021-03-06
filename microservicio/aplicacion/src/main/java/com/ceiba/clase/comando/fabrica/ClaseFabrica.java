package com.ceiba.clase.comando.fabrica;

import com.ceiba.clase.comando.ClaseComando;
import com.ceiba.clase.modelo.entidad.Clase;
import com.ceiba.estudiante.modelo.entidad.Estudiante;
import com.ceiba.profesor.modelo.entidad.Profesor;
import org.springframework.stereotype.Component;

@Component
public class ClaseFabrica {
    public Clase crear(ClaseComando claseComando, Long id) {

        Clase clase = this.crear(claseComando);

        clase.setId(id);

        return clase;
    }

    public Clase crear(ClaseComando claseComando) {
        return new Clase(
                new Estudiante(claseComando.getIdEstudiante()),
                new Profesor(claseComando.getIdProfesor()),
                claseComando.getFecha());
    }
}
