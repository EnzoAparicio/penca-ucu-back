CREATE DATABASE PENCAUCU;

USE PENCAUCU;

-- Enum
CREATE TABLE carrera (
    id_carrera INT AUTO_INCREMENT PRIMARY KEY,
    nombre VARCHAR(50),
    anios VARCHAR(30)
);

CREATE TABLE torneo (
    id_torneo INT AUTO_INCREMENT PRIMARY KEY,
    nombre VARCHAR(50),
    anio VARCHAR(30)
);

CREATE TABLE equipo (
    id_equipo INT AUTO_INCREMENT PRIMARY KEY,
    nombre VARCHAR(50),
    img_bandera VARCHAR(255),
    color VARCHAR(50)
);

CREATE TABLE usuario (
    id_usuario INT AUTO_INCREMENT PRIMARY KEY,
    nombre VARCHAR(50) NOT NULL,
    apellido VARCHAR(50),
    email VARCHAR(100) NOT NULL,
    contrasenia VARCHAR(255) NOT NULL,
    id_carrera INT,
    puntos INT,
    avatar_path VARCHAR(50),
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

CREATE TABLE partido (
    id_partido INT AUTO_INCREMENT PRIMARY KEY,
    fecha DATE,
    estadio VARCHAR(100),
    id_equipo1 INT,
    id_equipo2 INT,
    resultado_equipo1 INT,
    resultado_equipo2 INT,
    ganador VARCHAR(50),
    id_torneo INT,
    FOREIGN KEY (id_equipo1) REFERENCES equipo(id_equipo),
    FOREIGN KEY (id_equipo2) REFERENCES equipo(id_equipo),
    FOREIGN KEY (id_torneo) REFERENCES torneo(id_torneo)
);

CREATE TABLE prediccion (
    id_prediccion INT PRIMARY KEY AUTO_INCREMENT,
    ganador VARCHAR(50),
    prediccion_e1 VARCHAR(50),
    prediccion_e2 VARCHAR(50),
    id_usuario INT,
    id_partido INT,
    FOREIGN KEY (id_usuario) REFERENCES usuario(id_usuario),
    FOREIGN KEY (id_partido) REFERENCES partido(id_partido)
);