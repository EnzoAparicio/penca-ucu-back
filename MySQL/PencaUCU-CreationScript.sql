CREATE DATABASE PENCAUCU;

USE PENCAUCU;

-- Enum
CREATE TABLE carrera (
    id_carrera INT AUTO_INCREMENT PRIMARY KEY,
    nombre VARCHAR(50) NOT NULL UNIQUE,
    anios VARCHAR(30)
);

create table estadio(
	id_estadio int auto_increment primary key,
    nombre varchar(50)
    );

CREATE TABLE torneo (
    id_torneo INT PRIMARY KEY,
    nombre VARCHAR(100),
    anio VARCHAR(30)
);

CREATE TABLE equipo (
    id_equipo INT AUTO_INCREMENT PRIMARY KEY,
    nombre VARCHAR(100),
    img_bandera VARCHAR(255),
    color VARCHAR(50)
);

CREATE TABLE usuario (
    id_usuario INT AUTO_INCREMENT PRIMARY KEY,
    email VARCHAR(100) NOT NULL,
    contrasenia VARCHAR(60) NOT NULL,
    nombre VARCHAR(50) NOT NULL,
    apellido VARCHAR(50),
    avatar_path VARCHAR(50),
    id_carrera INT,
    puntos INT,
    es_administrador BOOLEAN,
    -- Se referencia la Foreign key luego de creada la otra tabla.
    id_prediccion_final INT,
    FOREIGN KEY (id_carrera) REFERENCES carrera(id_carrera)
);

CREATE TABLE prediccion_final (
	id_prediccion_final INT PRIMARY KEY AUTO_INCREMENT,
    id_campeon INT,
    id_subcampeon INT,
    id_torneo INT,
    id_usuario INT,
    FOREIGN KEY (id_campeon) REFERENCES equipo(id_equipo),
    FOREIGN KEY (id_subcampeon) REFERENCES equipo(id_equipo),
    FOREIGN KEY (id_torneo) REFERENCES torneo(id_torneo),
    FOREIGN KEY (id_usuario) REFERENCES usuario(id_usuario)
);

ALTER TABLE usuario
ADD FOREIGN KEY (id_prediccion_final) REFERENCES prediccion_final(id_prediccion_final);

create table partido(
	id_partido int auto_increment primary key,
    resultado_e1 int,
    resultado_e2 int,
    fecha date,
    id_estadio int,
    id_equipo1 int,
    id_equipo2 int,
    id_torneo int,
    foreign key (id_estadio) references estadio(id_estadio),
    foreign key (id_equipo1) references equipo(id_equipo),
    foreign key (id_equipo2) references equipo(id_equipo),
    foreign key (id_torneo) references torneo(id_torneo)
);

CREATE TABLE prediccion (
    id_prediccion INT PRIMARY KEY AUTO_INCREMENT,
    ganador VARCHAR(50),
    prediccion_e1 INT,
    prediccion_e2 INT,
    id_usuario INT,
    id_partido INT,
    FOREIGN KEY (id_usuario) REFERENCES usuario(id_usuario),
    FOREIGN KEY (id_partido) REFERENCES partido(id_partido)
);