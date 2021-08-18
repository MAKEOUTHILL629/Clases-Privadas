package com.ceiba.horarios_profesor.servicio.testdatabuilder;

import com.ceiba.horarios_profesor.comando.HorariosProfesorComando;

import java.time.LocalTime;

public class HorariosProfesorComandoTestDataBuilder {

    private Long id;
    private Long idProfesor;
    private String diaSemana;
    private LocalTime hora;

    public HorariosProfesorComandoTestDataBuilder() {
        this.idProfesor = 3L;
        this.diaSemana = "SABADO";
        this.hora = LocalTime.now();
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setIdProfesor(Long idProfesor) {
        this.idProfesor = idProfesor;
    }

    public void setDiaSemana(String diaSemana) {
        this.diaSemana = diaSemana;
    }

    public void setHora(LocalTime hora) {
        this.hora = hora;
    }

    public HorariosProfesorComando build(){
        return new HorariosProfesorComando(id,idProfesor,diaSemana,hora);
    }
}
