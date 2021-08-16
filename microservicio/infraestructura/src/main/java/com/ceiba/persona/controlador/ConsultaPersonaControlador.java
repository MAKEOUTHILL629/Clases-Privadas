package com.ceiba.persona.controlador;

import com.ceiba.persona.consulta.ListarPersonasConsulta;
import com.ceiba.persona.modelo.dto.PersonaDTO;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/personas")
@Api(tags = {"Controlador consulta usuario"})
public class ConsultaPersonaControlador {
    private final ListarPersonasConsulta listarPersonas;


    public ConsultaPersonaControlador(ListarPersonasConsulta listarPersonas) {
        this.listarPersonas = listarPersonas;
    }

    @GetMapping
    @ApiOperation("Listar Personas")
    public List<PersonaDTO> listar(){
        return this.listarPersonas.ejecutar();
    }


}
