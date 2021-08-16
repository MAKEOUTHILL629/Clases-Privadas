package com.ceiba.clase.comando.manejador;

import com.ceiba.ComandoRespuesta;
import com.ceiba.clase.comando.ClaseComando;
import com.ceiba.clase.comando.fabrica.ClaseFabrica;
import com.ceiba.clase.modelo.entidad.Clase;
import com.ceiba.clase.servicio.CrearClaseServicio;
import com.ceiba.manejador.ManejadorComandoRespuesta;
import org.springframework.stereotype.Component;

@Component
public class CrearClaseManejador implements ManejadorComandoRespuesta<ClaseComando, ComandoRespuesta<Long>> {
    private final ClaseFabrica fabrica;
    private final CrearClaseServicio servicio;

    public CrearClaseManejador(ClaseFabrica fabrica, CrearClaseServicio servicio) {
        this.fabrica = fabrica;
        this.servicio = servicio;
    }

    @Override
    public ComandoRespuesta<Long> ejecutar(ClaseComando comando) {
        Clase clase = this.fabrica.crear(comando);
        return new ComandoRespuesta<>(this.servicio.ejecutar(clase));
    }
}
