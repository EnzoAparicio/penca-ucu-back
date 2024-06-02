INSERT INTO usuario (email, contrasenia, nombre, apellido, avatar_path, id_carrera, puntos) VALUES
 ('luisa.perez@email.com', 'contrasenia123', 'Luisa', 'Perez', 'avatar_luisa.png', 1, 500),
('juan.rodriguez@email.com', 'juanitoR78', 'Juan', 'Rodriguez', 'avatar_juan.png', 2, 300),
('maria.gonzalez@email.com', 'mariagonzalez', 'Maria', 'Gonzalez', 'avatar_maria.png', 3, 700),
('carlos.fernandez@email.com', 'carlosF2024', 'Carlos', 'Fernandez', 'avatar_carlos.png', 4, 600),
('ana.martinez@email.com', 'anaMtz89', 'Ana', 'Martinez', 'avatar_ana.png', 5, 800),
('jose.gutierrez@email.com', 'joseGtz', 'Jose', 'Gutierrez', 'avatar_jose.png', 6, 400),
('sofia.ramirez@email.com', 'sofiaramirez', 'Sofia', 'Ramirez', 'avatar_sofia.png', 7, 900),
('daniel.torres@email.com', 'danieltorres', 'Daniel', 'Torres', 'avatar_daniel.png', 8, 200),
('laura.lopez@email.com', 'lauralopez', 'Laura', 'Lopez', 'avatar_laura.png', 9, 1000),
('pedro.sanchez@email.com', 'pedrosanchez', 'Pedro', 'Sanchez', 'avatar_pedro.png', 10, 100);


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
('Real Madrid', 'bandera_real_madrid.png', '#FFFFFF'),
('Barcelona', 'bandera_barcelona.png', '#073597'),
('Manchester United', 'bandera_manchester_united.png', '#FF0000'),
('Liverpool', 'bandera_liverpool.png', '#FF0000'),
('Bayern Munich', 'bandera_bayern_munich.png', '#FF0000'),
('Juventus', 'bandera_juventus.png', '#FFFFFF'),
('Paris Saint-Germain', 'bandera_psg.png', '#035690'),
('Chelsea', 'bandera_chelsea.png', '#0064DC'),
('Manchester City', 'bandera_manchester_city.png', '#49A4FA'),
('Atletico Madrid', 'bandera_atletico_madrid.png', '#C90033');

INSERT INTO partido (fecha, id_estadio, id_torneo) 
VALUES 
('2024-06-12', 1, 9),
('2024-06-13', 2, 9),
('2024-06-14', 3, 9),
('2024-06-15', 4, 9),
('2024-06-16', 5, 9);
