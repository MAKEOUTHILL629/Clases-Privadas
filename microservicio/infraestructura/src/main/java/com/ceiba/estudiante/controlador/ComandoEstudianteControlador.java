package com.ceiba.estudiante.controlador;

import com.ceiba.ComandoRespuesta;
import com.ceiba.estudiante.comando.EstudianteComando;
import com.ceiba.estudiante.comando.manejador.ActualizarEstudianteManejador;
import com.ceiba.estudiante.comando.manejador.CrearEstudianteManejador;
import com.ceiba.estudiante.comando.manejador.EliminarEstudiantesManejador;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/estudiante")
@Api(tags = { "Controlador comando estudiante"})
public class ComandoEstudianteControlador {
    private final CrearEstudianteManejador crearManejador;
    private final ActualizarEstudianteManejador actualizarManejador;
    private final EliminarEstudiantesManejador eliminarManejador;

    public ComandoEstudianteControlador(CrearEstudianteManejador crearManejador, ActualizarEstudianteManejador actualizarManejador, EliminarEstudiantesManejador eliminarManejador) {
        this.crearManejador = crearManejador;
        this.actualizarManejador = actualizarManejador;
        this.eliminarManejador = eliminarManejador;
    }

    @PostMapping
    @ApiOperation("Crear Estudiante")
    public ComandoRespuesta<Long> crear(@RequestBody EstudianteComando comando){
        return crearManejador.ejecutar(comando);
    }

    @DeleteMapping(value="/{id}")
    @ApiOperation("Eliminar estudiante")
    public void eliminar(@PathVariable Long id){
        eliminarManejador.ejecutar(id);
    }

    @PutMapping(value="/{id}")
    @ApiOperation("Actualizar estudiante")
    public void actualizar(@RequestBody EstudianteComando comando, @PathVariable Long id){
        comando.setId(id);
        actualizarManejador.ejecutar(comando);
    }


}
