package com.ceiba.configuracion;

import com.ceiba.profesor.puerto.dao.ProfesorDAO;
import com.ceiba.temas_profesor.puerto.repositorio.TemasProfesorRepositorio;
import com.ceiba.temas_profesor.servicio.ActualizarTemaProfesorServicio;
import com.ceiba.temas_profesor.servicio.CrearTemaProfesorServicio;
import com.ceiba.temas_profesor.servicio.EliminarTemaProfesorService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class BeanTemasProfesorServicio {
    @Bean
    public CrearTemaProfesorServicio crearTemaProfesorServicio(TemasProfesorRepositorio temasProfesorRepositorio, ProfesorDAO profesorDAO) {
        return new CrearTemaProfesorServicio(temasProfesorRepositorio, profesorDAO);
    }

    @Bean
    public EliminarTemaProfesorService eliminarTemaProfesorService(TemasProfesorRepositorio temasProfesorRepositorio) {
        return new EliminarTemaProfesorService(temasProfesorRepositorio);
    }

    @Bean
    public ActualizarTemaProfesorServicio actualizarTemaProfesorServicio(TemasProfesorRepositorio temasProfesorRepositorio, ProfesorDAO profesorDAO) {
        return new ActualizarTemaProfesorServicio(temasProfesorRepositorio, profesorDAO);
    }
}
