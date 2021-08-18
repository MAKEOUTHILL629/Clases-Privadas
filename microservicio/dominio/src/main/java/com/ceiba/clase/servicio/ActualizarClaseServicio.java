package com.ceiba.clase.servicio;

import com.ceiba.clase.modelo.entidad.Clase;
import com.ceiba.clase.puerto.repositorio.ClaseRepositorio;
import com.ceiba.dominio.excepcion.ExcepcionDuplicidad;

public class ActualizarClaseServicio {
    private static final String LA_CLASE_NO_EXISTE_EN_EL_SISTEMA = "La clase no existe en el sistema";
    private final ClaseRepositorio repositorio;

    public ActualizarClaseServicio(ClaseRepositorio repositorio) {
        this.repositorio = repositorio;
    }


    public void ejecutar(Clase clase) {

        this.repositorio.actualizar(clase);
    }


}
