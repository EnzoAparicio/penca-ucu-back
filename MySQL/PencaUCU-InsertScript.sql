-- Llenar la tabla 'Carrera'
INSERT INTO carrera (nombre, anios)
VALUES
	('Abogacía', 5),
	('Acompañamiento Terapéutico', 2),
	('Agronomía', 5),
	('Analista en Informática', 3),
	('Arquitectura', 5),
	('Artes Escénicas', 4),
	('Artes Visuales', 4),
	('Business Analytics', 4),
	('Ciencia Política', 4),
	('Cine', 4),
	('Comunicación', 4),
	('Comunicación y Marketing', 4),
	('Contador Público', 4),
	('Datos y Negocios', 4),
	('Desarrollador de Software', 2),
	('Dirección de Empresas', 4),
	('Economía', 4),
	('Educación Inicial', 4),
	('Finanzas', 4),
	('Fisioterapia', 4),
	('Fonoaudiología', 4),
	('Gestión Humana', 4),
	('Ingeniería Ambiental', 5),
	('Ingeniería en Alimentos', 5),
	('Ingeniería en Electrónica', 5),
	('Ingeniería en Informática', 5),
	('Ingeniería Industrial', 5),
	('Inteligencia Artificial y Ciencia de Datos', 5),
	('Licenciatura en Enfermería', 4),
	('Licenciatura en Informática', 4),
	('Medicina', 6),
	('Negocios Internacionales', 4),
	('Negocios y Economía', 4),
	('Notariado', 5),
	('Nutrición', 4),
	('Odontología', 4),
	('Psicología', 4),
	('Psicomotricidad', 4),
	('Psicopedagogía', 4),
	('Recreación Educativa', 4),
	('Sociología', 4),
	('Trabajo Social', 4);
    
insert into estadio (nombre)
values("ALLEGIANT_STADIUM"), ("ATANDT_STADIUM"), ("BANK_OF_AMERICA_STADIUM"), ("CHILDRENS_MERCY_PARK"), ("EXPLORIA_STADIUM"),
("ARROWHEAD_STADIUM"), ("HARD_ROCK_STADIUM"), ("LEVIS_STADIUM"), ("MERCEDES_BENZ_STADIUM"), ("METLIFE_STADIUM"), 
("NRG_STADIUM"), ("Q2_STADIUM"), ("SOFI_STADIUM"), ("STATE_FARM_STADIUM"); 

INSERT INTO equipo (nombre, img_bandera, color) VALUES
('Equipo A', 'img/equipoA.png', 'Rojo'),
('Equipo B', 'img/equipoB.png', 'Azul'),
('Equipo C', 'img/equipoC.png', 'Verde');

INSERT INTO torneo (id_torneo, nombre, anio) VALUES
(1, 'Torneo de Invierno', '2024'),
(2, 'Torneo de Verano', '2024');

INSERT INTO partido (resultado_e1, resultado_e2, fecha, id_estadio, id_equipo1, id_equipo2, id_torneo) VALUES
(3, 2, '2024-06-01', 1, 1, 2, 1),
(1, 1, '2024-06-08', 2, 2, 3, 1),
(2,2, '2024-05-29', 3, 3, 2, 1);