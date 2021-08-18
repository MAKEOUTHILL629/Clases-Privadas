package com.ceiba.configuracion;

import com.ceiba.profesor.puerto.repositorio.ProfesorRepositorio;
import com.ceiba.profesor.servicio.ActualizarProfesorServicio;
import com.ceiba.profesor.servicio.CrearProfesorServicio;
import com.ceiba.profesor.servicio.EliminarProfesorServicio;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class BeanProfesorServicio {
    @Bean
    public CrearProfesorServicio crearProfesorServicio(ProfesorRepositorio repositorio) {
        return new CrearProfesorServicio(repositorio);
    }

    @Bean
    public EliminarProfesorServicio eliminarProfesorServicio(ProfesorRepositorio repositorio) {
        return new EliminarProfesorServicio(repositorio);
    }

    @Bean
    public ActualizarProfesorServicio actualizarProfesorServicio(ProfesorRepositorio repositorio) {
        return new ActualizarProfesorServicio(repositorio);
    }
}
