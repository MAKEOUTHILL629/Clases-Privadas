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
@Api(tags = { "Controlador comando clases"})
public class ComandoClaseControlador {
    private final CrearClaseManejador manejadorCrear;
    private final ActualizarClaseManejador manejadorActualizar;
    private final EliminarClaseManejador manejadorEliminar;

    public ComandoClaseControlador(CrearClaseManejador manejadorCrear, ActualizarClaseManejador manejadorActualizar, EliminarClaseManejador manejadorEliminar) {
        this.manejadorCrear = manejadorCrear;
        this.manejadorActualizar = manejadorActualizar;
        this.manejadorEliminar = manejadorEliminar;
    }

    @PostMapping
    @ApiOperation("Crear clase")
    public ComandoRespuesta<Long> crear(@RequestBody ClaseComando clase){
        return this.manejadorCrear.ejecutar(clase);
    }

    @DeleteMapping(value="/{id}")
    @ApiOperation("Eliminar clase")
    public void eliminar(@PathVariable Long id){
        manejadorEliminar.ejecutar(id);
    }

    @PutMapping(value = "/{id}")
    @ApiOperation("Actualizar clase")
    public void actualizar(@RequestBody ClaseComando claseComando, @PathVariable Long id){
        claseComando.setId(id);
        manejadorActualizar.ejecutar(claseComando);
    }

}
