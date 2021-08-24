
CREATE TABLE persona (
  id int(11) NOT NULL auto_increment,
  first_name varchar(30) NOT NULL,
  last_name varchar(30) NOT NULL,
  cedula varchar(10) NOT NULL
);

CREATE TABLE profesor (
  id int(11) NOT NULL auto_increment,
  id_persona int(11) NOT NULL,
  profesion varchar(30) NOT NULL
);


CREATE TABLE estudiante (
  id int(11) NOT NULL auto_increment,
  id_persona int(11) NOT NULL,
  nivel_estudios varchar(18) NOT NULL
);


CREATE TABLE clase (
  id int(11) NOT NULL auto_increment,
  id_profesor int(11) NOT NULL,
  id_estudiante int(11) NOT NULL,
  fecha datetime null,
  valor double NOT NULL
);


CREATE TABLE horarios_profesor (
  id int(11) NOT NULL auto_increment,
  id_profesor int(11) NOT NULL,
  dia_semana varchar(10) NOT NULL,
  hora time NOT NULL
);


CREATE TABLE temas_profesor (
  id int(11) NOT NULL auto_increment,
  id_profesor int(11) NOT NULL,
  tema varchar(30) NOT NULL
);