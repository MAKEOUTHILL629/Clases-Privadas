package com.ceiba.clase.comando.manejador;

import com.ceiba.clase.servicio.EliminarClaseServicio;
import com.ceiba.manejador.ManejadorComando;
import org.springframework.stereotype.Component;

@Component
public class EliminarClaseManejador implements ManejadorComando<Long> {
    private final EliminarClaseServicio servicio;

    public EliminarClaseManejador(EliminarClaseServicio servicio) {
        this.servicio = servicio;
    }

    @Override
    public void ejecutar(Long comando) {
        this.servicio.ejecutar(comando);
    }
}
