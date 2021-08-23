package com.ceiba.profesor.controlador;


import com.ceiba.profesor.consulta.ListarProfesoresManejadorConsulta;
import com.ceiba.profesor.consulta.ObtenerProfesorManejadorConsulta;
import com.ceiba.profesor.modelo.dto.ProfesorDTO;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/profesores")
@Api(tags = {"Controlador consulta profesores"})
public class ConsultarProfesorControlador {
    private final ListarProfesoresManejadorConsulta listarProfesoresManejadorConsulta;
    private final ObtenerProfesorManejadorConsulta obtenerProfesorManejadorConsulta;

    public ConsultarProfesorControlador(ListarProfesoresManejadorConsulta listarProfesoresManejadorConsulta, ObtenerProfesorManejadorConsulta obtenerProfesorManejadorConsulta) {
        this.listarProfesoresManejadorConsulta = listarProfesoresManejadorConsulta;
        this.obtenerProfesorManejadorConsulta = obtenerProfesorManejadorConsulta;
    }

    @GetMapping
    @ApiOperation("Listar profesores")
    public List<ProfesorDTO> listar() {
        return this.listarProfesoresManejadorConsulta.ejecutar();
    }

    @GetMapping("/{id}")
    @ApiOperation("obtine un profesor en especifico")
    public ProfesorDTO obtener(@PathVariable Long id) {
        return this.obtenerProfesorManejadorConsulta.ejecutar(id);
    }

}
