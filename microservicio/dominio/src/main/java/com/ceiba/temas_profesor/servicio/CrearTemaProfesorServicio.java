package com.ceiba.temas_profesor.servicio;

import com.ceiba.dominio.excepcion.ExcepcionDuplicidad;
import com.ceiba.temas_profesor.modelo.entidad.TemasProfesor;
import com.ceiba.temas_profesor.puerto.repositorio.TemasProfesorRepositorio;

public class CrearTemaProfesorServicio {
    private static final String EL_TEMA_YA_EXISTE_EN_EL_SISTEMA = "El tema ya se encuentra en la base de datos";

    private final TemasProfesorRepositorio repositorio;

    public CrearTemaProfesorServicio(TemasProfesorRepositorio repositorio) {
        this.repositorio = repositorio;
    }

    public Long ejecutar(TemasProfesor tema) {
        validarExistenciaPrevia(tema);
        return this.repositorio.crear(tema);
    }

    private void validarExistenciaPrevia(TemasProfesor tema) {
        boolean existe = this.repositorio.existe(tema.getId());
        if (existe) {
            throw new ExcepcionDuplicidad(EL_TEMA_YA_EXISTE_EN_EL_SISTEMA);
        }
    }
}
