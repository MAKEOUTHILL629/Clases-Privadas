package com.ceiba.configuracion;

import com.ceiba.persona.puerto.repositorio.PersonaRepositorio;
import com.ceiba.persona.servicio.ActualizarPersonaServicio;
import com.ceiba.persona.servicio.CrearPersonaServicio;
import com.ceiba.persona.servicio.EliminarPersonaServicio;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class BeanPersonaServicio {

    @Bean
    public CrearPersonaServicio crearPersonaServicio(PersonaRepositorio repositorio){
        return new CrearPersonaServicio(repositorio);
    }

    @Bean
    public EliminarPersonaServicio eliminarPersonaServicio(PersonaRepositorio repositorio){
        return new EliminarPersonaServicio(repositorio);
    }

    @Bean
    public ActualizarPersonaServicio actualizarPersonaServicio(PersonaRepositorio repositorio){
        return new ActualizarPersonaServicio(repositorio);
    }

}
