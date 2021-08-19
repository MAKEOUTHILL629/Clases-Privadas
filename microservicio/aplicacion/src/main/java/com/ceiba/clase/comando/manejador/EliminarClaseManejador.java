package com.ceiba.clase.comando.manejador;

import com.ceiba.clase.servicio.EliminarClaseServicio;
import com.ceiba.manejador.ManejadorComando;
import org.springframework.stereotype.Component;

@Component
public class EliminarClaseManejador implements ManejadorComando<Long> {
    private final EliminarClaseServicio eliminarClaseServicio;

    public EliminarClaseManejador(EliminarClaseServicio eliminarClaseServicio) {
        this.eliminarClaseServicio = eliminarClaseServicio;
    }

    @Override
    public void ejecutar(Long id) {
        this.eliminarClaseServicio.ejecutar(id);
    }
}
