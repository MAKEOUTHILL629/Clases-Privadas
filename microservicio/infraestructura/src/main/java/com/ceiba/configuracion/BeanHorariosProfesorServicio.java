package com.ceiba.configuracion;

import com.ceiba.horarios_profesor.puerto.repositorio.HorariosProfesorRepositorio;
import com.ceiba.horarios_profesor.servicio.ActualizarHorarioProfesorServicio;
import com.ceiba.horarios_profesor.servicio.CrearHorarioProfesorServicio;
import com.ceiba.horarios_profesor.servicio.EliminarHorarioProfesorService;
import com.ceiba.profesor.puerto.dao.ProfesorDAO;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class BeanHorariosProfesorServicio {
    @Bean
    public CrearHorarioProfesorServicio crearHorarioProfesorServicio(HorariosProfesorRepositorio horariosProfesorRepositorio, ProfesorDAO profesorDAO) {
        return new CrearHorarioProfesorServicio(horariosProfesorRepositorio, profesorDAO);
    }

    @Bean
    public EliminarHorarioProfesorService eliminarHorarioProfesorService(HorariosProfesorRepositorio horariosProfesorRepositorio) {
        return new EliminarHorarioProfesorService(horariosProfesorRepositorio);
    }

    @Bean
    public ActualizarHorarioProfesorServicio actualizarHorarioProfesorServicio(HorariosProfesorRepositorio horariosProfesorRepositorio, ProfesorDAO profesorDAO) {
        return new ActualizarHorarioProfesorServicio(horariosProfesorRepositorio, profesorDAO);
    }
}
