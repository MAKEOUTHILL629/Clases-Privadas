package com.ceiba.clase.controlador;

import com.ceiba.clase.consulta.ListarClaseConsulta;
import com.ceiba.clase.consulta.ObtenerClaseConsulta;
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
    private final ListarClaseConsulta consulta;
    private final ObtenerClaseConsulta obtenerConsulta;

    public ConsultarClaseControlador(ListarClaseConsulta consulta, ObtenerClaseConsulta obtenerConsulta) {
        this.consulta = consulta;
        this.obtenerConsulta = obtenerConsulta;
    }

    @GetMapping
    @ApiOperation("Listar clases")
    public List<ClaseDTO> listar() {
        return this.consulta.ejecutar();
    }

    @GetMapping("/{id}")
    @ApiOperation("Obtiene una clase")
    public ClaseDTO obtener(@PathVariable Long id) {
        return this.obtenerConsulta.ejecutar(id);
    }

}
