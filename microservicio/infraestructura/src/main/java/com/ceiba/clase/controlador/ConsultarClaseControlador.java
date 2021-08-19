package com.ceiba.clase.controlador;

import com.ceiba.clase.consulta.ListarClaseManejadorConsulta;
import com.ceiba.clase.consulta.ObtenerClaseManejadorConsulta;
import com.ceiba.clase.modelo.dto.ClaseDTO;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/clases")
@Api(tags = {"Controlador consulta clases"})
public class ConsultarClaseControlador {
    private final ListarClaseManejadorConsulta listarClaseManejadorConsulta;
    private final ObtenerClaseManejadorConsulta obtenerClaseManejadorConsulta;

    public ConsultarClaseControlador(ListarClaseManejadorConsulta listarClaseManejadorConsulta, ObtenerClaseManejadorConsulta obtenerClaseManejadorConsulta) {
        this.listarClaseManejadorConsulta = listarClaseManejadorConsulta;
        this.obtenerClaseManejadorConsulta = obtenerClaseManejadorConsulta;
    }

    @GetMapping
    @ApiOperation("Listar clases")
    public List<ClaseDTO> listar() {
        return this.listarClaseManejadorConsulta.ejecutar();
    }

    @GetMapping("/{id}")
    @ApiOperation("Obtiene una clase")
    public ClaseDTO obtener(@PathVariable Long id) {
        return this.obtenerClaseManejadorConsulta.ejecutar(id);
    }

}
