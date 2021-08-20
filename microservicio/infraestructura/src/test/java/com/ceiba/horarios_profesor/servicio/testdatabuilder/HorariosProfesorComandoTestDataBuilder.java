package com.ceiba.horarios_profesor.servicio.testdatabuilder;

import com.ceiba.horarios_profesor.comando.HorariosProfesorComando;
import com.ceiba.horarios_profesor.modelo.clasificacion.DiasSemana;
import com.ceiba.horarios_profesor.modelo.utilidad.HoraEntrada;

import java.time.LocalTime;

public class HorariosProfesorComandoTestDataBuilder {

    private Long id;
    private Long idProfesor;
    private DiasSemana diaSemana;
    private String hora;

    public HorariosProfesorComandoTestDataBuilder() {
        this.idProfesor = 3L;
        this.diaSemana = DiasSemana.SABADO;
        this.hora = "22:00";
    }

    public HorariosProfesorComandoTestDataBuilder setId(Long id) {
        this.id = id;
        return this;
    }

    public HorariosProfesorComandoTestDataBuilder setIdProfesor(Long idProfesor) {
        this.idProfesor = idProfesor;
        return this;
    }

    public HorariosProfesorComandoTestDataBuilder setDiaSemana(DiasSemana diaSemana) {
        this.diaSemana = diaSemana;
        return this;
    }

    public HorariosProfesorComandoTestDataBuilder setHora(String hora) {
        this.hora = hora;
        return this;
    }

    public HorariosProfesorComando build() {
        return new HorariosProfesorComando(idProfesor, diaSemana, hora);
    }
}
