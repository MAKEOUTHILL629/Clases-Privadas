package com.ceiba.horarios_profesor.comando.manejador;

import com.ceiba.manejador.ManejadorComando;
import com.ceiba.temas_profesor.servicio.EliminarTemaProfesorService;
import org.springframework.stereotype.Component;

@Component
public class EliminarHorariosProfesorManejador implements ManejadorComando<Long> {
    private final EliminarTemaProfesorService service;

    public EliminarHorariosProfesorManejador(EliminarTemaProfesorService service) {
        this.service = service;
    }

    @Override
    public void ejecutar(Long comando) {
        service.ejecutar(comando);
    }
}
