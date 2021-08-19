package com.ceiba.clase.comando.manejador;

import com.ceiba.clase.comando.ClaseComando;
import com.ceiba.clase.comando.fabrica.ClaseFabrica;
import com.ceiba.clase.modelo.entidad.Clase;
import com.ceiba.clase.servicio.ActualizarClaseServicio;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

@Component
public class ActualizarClaseManejador {

    private final ClaseFabrica claseFabrica;
    private final ActualizarClaseServicio actualizarClaseServicio;

    public ActualizarClaseManejador(ClaseFabrica claseFabrica, ActualizarClaseServicio actualizarClaseServicio) {
        this.claseFabrica = claseFabrica;
        this.actualizarClaseServicio = actualizarClaseServicio;
    }

    @Transactional
    public void ejecutar(ClaseComando claseComando, Long id) {
        Clase clase = this.claseFabrica.crear(claseComando, id);
        this.actualizarClaseServicio.ejecutar(clase);
    }


}
