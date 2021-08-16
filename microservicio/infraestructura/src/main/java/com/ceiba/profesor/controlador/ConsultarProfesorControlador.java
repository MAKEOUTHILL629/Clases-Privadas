package com.ceiba.profesor.controlador;


import com.ceiba.profesor.consulta.ListarProfesoresConsulta;
import com.ceiba.profesor.modelo.dto.ProfesorDTO;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/profesores")
@Api(tags = {"Controlador consulta profesores"})
public class ConsultarProfesorControlador {
    private final ListarProfesoresConsulta consulta;

    public ConsultarProfesorControlador(ListarProfesoresConsulta consulta) {
        this.consulta = consulta;
    }

    @GetMapping
    @ApiOperation("Listar profesores")
    public List<ProfesorDTO> listar(){
        return this.consulta.ejecutar();
    }



}
