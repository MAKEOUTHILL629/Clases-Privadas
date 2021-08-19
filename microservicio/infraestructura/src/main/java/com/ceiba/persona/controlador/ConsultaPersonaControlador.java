package com.ceiba.persona.controlador;

import com.ceiba.persona.consulta.ListarPersonasManejadorConsulta;
import com.ceiba.persona.consulta.ObtenerPersonaManejadorConsulta;
import com.ceiba.persona.modelo.dto.PersonaDTO;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/personas")
@Api(tags = {"Controlador consulta persona"})
public class ConsultaPersonaControlador {
    private final ListarPersonasManejadorConsulta listarPersonasManejadorConsulta;
    private final ObtenerPersonaManejadorConsulta obtenerPersonaManejadorConsulta;

    public ConsultaPersonaControlador(ListarPersonasManejadorConsulta listarPersonasManejadorConsulta, ObtenerPersonaManejadorConsulta obtenerPersonaManejadorConsulta) {
        this.listarPersonasManejadorConsulta = listarPersonasManejadorConsulta;
        this.obtenerPersonaManejadorConsulta = obtenerPersonaManejadorConsulta;
    }

    @GetMapping
    @ApiOperation("Listar Personas")
    public List<PersonaDTO> listar() {
        return this.listarPersonasManejadorConsulta.ejecutar();
    }


    @GetMapping("/{id}")
    @ApiOperation("Devuelve la persona solicitado")
    public PersonaDTO obtener(@PathVariable Long id) {
        return this.obtenerPersonaManejadorConsulta.ejecutar(id);
    }


}
