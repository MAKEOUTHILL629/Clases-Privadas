package com.ceiba.clase.comando.manejador;

import com.ceiba.clase.comando.comando.ClaseComandoActualizar;
import com.ceiba.clase.comando.fabrica.ClaseFabrica;
import com.ceiba.clase.modelo.entidad.Clase;
import com.ceiba.clase.servicio.ActualizarClaseServicio;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

@Component
public class ActualizarClaseManejador  {

    private final ClaseFabrica claseFabrica;
    private final ActualizarClaseServicio actualizarClaseServicio;

    public ActualizarClaseManejador(ClaseFabrica fabrica, ActualizarClaseServicio servicio) {
        this.claseFabrica = fabrica;
        this.actualizarClaseServicio = servicio;
    }

    @Transactional
    public void ejecutar(ClaseComandoActualizar comando,Long id) {
        Clase clase = this.claseFabrica.crear(comando, id);
        this.actualizarClaseServicio.ejecutar(clase);
    }


}
