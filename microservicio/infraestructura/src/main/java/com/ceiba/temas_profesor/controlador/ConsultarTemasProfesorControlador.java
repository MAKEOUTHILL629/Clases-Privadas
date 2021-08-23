package com.ceiba.temas_profesor.controlador;

import com.ceiba.temas_profesor.consulta.ListarTemasProfesorManejadorConsulta;
import com.ceiba.temas_profesor.consulta.ObtenerTemasProfesorManejadorConsulta;
import com.ceiba.temas_profesor.modelo.dto.TemasProfesorDTO;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/temas-profesor")
@Api(tags = {"Controlador consulta temas"})
public class ConsultarTemasProfesorControlador {
    private final ListarTemasProfesorManejadorConsulta listarTemasProfesorManejadorConsulta;
    private final ObtenerTemasProfesorManejadorConsulta obtenerTemasProfesorConsulta;

    public ConsultarTemasProfesorControlador(ListarTemasProfesorManejadorConsulta listarTemasProfesorManejadorConsulta, ObtenerTemasProfesorManejadorConsulta obtenerTemasProfesorConsulta) {
        this.listarTemasProfesorManejadorConsulta = listarTemasProfesorManejadorConsulta;
        this.obtenerTemasProfesorConsulta = obtenerTemasProfesorConsulta;
    }

    @GetMapping
    @ApiOperation("Listar temas")
    public List<TemasProfesorDTO> listar() {
        return this.listarTemasProfesorManejadorConsulta.ejecutar();
    }

    @GetMapping("/{id}")
    @ApiOperation("Listar temas de un profesor")
    public List<TemasProfesorDTO> obtener(@PathVariable Long id) {
        return this.obtenerTemasProfesorConsulta.ejecutar(id);
    }

}
