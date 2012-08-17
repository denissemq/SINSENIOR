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
drop table inmuebles if exists;
CREATE TABLE inmuebles
(
        codigo identity,
        tipoInmueble INT,
        area DECIMAL(16,2),
        distrito INT,
        direccion VARCHAR(500),
        nroHab int,
        nroBanos int,
        hPatio BOOLEAN,
        hJardin BOOLEAN,
        observaciones varchar(500)
);
drop table persona if exists;
CREATE TABLE persona
(
        codigo identity,
        tipoPersona int,
        numRazSocial VARCHAR(500),
        docId VARCHAR(20),
        telefono VARCHAR(45),
        celular VARCHAR(45),
        correo VARCHAR(100)
);
drop table tipoInmueble if exists;
CREATE TABLE tipoInmueble
(
        codigo identity,
        descripcion VARCHAR(500)
);
drop table distrito if exists;
CREATE TABLE distrito
(
        codigo identity,
        descripcion VARCHAR(500)
);
drop table tipoPersona if exists;
CREATE TABLE tipoPersona
(
        codigo identity,
        descripcion VARCHAR(500)
);
drop table estado if exists;
CREATE TABLE estado
(
        codigo identity,
        descripcion VARCHAR(500)
);
drop table detalleSolicitud if exists;
CREATE TABLE detalleSolicitud
(
        codigo identity,
        codigoInmueble int,
        codigoPersona int,
        codigoUsuario int,
        codigoEstado int,
        observaciones varchar(1000),
        fecha VARCHAR(45),
        lugar varchar(300),
        activo BOOLEAN,
        credat  varchar(1000)
);

drop table preferencias if exists;
CREATE TABLE preferencias
(
        codigo identity,
        tipoInmueble INT,
        areade DECIMAL(16,2),
        areahasta DECIMAL(16,2),
        distrito INT,
        nroHabde int,
        nroHabhasta int,
        nroBanosde int,
        nroBanoshasta int,
        hPatio BOOLEAN,
        hJardin BOOLEAN,
        nombreContacto varchar(1000),
        correoElectronico varchar(1000),
        staActivo BOOLEAN
);

insert into tipoInmueble(codigo,descripcion) values(1,'CASA');
insert into tipoInmueble(codigo,descripcion)  values(2,'DEPARTAMENTO');
insert into tipoPersona(codigo,descripcion)  values(1,'NATURAL');
insert into tipoPersona(codigo,descripcion)  values(2,'JURIDICA');
insert into estado(codigo,descripcion)  values(1,'SOLICITUD COMPRA');
insert into estado(codigo,descripcion)  values(2,'SOLICITUD VENTA');
insert into estado(codigo,descripcion)  values(3,'PROGRAMADO COMPRA');
insert into estado(codigo,descripcion)  values(4,'PROGRAMADO VENTA');
insert into estado(codigo,descripcion)  values(5,'ANULADO');
insert into estado(codigo,descripcion)  values(6,'DISPONIBLE');
insert into estado(codigo,descripcion)  values(7,'COMPRADO');


insert into distrito(codigo,descripcion)  values(1,'ATE');
insert into distrito(codigo,descripcion)  values(2,'BARRANCO');
insert into distrito(codigo,descripcion)  values(3,'BELLAVISTA');
insert into distrito(codigo,descripcion)  values(4,'BREÑA');
insert into distrito(codigo,descripcion)  values(5,'CARMEN DE LA LEGUA');
insert into distrito(codigo,descripcion)  values(6,'CERCADO CALLAO');
insert into distrito(codigo,descripcion)  values(7,'CERCADO DE LIMA');
insert into distrito(codigo,descripcion)  values(8,'CHORRILLOS');
insert into distrito(codigo,descripcion)  values(9,'COMAS');
insert into distrito(codigo,descripcion)  values(10,'EL AGUSTINO');
insert into distrito(codigo,descripcion)  values(11,'INDEPENDENCIA');
insert into distrito(codigo,descripcion)  values(12,'JESÚS MARÍA');
insert into distrito(codigo,descripcion)  values(13,'LA MOLINA');
insert into distrito(codigo,descripcion)  values(14,'LA PERLA');
insert into distrito(codigo,descripcion)  values(15,'LA PUNTA');
insert into distrito(codigo,descripcion)  values(16,'LA VICTORIA');
insert into distrito(codigo,descripcion)  values(17,'LINCE');
insert into distrito(codigo,descripcion)  values(18,'LOS OLIVOS');
insert into distrito(codigo,descripcion)  values(19,'MAGDALENA DEL MAR');
insert into distrito(codigo,descripcion)  values(20,'MIRAFLORES');
insert into distrito(codigo,descripcion)  values(21,'PUEBLO LIBRE');
insert into distrito(codigo,descripcion)  values(22,'PUENTE PIEDRA');
insert into distrito(codigo,descripcion)  values(23,'RIMAC');
insert into distrito(codigo,descripcion)  values(24,'SAN BORJA');
insert into distrito(codigo,descripcion)  values(25,'SAN ISIDRO');
insert into distrito(codigo,descripcion)  values(26,'SAN JUAN DE LURIGANCHO');
insert into distrito(codigo,descripcion)  values(27,'SAN JUAN DE MIRAFLORES');
insert into distrito(codigo,descripcion)  values(28,'SAN LUIS');
insert into distrito(codigo,descripcion)  values(29,'SAN MARTIN DE PORRES');
insert into distrito(codigo,descripcion)  values(30,'SAN MIGUEL');
insert into distrito(codigo,descripcion)  values(31,'SANTA ANITA');
insert into distrito(codigo,descripcion)  values(32,'SANTA ROSA');
insert into distrito(codigo,descripcion)  values(33,'SANTIAGO DE SURCO');
insert into distrito(codigo,descripcion)  values(34,'SURQUILLO');
insert into distrito(codigo,descripcion)  values(35,'VENTANILLA');
insert into distrito(codigo,descripcion)  values(36,'VILLA EL SAVADOR');
insert into distrito(codigo,descripcion)  values(37,'VILLA MARÍA DEL TRIUNFO');

insert into inmuebles (tipoInmueble, area, distrito,direccion,nroHab,nroBanos,hPatio,hJardin,observaciones) values (
                1,2,36,'Jr. Arequipa 3866',3,4,true,false,'No hay observaciones');
        
insert into persona (tipoPersona, numRazSocial, docId,telefono,celular,correo) values (
                1,'Denisse Marquez','87551203','5722280','998928431','dmc_24x2@hotmail.com');

insert into detalleSolicitud (codigoInmueble, codigoPersona, codigoEstado,activo,credat) values (
                0,0,6,true,'20/07/2012');


insert into inmuebles (tipoInmueble, area, distrito,direccion,nroHab,nroBanos,hPatio,hJardin,observaciones) values (
                2,3,32,'Jr. Arequipa 3866',3,4,true,false,'No hay observaciones');
        
insert into persona (tipoPersona, numRazSocial, docId,telefono,celular,correo) values (
                2,'ALEXIM PERU','20268512544','5722280','998928431','dmc_24x2@hotmail.com');

insert into detalleSolicitud (codigoInmueble, codigoPersona, codigoEstado,activo,credat) values (
                1,1,1,true,'20/07/2012');




