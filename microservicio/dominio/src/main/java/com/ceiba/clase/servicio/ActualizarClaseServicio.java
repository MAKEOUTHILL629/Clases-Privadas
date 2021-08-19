package com.ceiba.clase.servicio;

import com.ceiba.clase.modelo.entidad.Clase;
import com.ceiba.clase.puerto.repositorio.ClaseRepositorio;


public class ActualizarClaseServicio {

    private final ClaseRepositorio repositorio;

    public ActualizarClaseServicio(ClaseRepositorio repositorio) {
        this.repositorio = repositorio;
    }


    public void ejecutar(Clase clase) {
        this.repositorio.actualizar(clase);
    }


}
