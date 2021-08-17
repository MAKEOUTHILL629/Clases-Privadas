update horarios_profesor
set id_profesor = :profesor.id,
    dia_semana = :diaSemana,
    hora = :hora
where id = :id