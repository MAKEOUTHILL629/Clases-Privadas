package com.ceiba.clase.comando.manejador;

import com.ceiba.clase.comando.ClaseComando;
import com.ceiba.clase.comando.fabrica.ClaseFabrica;
import com.ceiba.clase.modelo.entidad.Clase;
import com.ceiba.clase.servicio.ActualizarClaseServicio;
import com.ceiba.manejador.ManejadorComando;
import org.springframework.stereotype.Component;

@Component
public class ActualizarClaseManejador implements ManejadorComando<ClaseComando> {

    private final ClaseFabrica fabrica;
    private final ActualizarClaseServicio servicio;

    public ActualizarClaseManejador(ClaseFabrica fabrica, ActualizarClaseServicio servicio) {
        this.fabrica = fabrica;
        this.servicio = servicio;
    }

    @Override
    public void ejecutar(ClaseComando comando) {
        Clase clase = this.fabrica.crear(comando);
        this.servicio.ejecutar(clase);
    }
}
