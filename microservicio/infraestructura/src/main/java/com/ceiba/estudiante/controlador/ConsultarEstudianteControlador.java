package com.ceiba.estudiante.controlador;

import com.ceiba.estudiante.consulta.ListarEstudiantesConsulta;
import com.ceiba.estudiante.consulta.ObtenerEstudianteConsulta;
import com.ceiba.estudiante.modelo.dto.EstudianteDTO;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/estudiantes")
@Api(tags = {"Controlador consulta estudiantes"})
public class ConsultarEstudianteControlador {
    private final ListarEstudiantesConsulta listarEstudiantesConsulta;
    private final ObtenerEstudianteConsulta obtenerEstudianteConsulta;

    public ConsultarEstudianteControlador(ListarEstudiantesConsulta listarEstudiantesConsulta, ObtenerEstudianteConsulta obtenerEstudianteConsulta) {
        this.listarEstudiantesConsulta = listarEstudiantesConsulta;
        this.obtenerEstudianteConsulta = obtenerEstudianteConsulta;
    }

    @GetMapping
    @ApiOperation("Listar estudiantes")
    public List<EstudianteDTO> listar(){
        return this.listarEstudiantesConsulta.ejecutar();
    }

    @GetMapping("/{id}")
    @ApiOperation("obtine un estudiante en especifico")
    public EstudianteDTO obtener(@PathVariable Long id){
        return this.obtenerEstudianteConsulta.ejecutar(id);
    }

}
