package com.ceiba.horarios_profesor.servicio;

import com.ceiba.dominio.excepcion.ExcepcionDuplicidad;
import com.ceiba.horarios_profesor.modelo.entidad.HorariosProfesor;
import com.ceiba.horarios_profesor.puerto.repositorio.HorariosProfesorRepositorio;

public class CrearHorarioProfesorServicio {
    private static final String EL_HORARIO_YA_EXISTE_EN_EL_SISTEMA = " El horario ya existe en el sistema";

    private final HorariosProfesorRepositorio repositorio;

    public CrearHorarioProfesorServicio(HorariosProfesorRepositorio repositorio) {
        this.repositorio = repositorio;
    }

    public Long ejecutar(HorariosProfesor horariosProfesor) {
        validarExistenciaPrevia(horariosProfesor);
        return this.repositorio.crear(horariosProfesor);
    }

    private void validarExistenciaPrevia(HorariosProfesor horariosProfesor) {
        boolean existe = this.repositorio.existe(horariosProfesor.getId());
        if (existe) {
            throw new ExcepcionDuplicidad(EL_HORARIO_YA_EXISTE_EN_EL_SISTEMA);
        }
    }

}
