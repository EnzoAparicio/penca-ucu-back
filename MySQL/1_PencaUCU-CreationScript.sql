CREATE DATABASE PENCAUCU;

USE PENCAUCU;

-- Enum
CREATE TABLE carrera (
    id_carrera INT AUTO_INCREMENT PRIMARY KEY,
    nombre VARCHAR(50) NOT NULL UNIQUE,
    anios VARCHAR(30)
);

create table estadio(
    id_estadio INT AUTO_INCREMENT PRIMARY KEY,
    nombre VARCHAR(50)
    );

CREATE TABLE torneo (
    id_torneo INT AUTO_INCREMENT PRIMARY KEY,
    nombre VARCHAR(100),
    anio VARCHAR(30)
);

CREATE TABLE equipo (
    id_equipo INT AUTO_INCREMENT PRIMARY KEY,
    nombre VARCHAR(50) NOT NULL,
    img_bandera VARCHAR(255),
    color VARCHAR(12)
);

CREATE TABLE usuario (
    id_usuario INT AUTO_INCREMENT PRIMARY KEY,
    email VARCHAR(100) NOT NULL,
    contrasenia VARCHAR(60) NOT NULL,
    nombre VARCHAR(50) NOT NULL,
    apellido VARCHAR(50),
    avatar_path VARCHAR(50),
    id_carrera INT,
    es_administrador BOOLEAN,
    FOREIGN KEY (id_carrera) REFERENCES carrera(id_carrera)
);

CREATE TABLE torneo_usuario (
	id_torneo_usuario INT AUTO_INCREMENT PRIMARY KEY,
    puntos INT,
    id_campeon INT,
    id_subcampeon INT,
    id_torneo INT,
    id_usuario INT,
    FOREIGN KEY (id_campeon) REFERENCES equipo(id_equipo),
    FOREIGN KEY (id_subcampeon) REFERENCES equipo(id_equipo),
    FOREIGN KEY (id_torneo) REFERENCES torneo(id_torneo),
    FOREIGN KEY (id_usuario) REFERENCES usuario(id_usuario)
);

create table partido(
    id_partido int auto_increment primary key,
    fecha datetime(6),
    id_estadio int,
    id_torneo int,
    foreign key (id_estadio) references estadio(id_estadio),
    foreign key (id_torneo) references torneo(id_torneo)
);

CREATE TABLE equipo_partido (
    id_equipo_partido INT AUTO_INCREMENT PRIMARY KEY,
    tipo_equipo INT,
    resultado INT,
    id_equipo INT,
    id_partido INT,
    FOREIGN KEY (id_equipo) REFERENCES equipo(id_equipo),
    FOREIGN KEY (id_partido) REFERENCES partido(id_partido)
);

CREATE TABLE prediccion (
    id_prediccion INT PRIMARY KEY AUTO_INCREMENT,
    prediccion_equipo1 INT,
    prediccion_equipo2 INT,
    puntos INT,
    id_usuario INT,
    id_partido INT,
    FOREIGN KEY (id_usuario) REFERENCES usuario(id_usuario),
    FOREIGN KEY (id_partido) REFERENCES partido(id_partido)
);
 
-- De aquí en más se comienzan a poblar los enumerados.

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
INSERT INTO estadio (nombre) 
VALUES 
('Estadio Centenario'),
('Estadio Maracanã'),
('Estadio Monumental'),
('Estadio Azteca'),
('Estadio Santiago Bernabéu'),
('Estadio Camp Nou'),
('Estadio Wembley'),
('Estadio Allianz Arena'),
('Estadio San Siro'),
('Estadio Old Trafford');

