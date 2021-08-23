package com.ceiba.horarios_profesor.controlador;

import com.ceiba.horarios_profesor.consulta.ListarHorariosProfesorManejadorConsulta;
import com.ceiba.horarios_profesor.consulta.ObtenerHorariosProfesorManejadorConsulta;
import com.ceiba.horarios_profesor.modelo.dto.HorariosProfesorDTO;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/horarios-profesor")
@Api(tags = {"Controlador consulta horarios"})
public class ConsultarHorariosProfesorControlador {
    private final ListarHorariosProfesorManejadorConsulta listarHorariosProfesorManejadorConsulta;
    private final ObtenerHorariosProfesorManejadorConsulta obtenerHorariosProfesorManejadorConsulta;

    public ConsultarHorariosProfesorControlador(ListarHorariosProfesorManejadorConsulta consulta, ObtenerHorariosProfesorManejadorConsulta obtenerHorariosProfesorManejadorConsulta) {
        this.listarHorariosProfesorManejadorConsulta = consulta;
        this.obtenerHorariosProfesorManejadorConsulta = obtenerHorariosProfesorManejadorConsulta;
    }

    @GetMapping
    @ApiOperation("Listar horarios")
    public List<HorariosProfesorDTO> listar() {
        return this.listarHorariosProfesorManejadorConsulta.ejecutar();
    }

    @GetMapping("/{id}")
    @ApiOperation("obtine un horario en especifico")
    public List<HorariosProfesorDTO> obtener(@PathVariable Long id) {
        return this.obtenerHorariosProfesorManejadorConsulta.ejecutar(id);
    }
}
