package com.ceiba.temas_profesor.modelo.dto;


import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class TemasProfesorDTO {
    private Long id;
    private Long idProfesor;
    private String tema;
}
