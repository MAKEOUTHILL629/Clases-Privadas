package com.ceiba.configuracion;

import com.ceiba.persona.puerto.dao.PersonaDAO;
import com.ceiba.profesor.puerto.repositorio.ProfesorRepositorio;
import com.ceiba.profesor.servicio.ActualizarProfesorServicio;
import com.ceiba.profesor.servicio.CrearProfesorServicio;
import com.ceiba.profesor.servicio.EliminarProfesorServicio;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class BeanProfesorServicio {
    @Bean
    public CrearProfesorServicio crearProfesorServicio(ProfesorRepositorio profesorRepositorio, PersonaDAO personaDAO) {
        return new CrearProfesorServicio(profesorRepositorio, personaDAO);
    }

    @Bean
    public EliminarProfesorServicio eliminarProfesorServicio(ProfesorRepositorio profesorRepositorio) {
        return new EliminarProfesorServicio(profesorRepositorio);
    }

    @Bean
    public ActualizarProfesorServicio actualizarProfesorServicio(ProfesorRepositorio profesorRepositorio, PersonaDAO personaDAO) {
        return new ActualizarProfesorServicio(profesorRepositorio, personaDAO);
    }
}
