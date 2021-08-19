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
@Api(tags = {"Controlador comando horarios profesor"})
public class ComandoHorariosProfesorControlador {
    private final CrearHorariosProfesorManejador crearHorariosProfesorManejador;
    private final ActualizarHorariosProfesorManejador actualizarHorariosProfesorManejador;
    private final EliminarHorariosProfesorManejador eliminarHorariosProfesorManejador;

    public ComandoHorariosProfesorControlador(CrearHorariosProfesorManejador crearHorariosProfesorManejador, ActualizarHorariosProfesorManejador actualizarHorariosProfesorManejador, EliminarHorariosProfesorManejador eliminarManejador) {
        this.crearHorariosProfesorManejador = crearHorariosProfesorManejador;
        this.actualizarHorariosProfesorManejador = actualizarHorariosProfesorManejador;
        this.eliminarHorariosProfesorManejador = eliminarManejador;
    }

    @PostMapping
    @ApiOperation("Crear horario profesor")
    public ComandoRespuesta<Long> crear(@RequestBody HorariosProfesorComando comando) {
        return crearHorariosProfesorManejador.ejecutar(comando);
    }

    @DeleteMapping(value = "/{id}")
    @ApiOperation("Eliminar horario profesor")
    public void eliminar(@PathVariable Long id) {
        eliminarHorariosProfesorManejador.ejecutar(id);
    }

    @PutMapping(value = "/{id}")
    @ApiOperation("Actualizar horario profesor")
    public void actualizar(@RequestBody HorariosProfesorComando comando, @PathVariable Long id) {

        actualizarHorariosProfesorManejador.ejecutar(comando, id);
    }
}
