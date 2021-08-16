package com.ceiba.horarios_profesor.controlador;

import com.ceiba.horarios_profesor.consulta.ListarHorariosProfesorConsulta;
import com.ceiba.horarios_profesor.modelo.dto.HorariosProfesorDTO;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/horarios")
@Api(tags = {"Controlador consulta horarios"})
public class ConsultarHorariosProfesorControlador {
    private final ListarHorariosProfesorConsulta consulta;

    public ConsultarHorariosProfesorControlador(ListarHorariosProfesorConsulta consulta) {
        this.consulta = consulta;
    }

    @GetMapping
    @ApiOperation("Listar horarios")
    public List<HorariosProfesorDTO> listar(){
        return this.consulta.ejecutar();
    }
}
