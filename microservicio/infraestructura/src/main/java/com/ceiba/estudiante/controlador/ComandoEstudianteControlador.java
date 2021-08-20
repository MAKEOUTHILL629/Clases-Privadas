package com.ceiba.estudiante.controlador;

import com.ceiba.ComandoRespuesta;
import com.ceiba.estudiante.comando.comando.EstudianteComandActualizar;
import com.ceiba.estudiante.comando.comando.EstudianteComandoCrear;
import com.ceiba.estudiante.comando.manejador.ActualizarEstudianteManejador;
import com.ceiba.estudiante.comando.manejador.CrearEstudianteManejador;
import com.ceiba.estudiante.comando.manejador.EliminarEstudiantesManejador;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/estudiante")
@Api(tags = {"Controlador comando estudiante"})
public class ComandoEstudianteControlador {
    private final CrearEstudianteManejador crearEstudianteManejador;
    private final ActualizarEstudianteManejador actualizarEstudianteManejador;
    private final EliminarEstudiantesManejador eliminarEstudiantesManejador;

    public ComandoEstudianteControlador(CrearEstudianteManejador crearEstudianteManejador, ActualizarEstudianteManejador actualizarManejador, EliminarEstudiantesManejador eliminarManejador) {
        this.crearEstudianteManejador = crearEstudianteManejador;
        this.actualizarEstudianteManejador = actualizarManejador;
        this.eliminarEstudiantesManejador = eliminarManejador;
    }

    @PostMapping
    @ApiOperation("Crear Estudiante")
    public ComandoRespuesta<Long> crear(@RequestBody EstudianteComandoCrear estudianteComandoCrear) {
        return crearEstudianteManejador.ejecutar(estudianteComandoCrear);
    }

    @DeleteMapping(value = "/{id}")
    @ApiOperation("Eliminar estudiante")
    public void eliminar(@PathVariable Long id) {
        eliminarEstudiantesManejador.ejecutar(id);
    }

    @PutMapping(value = "/{id}")
    @ApiOperation("Actualizar estudiante")
    public void actualizar(@RequestBody EstudianteComandActualizar estudianteComandActualizar, @PathVariable Long id) {
        actualizarEstudianteManejador.ejecutar(estudianteComandActualizar, id);
    }


}
