package com.ceiba.clase.comando.fabrica;

import com.ceiba.clase.comando.comando.ClaseComandoActualizar;
import com.ceiba.clase.comando.comando.ClaseComandoCrear;
import com.ceiba.clase.modelo.entidad.Clase;
import com.ceiba.estudiante.modelo.entidad.Estudiante;
import com.ceiba.profesor.modelo.entidad.Profesor;
import org.springframework.stereotype.Component;

@Component
public class ClaseFabrica {
    public Clase crear(ClaseComandoActualizar claseComandoActualizar, Long id) {

        Clase clase = new Clase(
                new Estudiante(claseComandoActualizar.getIdEstudiante()),
                new Profesor(claseComandoActualizar.getIdProfesor()),
                claseComandoActualizar.getFecha()
        );

        clase.setId(id);

        return clase;
    }

    public Clase crear(ClaseComandoCrear claseComandoCrear) {
        return new Clase(
                new Estudiante(claseComandoCrear.getIdEstudiante()),
                new Profesor(claseComandoCrear.getIdEstudiante()),
                claseComandoCrear.getFecha());
    }
}
