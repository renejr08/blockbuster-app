-- Proyecto 2
-- Nombre: René Sánchez Torres
-- Carnet: 2020051805

-- Creación de esquema

create database blockbuster;

use blockbuster;

-- Creación de Tablas Cliente, película y préstamo

create table cliente(
cedula int primary key,
nombre varchar(50),
apellido varchar(50),
direccion varchar(50),
numero_telefono int
);

create table pelicula(
codigo_pelicula int primary key,
titulo_pelicula varchar(50),
categoria varchar(30)
);

create table prestamo(
codigo_prestamo int primary key,
cedula_cliente int,
codigo_pelicula_alquilada int,
fecha_prestamo date,
fecha_devolucion date,
estado varchar(1),
constraint cedula_fk foreign key(cedula_cliente) references cliente(cedula),
constraint codigo_pelicula_fk foreign key(codigo_pelicula_alquilada) references pelicula(codigo_pelicula)
);

create table categoria(
codigo_categoria int,
nombre_categoria varchar(20)
);

alter table pelicula
modify column titulo_pelicula varchar(50) primary key;

alter table pelicula 
add fecha_lanzamiento date;
 
CALL add_cliente(1,'Rene','Sanchez','Grecia',70455803);    
CALL actualizar_cliente(1,'Luke','Skywalker','Alajuela',70455804);
CALL eliminar_cliente(1);
CALL select_cliente(1); 

-- Procedimientos CRUDs
DELIMITER //
CREATE PROCEDURE add_prestamo( -- Añade prestamo
	IN _codigo_prestamo int,
    IN _cedula_cliente int,
    IN _codigo_pelicula_alquilada int,
    IN _fecha_prestamo date,
	IN _fecha_devolución int,
    IN _estado varchar(1)
)
BEGIN 
	INSERT INTO prestamo (codigo_prestamo,cedula_cliente,codigo_pelicula_alquilada,fecha_prestamo,fecha_devolucion,estado) 
    VALUES (_codigo_prestamo,_cedula_cliente,_codigo_pelicula_alquilada,_fecha_prestamo,_fecha_devolución,_estado);
    END
//

DELIMITER //
CREATE PROCEDURE actualizar_prestamo( -- Actualiza prestamo
	IN _codigo_prestamo int,
    IN _cedula_cliente int,
    IN _codigo_pelicula_alquilada int,
    IN _fecha_prestamo date,
	IN _fecha_devolución int,
    IN _estado varchar(1)
)
BEGIN
UPDATE prestamo
SET codigo_prestamo = _codigo_prestamo, 
cedula_cliente = cedula_cliente,
codigo_pelicula_alquilada = _codigo_pelicula_alquilada,
fecha_prestamo = _fecha_prestamo,
fecha_devolución = _fecha_devolución,
estado = _estado
WHERE codigo_prestamo = _codigo_prestamo;
END
//

DELIMITER //
CREATE PROCEDURE eliminar_prestamo( -- Elimina prestamo
	IN _codigo_prestamo int
)
BEGIN
DELETE FROM prestamo WHERE codigo_prestamo = _codigo_prestamo;
END 
//

DELIMITER //
CREATE PROCEDURE select_prestamo( -- Selecciona prestamo 
IN _codigo_prestamo int
)
BEGIN
SELECT * FROM prestamo 
WHERE codigo_prestamo = _codigo_prestamo;
END
//

DELIMITER //
CREATE PROCEDURE add_categoria( -- Añade a categoria
	IN _codigo_categoria int,
    IN _nombre_categoria varchar(20)
)
BEGIN 
	INSERT INTO categoria (codigo_categoria,nombre_categoria) 
    VALUES (_codigo_categoria,_nombre_categoria);
    END
    //
    
DELIMITER //
CREATE PROCEDURE actualizar_categoria( -- Actualiza categoria
	IN _codigo_categoria int,
    IN _nombre_categoria varchar(20)
)
BEGIN
UPDATE categoria
SET codigo_categoria = _codigo_categoria∫, 
nombre_categoria = _nombre_categoria
WHERE codigo_categoria = _codigo_categoria;
END
//

DELIMITER //
CREATE PROCEDURE eliminar_categoria( -- Elimina prestamo
	IN _codigo_categoria int
)
BEGIN
DELETE FROM categoria WHERE codigo_categoria = _codigo_categoria;
END 
//

DELIMITER //
CREATE PROCEDURE select_categoria( -- Selecciona prestamo 
IN _codigo_categoria int
)
BEGIN
SELECT * FROM categoria 
WHERE codigo_categoria = _codigo_categoria;
END
//
