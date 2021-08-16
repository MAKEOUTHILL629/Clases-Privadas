package com.ceiba.estudiante.comando;

import lombok.*;

@Data
public class ComandoEstudiante {
    private Long id;
    private String first_name;
    private String last_name;
    private String cedula;
    private String nivel_estudios;
}
