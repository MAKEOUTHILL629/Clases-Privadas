package com.ceiba.temas_profesor.controlador;

import com.ceiba.temas_profesor.consulta.ListarTemasProfesorConsulta;
import com.ceiba.temas_profesor.modelo.dto.TemasProfesorDTO;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/temas")
@Api(tags = {"Controlador consulta temas"})
public class ConsultarTemasProfesorControlador {
    private final ListarTemasProfesorConsulta consulta;

    public ConsultarTemasProfesorControlador(ListarTemasProfesorConsulta consulta) {
        this.consulta = consulta;
    }


    @GetMapping
    @ApiOperation("Listar temas")
    public List<TemasProfesorDTO> listar(){
        return this.consulta.ejecutar();
    }

}
