package com.ceiba.clase.servicio;

import com.ceiba.clase.modelo.entidad.Clase;
import com.ceiba.clase.puerto.repositorio.ClaseRepositorio;
import com.ceiba.clase.servicio.utilidad.GenerarValor;
import com.ceiba.clase.servicio.utilidad.Tarifa;
import com.ceiba.dominio.excepcion.ExcepcionDuplicidad;
import com.ceiba.estudiante.modelo.dto.EstudianteDTO;
import com.ceiba.estudiante.puerto.dao.EstudianteDAO;


public class CrearClaseServicio {

    private static final  String LA_CLASE_YA_EXISTE_EN_EL_SISTEMA = "La clase ya se encuentra en el sistema";

    private final ClaseRepositorio repositorio;

    private final EstudianteDAO estudianteDAO;

    public CrearClaseServicio(ClaseRepositorio repositorio, EstudianteDAO estudianteDAO) {
        this.repositorio = repositorio;

        this.estudianteDAO = estudianteDAO;
    }

    public Long ejecutar(Clase clase) {
        esRepetido(clase);
        EstudianteDTO estudianteDTO = estudianteDAO.obtener(clase.getEstudiante().getId());
        Double valorClase = GenerarValor.generarTotal(clase.getFecha(), !validarExistenciaPrevia(clase), Tarifa.generarTarifa(estudianteDTO.getNivelEstudios()));
        Clase claseGenerada = new Clase(clase.getId(), clase.getEstudiante(), clase.getProfesor(), clase.getFecha(), valorClase);
        return this.repositorio.crear(claseGenerada);
    }

    public Boolean validarExistenciaPrevia(Clase clase) {
        return this.repositorio.existe(clase);
    }

    public void esRepetido(Clase clase) {
        Boolean seRepitio = this.repositorio.esRepetido(clase);

        if (seRepitio.booleanValue()) {
            throw new ExcepcionDuplicidad(LA_CLASE_YA_EXISTE_EN_EL_SISTEMA);
        }
    }


}
