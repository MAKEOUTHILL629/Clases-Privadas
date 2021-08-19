package com.ceiba.profesor.controlador;

import com.ceiba.ComandoRespuesta;
import com.ceiba.profesor.comando.comando.ProfesorComandoActualizar;
import com.ceiba.profesor.comando.comando.ProfesorComandoCrear;
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
    private final CrearProfesorManejador crearProfesorManejador;
    private final ActualizarProfesorManejador actualizarProfesorManejador;
    private final EliminarProfesorManejador eliminarProfesorManejador;

    public ComandoProfesorControlador(CrearProfesorManejador crearProfesorManejador, ActualizarProfesorManejador actualizarProfesorManejador, EliminarProfesorManejador eliminarProfesorManejador) {
        this.crearProfesorManejador = crearProfesorManejador;
        this.actualizarProfesorManejador = actualizarProfesorManejador;
        this.eliminarProfesorManejador = eliminarProfesorManejador;
    }

    @PostMapping
    @ApiOperation("Crear profesor")
    public ComandoRespuesta<Long> crear(@RequestBody ProfesorComandoCrear profesorComandoCrear) {
        return crearProfesorManejador.ejecutar(profesorComandoCrear);
    }

    @DeleteMapping(value = "/{id}")
    @ApiOperation("Eliminar profesor")
    public void eliminar(@PathVariable Long id) {
        eliminarProfesorManejador.ejecutar(id);
    }

    @PutMapping(value = "/{id}")
    @ApiOperation("Actualizar profesor")
    public void actualizar(@RequestBody ProfesorComandoActualizar profesorComandoActualizar, @PathVariable Long id) {
        actualizarProfesorManejador.ejecutar(profesorComandoActualizar, id);
    }

}
