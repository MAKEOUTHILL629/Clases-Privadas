update persona
set first_name = :nombres,
    last_name = :apellidos,
    cedula = :cedula
where id = :id