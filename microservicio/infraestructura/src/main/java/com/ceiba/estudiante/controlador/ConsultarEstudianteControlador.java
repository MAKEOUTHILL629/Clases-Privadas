package com.ceiba.estudiante.controlador;

import com.ceiba.estudiante.consulta.ListarEstudiantesManejadorConsulta;
import com.ceiba.estudiante.consulta.ObtenerEstudianteManejadorConsulta;
import com.ceiba.estudiante.modelo.dto.EstudianteDTO;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/estudiantes")
@Api(tags = {"Controlador consulta estudiantes"})
public class ConsultarEstudianteControlador {
    private final ListarEstudiantesManejadorConsulta listarEstudiantesManejadorConsulta;
    private final ObtenerEstudianteManejadorConsulta obtenerEstudianteManejadorConsulta;

    public ConsultarEstudianteControlador(ListarEstudiantesManejadorConsulta listarEstudiantesManejadorConsulta, ObtenerEstudianteManejadorConsulta obtenerEstudianteManejadorConsulta) {
        this.listarEstudiantesManejadorConsulta = listarEstudiantesManejadorConsulta;
        this.obtenerEstudianteManejadorConsulta = obtenerEstudianteManejadorConsulta;
    }

    @GetMapping
    @CrossOrigin(origins = "http://localhost:4200")
    @ApiOperation("Listar estudiantes")
    public List<EstudianteDTO> listar() {
        return this.listarEstudiantesManejadorConsulta.ejecutar();
    }

    @GetMapping("/{id}")
    @CrossOrigin(origins = "http://localhost:4200")
    @ApiOperation("Obtener un estudiante en especifico")
    public EstudianteDTO obtener(@PathVariable Long id) {
        return this.obtenerEstudianteManejadorConsulta.ejecutar(id);
    }

}
