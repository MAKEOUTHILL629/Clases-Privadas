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
    private final CrearPersonaManejador crearPersonaManejador;
    private final ActualizarPersonaManejador actualizarPersonaManejador;
    private final EliminarPersonaManejador eliminarPersonaManejador;

    public PersonaComandoControlador(CrearPersonaManejador crearPersonaManejador,
                                     ActualizarPersonaManejador actualizarPersonaManejador,
                                     EliminarPersonaManejador eliminarPersonaManejador) {
        this.crearPersonaManejador = crearPersonaManejador;
        this.actualizarPersonaManejador = actualizarPersonaManejador;
        this.eliminarPersonaManejador = eliminarPersonaManejador;
    }

    @PostMapping
    @ApiOperation("Crear Persona")
    public ComandoRespuesta<Long> crear(@RequestBody PersonaComando personaComando) {
        return crearPersonaManejador.ejecutar(personaComando);
    }

    @DeleteMapping(value = "/{id}")
    @ApiOperation("Elimar persona")
    public void eliminar(@PathVariable Long id) {
        eliminarPersonaManejador.ejecutar(id);
    }

    @PutMapping(value = "/{id}")
    @ApiOperation("Actualizar Usuario")
    public void actualizar(@RequestBody PersonaComando personaComando, @PathVariable Long id) {

        actualizarPersonaManejador.ejecutar(personaComando, id);
    }
}
