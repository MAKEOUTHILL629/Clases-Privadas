package com.ceiba.clase.controlador;

import com.ceiba.ComandoRespuesta;
import com.ceiba.clase.comando.ClaseComando;
import com.ceiba.clase.comando.manejador.ActualizarClaseManejador;
import com.ceiba.clase.comando.manejador.CrearClaseManejador;
import com.ceiba.clase.comando.manejador.EliminarClaseManejador;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/clase")
@Api(tags = {"Controlador comando clases"})
public class ComandoClaseControlador {
    private final CrearClaseManejador crearClaseManejador;
    private final ActualizarClaseManejador actualizarClaseManejador;
    private final EliminarClaseManejador eliminarClaseManejador;

    public ComandoClaseControlador(CrearClaseManejador manejadorCrear, ActualizarClaseManejador manejadorActualizar, EliminarClaseManejador eliminarClaseManejador) {
        this.crearClaseManejador = manejadorCrear;
        this.actualizarClaseManejador = manejadorActualizar;
        this.eliminarClaseManejador = eliminarClaseManejador;
    }

    @PostMapping
    @ApiOperation("Crear clase")
    public ComandoRespuesta<Long> crear(@RequestBody ClaseComando claseGuardar) {
        return this.crearClaseManejador.ejecutar(claseGuardar);
    }

    @DeleteMapping(value = "/{id}")
    @ApiOperation("Eliminar clase")
    public void eliminar(@PathVariable Long id) {
        eliminarClaseManejador.ejecutar(id);
    }

    @PutMapping(value = "/{id}")
    @ApiOperation("Actualizar clase")
    public void actualizar(@RequestBody ClaseComando claseComandoActualizar, @PathVariable Long id) {

        actualizarClaseManejador.ejecutar(claseComandoActualizar, id);
    }

}
