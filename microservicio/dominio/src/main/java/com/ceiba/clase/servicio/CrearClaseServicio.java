package com.ceiba.clase.servicio;

import com.ceiba.clase.modelo.entidad.Clase;
import com.ceiba.clase.puerto.repositorio.ClaseRepositorio;
import com.ceiba.dominio.excepcion.ExcepcionDuplicidad;

public class CrearClaseServicio {
    private static final String LA_CLASE_EXISTE_EN_EL_SISTEMA = "La clase existe en el sistema";
    private final ClaseRepositorio repositorio;

    public CrearClaseServicio(ClaseRepositorio repositorio) {
        this.repositorio = repositorio;
    }

    public Long ejecutar(Clase clase){
        validarExistenciaPrevia(clase);
        return this.repositorio.crear(clase);
    }

    public void validarExistenciaPrevia(Clase clase) {
        boolean existencia = this.repositorio.existe(clase.getId());
        if (existencia) {
            throw new ExcepcionDuplicidad(LA_CLASE_EXISTE_EN_EL_SISTEMA);
        }
    }
}
