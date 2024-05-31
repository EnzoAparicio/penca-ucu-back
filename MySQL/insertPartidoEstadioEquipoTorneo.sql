use pencaucudb;

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


