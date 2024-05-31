use pencaucudb;

create table estadio(
	id_estadio int auto_increment primary key,
    nombre varchar(50)
    );
    
CREATE TABLE equipo (
    id_equipo INT AUTO_INCREMENT PRIMARY KEY,
    nombre VARCHAR(100),
    img_bandera VARCHAR(255),
    color VARCHAR(50)
);

CREATE TABLE torneo (
    id_torneo INT PRIMARY KEY,
    nombre VARCHAR(100),
    anio VARCHAR(30)
);

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