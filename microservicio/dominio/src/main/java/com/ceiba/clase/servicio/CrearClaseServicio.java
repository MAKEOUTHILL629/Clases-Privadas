package com.ceiba.clase.servicio;

import com.ceiba.clase.modelo.entidad.Clase;
import com.ceiba.clase.puerto.repositorio.ClaseRepositorio;
import com.ceiba.clase.servicio.utilidad.GenerarValor;
import com.ceiba.clase.servicio.utilidad.Tarifa;

public class CrearClaseServicio {
    private final ClaseRepositorio repositorio;

    public CrearClaseServicio(ClaseRepositorio repositorio) {
        this.repositorio = repositorio;
    }

    public Long ejecutar(Clase clase){
        Double valorClase = GenerarValor.generarTotal(clase.getFecha(), !validarExistenciaPrevia(clase), Tarifa.generarTarifa(clase.getEstudiante()));
        Clase claseGenerada = new Clase(clase.getId(), clase.getEstudiante(), clase.getProfesor(), clase.getFecha(),valorClase);
        return this.repositorio.crear(claseGenerada);
    }

    public Boolean validarExistenciaPrevia(Clase clase) {
        return this.repositorio.existe(clase.getId());
    }


}
