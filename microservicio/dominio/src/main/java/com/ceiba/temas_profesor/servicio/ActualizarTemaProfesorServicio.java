package com.ceiba.temas_profesor.servicio;

import com.ceiba.dominio.excepcion.ExcepcionDuplicidad;
import com.ceiba.dominio.excepcion.ExcepcionValorInvalido;
import com.ceiba.profesor.puerto.dao.ProfesorDAO;
import com.ceiba.temas_profesor.modelo.entidad.TemasProfesor;
import com.ceiba.temas_profesor.puerto.repositorio.TemasProfesorRepositorio;

public class ActualizarTemaProfesorServicio {
    private static final String EL_TEMA_NO_EXISTE_EN_EL_SISTEMA = "El tema no existe en el sistema";
    private static final String EL_ID_DEL_PROFESOR_NO_EXISTE = "El id del profesor no existe";
    private final TemasProfesorRepositorio temasProfesorRepositorio;
    private final ProfesorDAO profesorDAO;

    public ActualizarTemaProfesorServicio(TemasProfesorRepositorio temasProfesorRepositorio, ProfesorDAO profesorDAO) {
        this.temasProfesorRepositorio = temasProfesorRepositorio;
        this.profesorDAO = profesorDAO;
    }

    public void ejecutar(TemasProfesor temasProfesor) {
        validarExistenciaPrevia(temasProfesor);
        validarExistenciaProfesor(temasProfesor.getProfesor().getId());
        this.temasProfesorRepositorio.actualizar(temasProfesor);
    }


    private void validarExistenciaPrevia(TemasProfesor temasProfesor) {
        boolean existe = this.temasProfesorRepositorio.existe(temasProfesor.getId());
        if (!existe) {
            throw new ExcepcionDuplicidad(EL_TEMA_NO_EXISTE_EN_EL_SISTEMA);
        }
    }

    private void validarExistenciaProfesor(Long id) {
        boolean profesorExiste = profesorDAO.obtener(id) != null;
        if (!profesorExiste) {
            throw new ExcepcionValorInvalido(EL_ID_DEL_PROFESOR_NO_EXISTE);
        }

    }


}
