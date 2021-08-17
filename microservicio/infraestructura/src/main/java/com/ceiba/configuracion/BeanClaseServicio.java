package com.ceiba.configuracion;


import com.ceiba.clase.puerto.repositorio.ClaseRepositorio;
import com.ceiba.clase.servicio.ActualizarClaseServicio;
import com.ceiba.clase.servicio.CrearClaseServicio;
import com.ceiba.clase.servicio.EliminarClaseServicio;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class BeanClaseServicio {
    @Bean
    public CrearClaseServicio crearClaseServicio(ClaseRepositorio repositorio){
        return new CrearClaseServicio(repositorio);
    }

    @Bean
    public EliminarClaseServicio eliminarClaseServicio(ClaseRepositorio repositorio){
        return new EliminarClaseServicio(repositorio);
    }

    @Bean
    public ActualizarClaseServicio actualizarClaseServicio(ClaseRepositorio repositorio){
        return  new ActualizarClaseServicio(repositorio);
    }
}
