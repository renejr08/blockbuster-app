drop table if exists prestamo;
drop table if exists cliente;
drop table if exists pelicula;


create table cliente (
     cedula int primary key auto_increment,
     nombre varchar(50) not null,
     apellido varchar(50) not null,
     telefono_celular varchar(15),
     direccion varchar(200)
);

create table pelicula (
    codigo int primary key auto_increment,
    titulo varchar(100) not null,
    fecha_lanzamiento timestamp not null,
    categoria varchar(50) not null
);

create table prestamo (
    cedula int not null,
    pelicula_codigo int not null,
    fecha_prestamo timestamp not null,
    fecha_devolucion timestamp not null,
    estado enum ('A', 'I'),
    constraint pelicula_id_fk foreign key (pelicula_codigo) references pelicula (codigo),
    constraint cliente_ced_fk foreign key (cedula) references cliente(cedula)
);


insert into pelicula(titulo, fecha_lanzamiento, categoria) values ('James Bond 007', now(), 'Accion');
insert into pelicula(titulo, fecha_lanzamiento, categoria) values ('Matrix', now(), 'Ciencia Ficcion');
insert into pelicula(titulo, fecha_lanzamiento, categoria) values ('Avatar', now(), 'Accion');
insert into pelicula(titulo, fecha_lanzamiento, categoria) values ('Spider Man', now(), 'Accion');