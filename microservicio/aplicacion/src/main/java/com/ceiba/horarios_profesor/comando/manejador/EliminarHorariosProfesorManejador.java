package com.ceiba.horarios_profesor.comando.manejador;

import com.ceiba.horarios_profesor.servicio.EliminarHorarioProfesorService;
import com.ceiba.manejador.ManejadorComando;
import com.ceiba.temas_profesor.servicio.EliminarTemaProfesorService;
import org.springframework.stereotype.Component;

@Component
public class EliminarHorariosProfesorManejador implements ManejadorComando<Long> {
    private final EliminarHorarioProfesorService eliminarHorarioProfesorService;

    public EliminarHorariosProfesorManejador(EliminarHorarioProfesorService eliminarHorarioProfesorService) {
        this.eliminarHorarioProfesorService = eliminarHorarioProfesorService;
    }

    @Override
    public void ejecutar(Long id) {
        eliminarHorarioProfesorService.ejecutar(id);
    }
}
