INSERT INTO usuario (email, contrasenia, nombre, apellido, avatar_path, id_carrera) VALUES
 ('luisa.perez@email.com', 'contrasenia123', 'Luisa', 'Perez', 'avatar_luisa.png', 1);


INSERT INTO torneo (nombre, anio) VALUES
('Copa America', '2024');

INSERT INTO equipo (nombre, img_bandera, color) VALUES
('Brasil', 'brasil.png', '#009739'),
('Colombia', 'colombia.png', '#FFCD00'),
('Argentina', 'argentina.png', '#5F9CD3'),
('Bolivia', 'bolivia.png', '#F8E600'),
('Paraguay', 'paraguay.png', '#D52B1E'),
('Panama', 'panama.png', '#072357'),
('Peru', 'peru.png', '#C8102E'),
('Canada', 'canada.png', '#D80621'),
('México', 'mexico.png', '#006341'),
('Jamaica', 'jamaica.png', '#009B3A'),
('Costa Rica, 'costaRica.png', '#FFFFFF'),
('Ecuador', 'ecuador.png', '#FFFF00'),
('Venezuela', 'venezuela.png', '#B92034'),
('Uruguay', 'uruguay.png', '#3878BC'),
('Estados Unidos', 'usa.png', '#B31942'),
('Chile', 'chile.png', '#0032A0');


INSERT INTO partido (fecha, id_estadio, id_torneo) 
VALUES 
('2024-06-20', 1, 1),
('2024-06-21', 3, 1),
('2024-06-22', 9, 1),
('2024-06-22', 14, 1),
('2024-06-23', 3, 1),
('2024-06-23', 2, 1);

INSERT INTO equipo_partido (tipo_equipo, id_equipo, id_partido)
VALUES
(1, 3, 1),
(2, 8, 1),
(1, 7, 2),
(2, 16, 2),
(1, 9, 3),
(2, 10, 3),
(1, 12, 4),
(2, 13, 4),
(1, 15, 5),
(2, 4, 5),
(1, 14, 6),
(2, 6, 6);
