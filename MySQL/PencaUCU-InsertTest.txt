INSERT INTO usuario (email, contrasenia, nombre, apellido, avatar_path, id_carrera, puntos) VALUES ('luisa.perez@email.com', 'contrasenia123', 'Luisa', 'Perez', 'avatar_luisa.png', 1, 500);
INSERT INTO usuario (email, contrasenia, nombre, apellido, avatar_path, id_carrera, puntos) VALUES ('juan.rodriguez@email.com', 'juanitoR78', 'Juan', 'Rodriguez', 'avatar_juan.png', 2, 300);
INSERT INTO usuario (email, contrasenia, nombre, apellido, avatar_path, id_carrera, puntos) VALUES ('maria.gonzalez@email.com', 'mariagonzalez', 'Maria', 'Gonzalez', 'avatar_maria.png', 3, 700);
INSERT INTO usuario (email, contrasenia, nombre, apellido, avatar_path, id_carrera, puntos) VALUES ('carlos.fernandez@email.com', 'carlosF2024', 'Carlos', 'Fernandez', 'avatar_carlos.png', 4, 600);
INSERT INTO usuario (email, contrasenia, nombre, apellido, avatar_path, id_carrera, puntos) VALUES ('ana.martinez@email.com', 'anaMtz89', 'Ana', 'Martinez', 'avatar_ana.png', 5, 800);
INSERT INTO usuario (email, contrasenia, nombre, apellido, avatar_path, id_carrera, puntos) VALUES ('jose.gutierrez@email.com', 'joseGtz', 'Jose', 'Gutierrez', 'avatar_jose.png', 6, 400);
INSERT INTO usuario (email, contrasenia, nombre, apellido, avatar_path, id_carrera, puntos) VALUES ('sofia.ramirez@email.com', 'sofiaramirez', 'Sofia', 'Ramirez', 'avatar_sofia.png', 7, 900);
INSERT INTO usuario (email, contrasenia, nombre, apellido, avatar_path, id_carrera, puntos) VALUES ('daniel.torres@email.com', 'danieltorres', 'Daniel', 'Torres', 'avatar_daniel.png', 8, 200);
INSERT INTO usuario (email, contrasenia, nombre, apellido, avatar_path, id_carrera, puntos) VALUES ('laura.lopez@email.com', 'lauralopez', 'Laura', 'Lopez', 'avatar_laura.png', 9, 1000);
INSERT INTO usuario (email, contrasenia, nombre, apellido, avatar_path, id_carrera, puntos) VALUES ('pedro.sanchez@email.com', 'pedrosanchez', 'Pedro', 'Sanchez', 'avatar_pedro.png', 10, 100);


INSERT INTO torneo (nombre, anio) VALUES
('Torneo Apertura', '2023'),
('Torneo Clausura', '2023'),
('Copa Libertadores', '2023'),
('Copa Sudamericana', '2023'),
('Torneo Intercontinental', '2023'),
('Liga Nacional', '2023'),
('Torneo Apertura', '2024'),
('Torneo Clausura', '2024'),
('Copa Libertadores', '2024'),
('Copa Sudamericana', '2024');

INSERT INTO equipo (nombre, img_bandera, color) VALUES
('Real Madrid', 'bandera_real_madrid.png', 'blanco'),
('Barcelona', 'bandera_barcelona.png', 'azulgrana'),
('Manchester United', 'bandera_manchester_united.png', 'rojo'),
('Liverpool', 'bandera_liverpool.png', 'rojo'),
('Bayern Munich', 'bandera_bayern_munich.png', 'rojo y blanco'),
('Juventus', 'bandera_juventus.png', 'blanco y negro'),
('Paris Saint-Germain', 'bandera_psg.png', 'azul'),
('Chelsea', 'bandera_chelsea.png', 'azul'),
('Manchester City', 'bandera_manchester_city.png', 'celeste'),
('Atletico Madrid', 'bandera_atletico_madrid.png', 'rojo y blanco');

INSERT INTO partido (resultado_e1, resultado_e2, fecha, id_estadio, id_equipo1, id_equipo2, id_torneo) 
VALUES 
(2, 1, '2024-06-12', 1, 1, 2, 1),
(0, 0, '2024-06-13', 2, 3, 4, 1),
(3, 2, '2024-06-14', 3, 5, 6, 1),
(1, 2, '2024-06-15', 4, 7, 8, 1),
(0, 3, '2024-06-16', 5, 9, 10, 1);
