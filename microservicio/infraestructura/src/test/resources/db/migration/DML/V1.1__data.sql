insert into usuario(nombre,clave,fecha_creacion) values('test','1234',now());


INSERT INTO persona (first_name,last_name,cedula) VALUES
('Guy','Trevino','1676051331'),
('Zena','Woodard','1639082941'),
('Akeem','Horn','1690120926'),
('Piper','Brewer','1697060264'),
('Ruby','Huff','1605072799'),
('Castor','Thompson','1685122853'),
('Yoko','Sears','1694050304'),
('Patricia','Mcneil','1665110629'),
('Denton','Copeland','1666032219'),
('Alice','Gonzales','1630091502'),
('Jeanette','Garza','1620110256'),
('Rahim','Greer','1605110715'),
('Daquan','Pate','1616053017'),
('Carly','Taylor','1642051569'),
('Odysseus','Levy','1691080710'),
('Luis Felipe','Hernandez Chica','1391090710');


INSERT INTO estudiante (id_persona,nivel_estudios) VALUES
(1,'UNIVERSIDAD'),
(2,'SECUNDARIA'),
(3,'PRIMARIA'),
(4,'PRIMARIA'),
(5,'PRIMARIA'),
(6,'UNIVERSIDAD'),
(7,'PRIMARIA');


INSERT INTO profesor (id_persona,profesion) VALUES
(8,'Biologo')
,(9,'Ingeniero')
,(10,'Educador intercultural')
,(11,'Educador intercultural')
,(12,'Matematico'),(13,'Matematico')
,(14,'Biologo');

INSERT INTO horarios_profesor  (id_profesor,dia_semana,hora) VALUES
(1,'SABADO','02:00:00'),
(2,'MIERCOLES','09:00:00'),
(3,'JUEVES','01:00:00'),
(4,'DOMINGO','02:00:00'),
(5,'JUEVES','07:00:00'),
(6,'DOMINGO','02:00:00'),
(7,'DOMINGO','07:00:00');

INSERT INTO temas_profesor (id_profesor,tema) VALUES
 (1,'SOCIEDAD'),
 (2,'PAVIMENTOS'),
 (3,'INTEGRALES'),
 (4,'SOCIEDAD'),
 (5,'CULTURA'),
 (6,'DERIVADAS'),
 (7,'METAMORFOSIS');

 INSERT INTO clase (id_profesor, id_estudiante, fecha, valor) VALUES
 (1,1, '2021-08-22 12:00:00', 69500),
 (2,3, '2021-08-19 12:00:00', 36750),
 (3,2, '2021-08-21 12:00:00', 82175),
 (5,4, '2021-08-21 16:00:00', 52275);
