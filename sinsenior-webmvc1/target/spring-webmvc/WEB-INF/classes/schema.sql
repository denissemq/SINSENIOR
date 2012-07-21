drop table usuarios if exists;
CREATE TABLE usuarios
(
        id identity,
        tipousuario VARCHAR(45), 
        nombre VARCHAR(45),
        apellidos VARCHAR(45),
        sexo VARCHAR(45),
        tipodocumento VARCHAR(45),
        numerodocumento VARCHAR(45),
        correo VARCHAR(45),
        password VARCHAR(45),
        fechaNacimiento VARCHAR(45),
        numerocelular VARCHAR(45)
);
drop table canchas if exists;
CREATE TABLE canchas
(
        id identity,
        nombre VARCHAR(45),
        caracteristica VARCHAR(45),
        fechaatencion VARCHAR(45),
        tarifa VARCHAR(45),
        promocion VARCHAR(45)
);
drop table locales if exists;
CREATE TABLE locales
(
        id identity,
        nombre VARCHAR(45),
        direccion VARCHAR(45),
        distrito VARCHAR(45),
        direcciongooglemaps VARCHAR(45),
        telefono VARCHAR(45)
);
drop table servicios if exists;
CREATE TABLE servicios
(
         id identity,
        tiposervicio VARCHAR(45),
        descripcion VARCHAR(45),
        tarifa VARCHAR(45)
);
drop table eventos if exists;
CREATE TABLE eventos
(
        id identity,
        nombre VARCHAR(45),
        premio VARCHAR(45),
        cantidad VARCHAR(45),
        plazo VARCHAR(45)
);
drop table publicidades if exists;
CREATE TABLE publicidades
(
        id identity,
        titulo VARCHAR(45),
        contenido VARCHAR(45),
        fechainicio VARCHAR(45),
        fechafinal VARCHAR(45),
        tarifa VARCHAR(45),
        clicks VARCHAR(45),
        ubicacion VARCHAR(45)
);
drop table comentarios if exists;
CREATE TABLE comentarios
(
        id identity,
        nombre VARCHAR(45),
        caracteristica VARCHAR(45),
        fechaatencion VARCHAR(45),
        tarifa VARCHAR(45),
        promocion VARCHAR(45),
        texto VARCHAR(45),
        calificacion VARCHAR(45)
);

