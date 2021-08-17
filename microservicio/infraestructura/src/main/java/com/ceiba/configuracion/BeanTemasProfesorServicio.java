package com.ceiba.configuracion;

import com.ceiba.temas_profesor.puerto.repositorio.TemasProfesorRepositorio;
import com.ceiba.temas_profesor.servicio.ActualizarTemaProfesorServicio;
import com.ceiba.temas_profesor.servicio.CrearTemaProfesorServicio;
import com.ceiba.temas_profesor.servicio.EliminarTemaProfesorService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class BeanTemasProfesorServicio {
    @Bean
    public CrearTemaProfesorServicio crearTemaProfesorServicio (TemasProfesorRepositorio repositorio){
        return new CrearTemaProfesorServicio(repositorio);
    }

    @Bean
    public EliminarTemaProfesorService eliminarTemaProfesorService(TemasProfesorRepositorio repositorio){
        return new EliminarTemaProfesorService(repositorio);
    }

    @Bean
    public ActualizarTemaProfesorServicio actualizarTemaProfesorServicio(TemasProfesorRepositorio repositorio){
        return new ActualizarTemaProfesorServicio(repositorio);
    }
}
