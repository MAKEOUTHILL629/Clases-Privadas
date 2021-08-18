package com.ceiba.configuracion;

import com.ceiba.horarios_profesor.puerto.repositorio.HorariosProfesorRepositorio;
import com.ceiba.horarios_profesor.servicio.ActualizarHorarioProfesorServicio;
import com.ceiba.horarios_profesor.servicio.CrearHorarioProfesorServicio;
import com.ceiba.horarios_profesor.servicio.EliminarHorarioProfesorService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class BeanHorariosProfesorServicio {
    @Bean
    public CrearHorarioProfesorServicio crearHorarioProfesorServicio(HorariosProfesorRepositorio repositorio) {
        return new CrearHorarioProfesorServicio(repositorio);
    }

    @Bean
    public EliminarHorarioProfesorService eliminarHorarioProfesorService(HorariosProfesorRepositorio repositorio) {
        return new EliminarHorarioProfesorService(repositorio);
    }

    @Bean
    public ActualizarHorarioProfesorServicio actualizarHorarioProfesorServicio(HorariosProfesorRepositorio repositorio) {
        return new ActualizarHorarioProfesorServicio(repositorio);
    }
}
