package com.ceiba.horarios_profesor.servicio;

import com.ceiba.dominio.excepcion.ExcepcionDuplicidad;
import com.ceiba.horarios_profesor.modelo.entidad.HorariosProfesor;
import com.ceiba.horarios_profesor.puerto.repositorio.HorariosProfesorRepositorio;


public class ActualizarHorarioProfesorServicio {
    private static final String EL_HORARIO_NO_EXISTE_EN_EL_SISTEMA = "El horario no existe en el sistema";
    private final HorariosProfesorRepositorio repositorio;

    public ActualizarHorarioProfesorServicio(HorariosProfesorRepositorio repositorio) {
        this.repositorio = repositorio;
    }

    public void ejecutar(HorariosProfesor horariosProfesor) {
        validarExistenciaPrevia(horariosProfesor);
        this.repositorio.actualizar(horariosProfesor);
    }

    private void validarExistenciaPrevia(HorariosProfesor horariosProfesor) {
        boolean existe = this.repositorio.existe(horariosProfesor.getId());
        if (existe) {
            throw new ExcepcionDuplicidad(EL_HORARIO_NO_EXISTE_EN_EL_SISTEMA);
        }
    }

}
