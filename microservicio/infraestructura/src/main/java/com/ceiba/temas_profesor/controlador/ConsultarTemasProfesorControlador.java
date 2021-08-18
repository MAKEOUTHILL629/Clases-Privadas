package com.ceiba.temas_profesor.controlador;

import com.ceiba.temas_profesor.consulta.ListarTemasProfesorConsulta;
import com.ceiba.temas_profesor.consulta.ObtenerTemasProfesorManejadorConsulta;
import com.ceiba.temas_profesor.modelo.dto.TemasProfesorDTO;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/temas-profesor")
@Api(tags = {"Controlador consulta temas"})
public class ConsultarTemasProfesorControlador {
    private final ListarTemasProfesorConsulta consulta;
    private final ObtenerTemasProfesorManejadorConsulta obtenerTemasProfesorConsulta;

    public ConsultarTemasProfesorControlador(ListarTemasProfesorConsulta consulta, ObtenerTemasProfesorManejadorConsulta obtenerTemasProfesorConsulta) {
        this.consulta = consulta;
        this.obtenerTemasProfesorConsulta = obtenerTemasProfesorConsulta;
    }

    @GetMapping
    @ApiOperation("Listar temas")
    public List<TemasProfesorDTO> listar() {
        return this.consulta.ejecutar();
    }

    @GetMapping("/{id}")
    @ApiOperation("Listar temas de un profesor")
    public List<TemasProfesorDTO> obtener(@PathVariable Long id) {
        return this.obtenerTemasProfesorConsulta.ejecutar(id);
    }

}
