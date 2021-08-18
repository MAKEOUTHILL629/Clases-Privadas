package com.ceiba.clase.servicio;

import com.ceiba.clase.modelo.entidad.Clase;
import com.ceiba.clase.puerto.repositorio.ClaseRepositorio;
import com.ceiba.clase.servicio.utilidad.GenerarValor;
import com.ceiba.clase.servicio.utilidad.Tarifa;
import com.ceiba.estudiante.modelo.dto.EstudianteDTO;
import com.ceiba.estudiante.modelo.entidad.Estudiante;
import com.ceiba.estudiante.puerto.dao.EstudianteDAO;
import com.ceiba.profesor.puerto.dao.ProfesorDAO;

public class CrearClaseServicio {
    private final ClaseRepositorio repositorio;

    private final EstudianteDAO estudianteDAO;

    public CrearClaseServicio(ClaseRepositorio repositorio, EstudianteDAO estudianteDAO) {
        this.repositorio = repositorio;

        this.estudianteDAO = estudianteDAO;
    }

    public Long ejecutar(Clase clase){
        EstudianteDTO estudianteDTO = estudianteDAO.obtener(clase.getEstudiante().getId());
        Double valorClase = GenerarValor.generarTotal(clase.getFecha(), !validarExistenciaPrevia(clase), Tarifa.generarTarifa(estudianteDTO.getNivelEstudios()));
        Clase claseGenerada = new Clase(clase.getId(), clase.getEstudiante(), clase.getProfesor(), clase.getFecha(),valorClase);
        return this.repositorio.crear(claseGenerada);
    }

    public Boolean validarExistenciaPrevia(Clase clase) {
        return this.repositorio.existe(clase.getId());
    }


}
