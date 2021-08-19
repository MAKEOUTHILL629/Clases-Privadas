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
    private final ClaseFabrica claseFabrica;
    private final CrearClaseServicio crearClaseServicio;

    public CrearClaseManejador(ClaseFabrica claseFabrica, CrearClaseServicio crearClaseServicio) {
        this.claseFabrica = claseFabrica;
        this.crearClaseServicio = crearClaseServicio;
    }

    @Override
    public ComandoRespuesta<Long> ejecutar(ClaseComando claseComandoCrear) {
        Clase clase = this.claseFabrica.crear(claseComandoCrear);
        return new ComandoRespuesta<>(this.crearClaseServicio.ejecutar(clase));
    }
}
