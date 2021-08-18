package com.ceiba.persona.controlador;

import com.ceiba.ComandoRespuesta;
import com.ceiba.persona.comando.PersonaComando;
import com.ceiba.persona.comando.manejador.ActualizarPersonaManejador;
import com.ceiba.persona.comando.manejador.CrearPersonaManejador;
import com.ceiba.persona.comando.manejador.EliminarPersonaManejador;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/personas")
@Api(tags = {"Controlador comando persona"})
public class PersonaComandoControlador {
    private final CrearPersonaManejador crearManejador;
    private final ActualizarPersonaManejador actualizarManejador;
    private final EliminarPersonaManejador eliminarManejador;

    public PersonaComandoControlador(CrearPersonaManejador crearManejador,
                                     ActualizarPersonaManejador actualizarManejador,
                                     EliminarPersonaManejador eliminarManejador) {
        this.crearManejador = crearManejador;
        this.actualizarManejador = actualizarManejador;
        this.eliminarManejador = eliminarManejador;
    }

    @PostMapping
    @ApiOperation("Crear Persona")
    public ComandoRespuesta<Long> crear(@RequestBody PersonaComando personaComando) {
        return crearManejador.ejecutar(personaComando);
    }

    @DeleteMapping(value = "/{id}")
    @ApiOperation("Elimar persona")
    public void eliminar(@PathVariable Long id) {
        eliminarManejador.ejecutar(id);
    }

    @PutMapping(value = "/{id}")
    @ApiOperation("Actualizar Usuario")
    public void actualizar(@RequestBody PersonaComando personaComando, @PathVariable Long id) {
        personaComando.setId(id);
        actualizarManejador.ejecutar(personaComando);
    }
}
