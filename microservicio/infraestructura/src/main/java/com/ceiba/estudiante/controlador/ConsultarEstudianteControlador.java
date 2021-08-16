package com.ceiba.estudiante.controlador;

import com.ceiba.estudiante.consulta.ListarEstudiantesConsulta;
import com.ceiba.estudiante.modelo.dto.EstudianteDTO;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/estudiantes")
@Api(tags = {"Controlador consulta estudiantes"})
public class ConsultarEstudianteControlador {
    private final ListarEstudiantesConsulta listarEstudiantesConsulta;

    public ConsultarEstudianteControlador(ListarEstudiantesConsulta listarEstudiantesConsulta) {
        this.listarEstudiantesConsulta = listarEstudiantesConsulta;
    }


    @GetMapping
    @ApiOperation("Listar estudiantes")
    public List<EstudianteDTO> listar(){
        return this.listarEstudiantesConsulta.ejecutar();
    }

    /*@GetMapping("/{id}")
    public EstudianteDTO obtener(@PathVariable Long id){


    }*/

}
