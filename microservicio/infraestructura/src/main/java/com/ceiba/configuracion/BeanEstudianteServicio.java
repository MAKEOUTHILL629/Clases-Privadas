package com.ceiba.configuracion;


import com.ceiba.estudiante.puerto.repositorio.EstudianteRepositorio;
import com.ceiba.estudiante.servicio.ActualizarEstudianteServicio;
import com.ceiba.estudiante.servicio.CrearEstudianteServicio;
import com.ceiba.estudiante.servicio.EliminarEstudianteServicio;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class BeanEstudianteServicio {

    @Bean
    public CrearEstudianteServicio crearEstudianteServicio(EstudianteRepositorio repositorio) {
        return new CrearEstudianteServicio(repositorio);
    }

    @Bean
    public EliminarEstudianteServicio eliminarEstudianteServicio(EstudianteRepositorio repositorio) {
        return new EliminarEstudianteServicio(repositorio);
    }

    @Bean
    public ActualizarEstudianteServicio actualizarEstudianteServicio(EstudianteRepositorio repositorio) {
        return new ActualizarEstudianteServicio(repositorio);
    }
}
