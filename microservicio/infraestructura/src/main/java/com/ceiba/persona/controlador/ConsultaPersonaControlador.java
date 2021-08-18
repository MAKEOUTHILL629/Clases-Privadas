package com.ceiba.persona.controlador;

import com.ceiba.persona.consulta.ListarPersonasConsulta;
import com.ceiba.persona.consulta.ObtenerPersonaConsulta;
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
@Api(tags = {"Controlador consulta usuario"})
public class ConsultaPersonaControlador {
    private final ListarPersonasConsulta listarPersonas;
    private final ObtenerPersonaConsulta obtenerPersonaConsulta;

    public ConsultaPersonaControlador(ListarPersonasConsulta listarPersonas, ObtenerPersonaConsulta obtenerPersonaConsulta) {
        this.listarPersonas = listarPersonas;
        this.obtenerPersonaConsulta = obtenerPersonaConsulta;
    }

    @GetMapping
    @ApiOperation("Listar Personas")
    public List<PersonaDTO> listar() {
        return this.listarPersonas.ejecutar();
    }


    @GetMapping("/{id}")
    @ApiOperation("Devuelve la persona solicitado")
    public PersonaDTO obtener(@PathVariable Long id) {
        return this.obtenerPersonaConsulta.ejecutar(id);
    }


}
