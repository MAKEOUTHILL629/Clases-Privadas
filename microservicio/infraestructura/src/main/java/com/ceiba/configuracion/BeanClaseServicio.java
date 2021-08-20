package com.ceiba.configuracion;


import com.ceiba.clase.puerto.repositorio.ClaseRepositorio;
import com.ceiba.clase.servicio.ActualizarClaseServicio;
import com.ceiba.clase.servicio.CrearClaseServicio;
import com.ceiba.clase.servicio.EliminarClaseServicio;
import com.ceiba.estudiante.puerto.dao.EstudianteDAO;
import com.ceiba.profesor.puerto.dao.ProfesorDAO;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class BeanClaseServicio {
    @Bean
    public CrearClaseServicio crearClaseServicio(ClaseRepositorio repositorio, EstudianteDAO estudianteDAO, ProfesorDAO profesorDAO) {
        return new CrearClaseServicio(repositorio, estudianteDAO, profesorDAO);
    }

    @Bean
    public EliminarClaseServicio eliminarClaseServicio(ClaseRepositorio claseRepositorio) {
        return new EliminarClaseServicio(claseRepositorio);
    }

    @Bean
    public ActualizarClaseServicio actualizarClaseServicio(ClaseRepositorio claseRepositorio ,EstudianteDAO estudianteDAO, ProfesorDAO profesorDAO) {
        return new ActualizarClaseServicio(claseRepositorio,estudianteDAO,profesorDAO);
    }
}
