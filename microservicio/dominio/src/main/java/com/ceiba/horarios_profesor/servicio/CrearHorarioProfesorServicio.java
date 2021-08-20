package com.ceiba.horarios_profesor.servicio;


import com.ceiba.dominio.excepcion.ExcepcionDuplicidad;
import com.ceiba.dominio.excepcion.ExcepcionValorInvalido;
import com.ceiba.horarios_profesor.modelo.entidad.HorariosProfesor;
import com.ceiba.horarios_profesor.puerto.repositorio.HorariosProfesorRepositorio;
import com.ceiba.profesor.puerto.dao.ProfesorDAO;

public class CrearHorarioProfesorServicio {
    private static final String EL_HORARIO_YA_EXISTE_EN_EL_SISTEMA = "El horario ya existe en el sistema";
    private static final String EL_ID_DEL_PROFESOR_NO_EXISTE = "El id del profesor no existe";

    private final HorariosProfesorRepositorio horariosProfesorRepositorio;
    private final ProfesorDAO profesorDAO;

    public CrearHorarioProfesorServicio(HorariosProfesorRepositorio horariosProfesorRepositorio, ProfesorDAO profesorDAO) {
        this.horariosProfesorRepositorio = horariosProfesorRepositorio;
        this.profesorDAO = profesorDAO;
    }

    public Long ejecutar(HorariosProfesor horariosProfesor) {
        validarExistenciaPrevia(horariosProfesor);
        validarExistenciaProfesor(horariosProfesor.getProfesor().getId());
        return this.horariosProfesorRepositorio.crear(horariosProfesor);
    }

    private void validarExistenciaPrevia(HorariosProfesor horariosProfesor) {
        boolean existe = this.horariosProfesorRepositorio.existeSinIdHorariosProfesor(horariosProfesor);
        if(existe){
            throw new ExcepcionDuplicidad(EL_HORARIO_YA_EXISTE_EN_EL_SISTEMA);
        }
    }

    private void validarExistenciaProfesor(Long id){
        boolean profesorExiste = profesorDAO.obtener(id) != null;
        if(!profesorExiste){
            throw  new ExcepcionValorInvalido(EL_ID_DEL_PROFESOR_NO_EXISTE);
        }

    }



}
