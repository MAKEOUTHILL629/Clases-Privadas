package com.ceiba.temas_profesor.controlador;

import com.ceiba.ComandoRespuesta;
import com.ceiba.temas_profesor.comando.TemasProfesorComando;
import com.ceiba.temas_profesor.comando.manejador.ActualizarTemasProfesorManejador;
import com.ceiba.temas_profesor.comando.manejador.CrearTemasProfesorManejador;
import com.ceiba.temas_profesor.comando.manejador.EliminarTemasProfesorManejador;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/temas-profesor")
@Api(tags = { "Controlador comando temas profesor"})
public class ComandoTemasProfesorControlador {
    private final CrearTemasProfesorManejador crearManejador;
    private final ActualizarTemasProfesorManejador actualizarManejador;
    private final EliminarTemasProfesorManejador eliminarManejador;

    public ComandoTemasProfesorControlador(CrearTemasProfesorManejador crearManejador, ActualizarTemasProfesorManejador actualizarManejador, EliminarTemasProfesorManejador eliminarManejador) {
        this.crearManejador = crearManejador;
        this.actualizarManejador = actualizarManejador;
        this.eliminarManejador = eliminarManejador;
    }
    @PostMapping
    @ApiOperation("Crear tema profesor")
    public ComandoRespuesta<Long> crear(@RequestBody TemasProfesorComando comando){
        return crearManejador.ejecutar(comando);
    }

    @DeleteMapping(value="/{id}")
    @ApiOperation("Eliminar tema profesor")
    public void eliminar(@PathVariable Long id){
        eliminarManejador.ejecutar(id);
    }

    @PutMapping(value="/{id}")
    @ApiOperation("Actualizar tema profesor")
    public void actualizar(@RequestBody TemasProfesorComando comando, @PathVariable Long id ){
        comando.setId(id);
        actualizarManejador.ejecutar(comando);
    }

}
