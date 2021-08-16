package com.ceiba.temas_profesor.servicio;

import com.ceiba.dominio.excepcion.ExcepcionDuplicidad;
import com.ceiba.temas_profesor.modelo.entidad.TemasProfesor;
import com.ceiba.temas_profesor.puerto.repositorio.TemasProfesorRepositorio;

public class ActualizarTemaProfesorServicio {
    private static final String EL_TEMA_NO_EXISTE_EN_EL_SISTEMA = "El tema no existe en el sistema ";
    private final TemasProfesorRepositorio repositorio;

    public ActualizarTemaProfesorServicio(TemasProfesorRepositorio repositorio) {
        this.repositorio = repositorio;
    }

    public void ejecutar(TemasProfesor tema){
        validarExistenciaPrevia(tema);
        this.repositorio.actualizar(tema);
    }

    private void validarExistenciaPrevia(TemasProfesor temasProfesor) {
        boolean existe = this.repositorio.existe(temasProfesor.getId());
        if(existe) {
            throw new ExcepcionDuplicidad(EL_TEMA_NO_EXISTE_EN_EL_SISTEMA);
        }
    }


}
