package com.ceiba.profesor.controlador;

import com.ceiba.ComandoRespuesta;
import com.ceiba.profesor.comando.ProfesorComando;
import com.ceiba.profesor.comando.manejador.ActualizarProfesorManejador;
import com.ceiba.profesor.comando.manejador.CrearProfesorManejador;
import com.ceiba.profesor.comando.manejador.EliminarProfesorManejador;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/profesor")
@Api(tags = {"Controlador comando profesor"})
public class ComandoProfesorControlador {
    private final CrearProfesorManejador crearManejador;
    private final ActualizarProfesorManejador actualizarManejador;
    private final EliminarProfesorManejador eliminarManejador;

    public ComandoProfesorControlador(CrearProfesorManejador crearManejador, ActualizarProfesorManejador actualizarManejador, EliminarProfesorManejador eliminarManejador) {
        this.crearManejador = crearManejador;
        this.actualizarManejador = actualizarManejador;
        this.eliminarManejador = eliminarManejador;
    }

    @PostMapping
    @ApiOperation("Crear profesor")
    public ComandoRespuesta<Long> crear(@RequestBody ProfesorComando comando) {
        return crearManejador.ejecutar(comando);
    }

    @DeleteMapping(value = "/{id}")
    @ApiOperation("Eliminar profesor")
    public void eliminar(@PathVariable Long id) {
        eliminarManejador.ejecutar(id);
    }

    @PutMapping(value = "/{id}")
    @ApiOperation("Actualizar profesor")
    public void actualizar(@RequestBody ProfesorComando comando, @PathVariable Long id) {
        comando.setId(id);
        actualizarManejador.ejecutar(comando);
    }

}
