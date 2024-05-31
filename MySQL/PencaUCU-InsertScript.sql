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


-- Llenar la tabla 'Estadio'
INSERT INTO estadio (nombre) VALUES ('Estadio Centenario');
INSERT INTO estadio (nombre) VALUES ('Estadio Maracanã');
INSERT INTO estadio (nombre) VALUES ('Estadio Monumental');
INSERT INTO estadio (nombre) VALUES ('Estadio Azteca');
INSERT INTO estadio (nombre) VALUES ('Estadio Santiago Bernabéu');
INSERT INTO estadio (nombre) VALUES ('Estadio Camp Nou');
INSERT INTO estadio (nombre) VALUES ('Estadio Wembley');
INSERT INTO estadio (nombre) VALUES ('Estadio Allianz Arena');
INSERT INTO estadio (nombre) VALUES ('Estadio San Siro');
INSERT INTO estadio (nombre) VALUES ('Estadio Old Trafford');


-- Llenar la tabla 'Partido'
INSERT INTO partido (resultado_e1, resultado_e2, fecha, id_estadio, id_equipo1, id_equipo2, id_torneo) 
VALUES 
(2, 1, '2024-06-12', 1, 1, 2, 1),
(0, 0, '2024-06-13', 2, 3, 4, 1),
(3, 2, '2024-06-14', 3, 5, 6, 1),
(1, 2, '2024-06-15', 4, 7, 8, 1),
(0, 3, '2024-06-16', 5, 9, 10, 1);

