package com.ceiba.persona.comando;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class PersonaComando {

    private Long id;
    private String nombres;
    private String apellidos;
    private String cedula;

}
