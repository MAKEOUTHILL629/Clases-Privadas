package com.ceiba.horarios_profesor.controlador;

import com.ceiba.ComandoRespuesta;
import com.ceiba.horarios_profesor.comando.HorariosProfesorComando;
import com.ceiba.horarios_profesor.comando.manejador.ActualizarHorariosProfesorManejador;
import com.ceiba.horarios_profesor.comando.manejador.CrearHorariosProfesorManejador;
import com.ceiba.horarios_profesor.comando.manejador.EliminarHorariosProfesorManejador;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/horarios")
@Api(tags = { "Controlador comando horarios profesor"})
public class ComandoHorariosProfesorControlador {
    private final CrearHorariosProfesorManejador crearManejador;
    private final ActualizarHorariosProfesorManejador actualizarManejador;
    private final EliminarHorariosProfesorManejador eliminarManejador;

    public ComandoHorariosProfesorControlador(CrearHorariosProfesorManejador crearManejador, ActualizarHorariosProfesorManejador actualizarManejador, EliminarHorariosProfesorManejador eliminarManejador) {
        this.crearManejador = crearManejador;
        this.actualizarManejador = actualizarManejador;
        this.eliminarManejador = eliminarManejador;
    }

    @PostMapping
    @ApiOperation("Crear horario profesor")
    public ComandoRespuesta<Long> crear(@RequestBody HorariosProfesorComando comando){
        return crearManejador.ejecutar(comando);
    }

    @DeleteMapping(value="/{id}")
    @ApiOperation("Eliminar horario profesor")
    public void eliminar(@PathVariable Long id){
        eliminarManejador.ejecutar(id);
    }

    @PutMapping(value="/{id}")
    @ApiOperation("Actualizar horario profesor")
    public void actualizar(@RequestBody HorariosProfesorComando comando, @PathVariable Long id){
        comando.setId(id);
        actualizarManejador.ejecutar(comando);
    }
}
