package com.ceiba.horarios_profesor.controlador;

import com.ceiba.horarios_profesor.consulta.ListarHorariosProfesorConsulta;
import com.ceiba.horarios_profesor.consulta.ObtenerHorariosProfesorConsulta;
import com.ceiba.horarios_profesor.modelo.dto.HorariosProfesorDTO;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/horarios-profesor")
@Api(tags = {"Controlador consulta horarios"})
public class ConsultarHorariosProfesorControlador {
    private final ListarHorariosProfesorConsulta consulta;
    private final ObtenerHorariosProfesorConsulta obtenerHorariosProfesorConsulta;

    public ConsultarHorariosProfesorControlador(ListarHorariosProfesorConsulta consulta, ObtenerHorariosProfesorConsulta obtenerHorariosProfesorConsulta) {
        this.consulta = consulta;
        this.obtenerHorariosProfesorConsulta = obtenerHorariosProfesorConsulta;
    }

    @GetMapping
    @ApiOperation("Listar horarios")
    public List<HorariosProfesorDTO> listar() {
        return this.consulta.ejecutar();
    }

    @GetMapping("/{id}")
    @ApiOperation("obtine un horario en especifico")
    public List<HorariosProfesorDTO> obtener(@PathVariable Long id) {
        return this.obtenerHorariosProfesorConsulta.ejecutar(id);
    }
}
