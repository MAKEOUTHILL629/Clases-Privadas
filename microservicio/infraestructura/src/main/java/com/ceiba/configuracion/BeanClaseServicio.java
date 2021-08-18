package com.ceiba.configuracion;


import com.ceiba.clase.puerto.repositorio.ClaseRepositorio;
import com.ceiba.clase.servicio.ActualizarClaseServicio;
import com.ceiba.clase.servicio.CrearClaseServicio;
import com.ceiba.clase.servicio.EliminarClaseServicio;
import com.ceiba.estudiante.puerto.dao.EstudianteDAO;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class BeanClaseServicio {
    @Bean
    public CrearClaseServicio crearClaseServicio(ClaseRepositorio repositorio, EstudianteDAO estudianteDAO) {
        return new CrearClaseServicio(repositorio, estudianteDAO);
    }

    @Bean
    public EliminarClaseServicio eliminarClaseServicio(ClaseRepositorio repositorio) {
        return new EliminarClaseServicio(repositorio);
    }

    @Bean
    public ActualizarClaseServicio actualizarClaseServicio(ClaseRepositorio repositorio) {
        return new ActualizarClaseServicio(repositorio);
    }
}
