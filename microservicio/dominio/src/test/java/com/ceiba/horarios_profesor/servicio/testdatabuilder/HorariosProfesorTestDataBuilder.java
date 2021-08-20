package com.ceiba.horarios_profesor.servicio.testdatabuilder;

import com.ceiba.horarios_profesor.modelo.clasificacion.DiasSemana;
import com.ceiba.horarios_profesor.modelo.entidad.HorariosProfesor;
import com.ceiba.profesor.modelo.entidad.Profesor;
import com.ceiba.profesor.servicio.testdatabuilder.ProfesorTestDataBuilder;

import java.time.LocalTime;

public class HorariosProfesorTestDataBuilder {
    private Long id;
    private Profesor profesor;
    private DiasSemana diaSemana;
    private LocalTime hora;


    public HorariosProfesorTestDataBuilder() {
        this.id = 1l;
        this.profesor = new ProfesorTestDataBuilder().setId(2l).build();
        this.diaSemana = DiasSemana.DOMINGO;
        this.hora = LocalTime.of(11, 30);
    }


    public HorariosProfesorTestDataBuilder setId(Long id) {
        this.id = id;
        return this;
    }

    public HorariosProfesorTestDataBuilder setProfesor(Profesor profesor) {
        this.profesor = profesor;
        return this;
    }

    public HorariosProfesorTestDataBuilder setDiaSemana(DiasSemana diaSemana) {
        this.diaSemana = diaSemana;
        return this;
    }

    public HorariosProfesorTestDataBuilder setHora(LocalTime hora) {
        this.hora = hora;
        return this;
    }

    public HorariosProfesor build(){
        HorariosProfesor horariosProfesor = new HorariosProfesor(profesor,diaSemana,hora);
        horariosProfesor.setId(id);

        return horariosProfesor;
    }
}
