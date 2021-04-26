/* Creamos algunos usuarios con sus roles */
INSERT INTO usuario (username, password, nombre, apellido, email, enabled) VALUES ('cristian','$2a$10$h.Hy6T1NNyCT6C75MnGI4Oi108/Gu7.2B3jYTdMjoTArhNvRf5xQi', 'Cristian', 'Marambio','cristianmarambio17@gmail.com', true);
INSERT INTO usuario (username, password, nombre, apellido, email, enabled) VALUES ('admin','$2a$10$Rd2s.3rXUC9FCrJVGViA2eB4aARdb7rcn4msIGcK6BzDKUVLAC3Ui', 'Admin', 'Administrador','admin@gmail.com', true);
INSERT INTO usuario (username, password, nombre, apellido, email, enabled) VALUES ('daniel','$2a$10$zhkp7/P3IiaoLH0F4P/IkuvoIZ5G4NaSiBnCOPEFKWuMo46R4Odyi', 'Daniel', 'Marambio','daniel.marambio@gmail.com', true);
INSERT INTO usuario (username, password, nombre, apellido, email, enabled) VALUES ('tania','$2a$10$sB/8i8n1RWoME9842JbiH.a/hyREuAR4KvIEQRtsZ5rXaO2EEX48y', 'Tania', 'heresi','tania_smg@gmail.com', true);
INSERT INTO usuario (username, password, nombre, apellido, email, enabled) VALUES ('juan','$2a$10$ZNhyifLid4Eqs2eZSa0nKOsRaIbMHfS.N4EZ7jICH21aSYz30UsRG', 'Juan', 'Marambio','juancarlosconfecciones@gmail.com', true);
INSERT INTO usuario (username, password, nombre, apellido, email, enabled) VALUES ('gatuso','$2a$10$YHoTFv10wJJ.84VPH0/3yeu2l2B20phTHajJXhMDUysR4xr.Pp9Wq', 'Gaston', 'Gatuso','gastongatuso@gmail.com', true);

INSERT INTO rol (nombre) VALUES ('ROLE_USER');
INSERT INTO rol (nombre) VALUES ('ROLE_ADMIN');
INSERT INTO rol (nombre) VALUES ('ROLE_CREATOR');
INSERT INTO rol (nombre) VALUES ('ROLE_EDITOR');

INSERT INTO usuario_rol (id_usuario, id_rol) VALUES (1, 1);
INSERT INTO usuario_rol (id_usuario, id_rol) VALUES (2, 2);
INSERT INTO usuario_rol (id_usuario, id_rol) VALUES (2, 1);
INSERT INTO usuario_rol (id_usuario, id_rol) VALUES (3, 1);
INSERT INTO usuario_rol (id_usuario, id_rol) VALUES (3, 2);
INSERT INTO usuario_rol (id_usuario, id_rol) VALUES (3, 3);
INSERT INTO usuario_rol (id_usuario, id_rol) VALUES (4, 1);
INSERT INTO usuario_rol (id_usuario, id_rol) VALUES (4, 2);
INSERT INTO usuario_rol (id_usuario, id_rol) VALUES (4, 4);
INSERT INTO usuario_rol (id_usuario, id_rol) VALUES (5, 3);
INSERT INTO usuario_rol (id_usuario, id_rol) VALUES (5, 4);
INSERT INTO usuario_rol (id_usuario, id_rol) VALUES (6, 4);

INSERT INTO skill (nombre, descripcion) VALUES ('Java','Java');
INSERT INTO skill (nombre, descripcion) VALUES ('C#','C#');
INSERT INTO skill (nombre, descripcion) VALUES ('.Net','.Net');
INSERT INTO skill (nombre, descripcion) VALUES ('NodeJS','NodeJS');
INSERT INTO skill (nombre, descripcion) VALUES ('SQL','SQL');
INSERT INTO skill (nombre, descripcion) VALUES ('Mongo','Mongo');
INSERT INTO skill (nombre, descripcion) VALUES ('Oracle','Oracle');
INSERT INTO skill (nombre, descripcion) VALUES ('Microsoft','Microsoft');
INSERT INTO skill (nombre, descripcion) VALUES ('Javascript','Javascript');
INSERT INTO skill (nombre, descripcion) VALUES ('Python','Python');

INSERT INTO perfil (nombre, nivel, enabled) VALUES ('Desarrollador Java', 1, true);
INSERT INTO perfil (nombre, nivel, enabled) VALUES ('Desarrollador .Net', 2, true);
INSERT INTO perfil (nombre, nivel, enabled) VALUES ('Arquitecto', 2, true);
INSERT INTO perfil (nombre, nivel, enabled) VALUES ('Jefe de Proyecto', 1, true);

INSERT INTO perfil_skill (id_perfil, id_skill) VALUES (1, 1);
INSERT INTO perfil_skill (id_perfil, id_skill) VALUES (2, 2);
INSERT INTO perfil_skill (id_perfil, id_skill) VALUES (3, 6);
INSERT INTO perfil_skill (id_perfil, id_skill) VALUES (4, 5);
INSERT INTO perfil_skill (id_perfil, id_skill) VALUES (1, 5);
INSERT INTO perfil_skill (id_perfil, id_skill) VALUES (2, 3);
INSERT INTO perfil_skill (id_perfil, id_skill) VALUES (3, 8);
INSERT INTO perfil_skill (id_perfil, id_skill) VALUES (4, 8);
INSERT INTO perfil_skill (id_perfil, id_skill) VALUES (1, 7);
INSERT INTO perfil_skill (id_perfil, id_skill) VALUES (2, 5);
INSERT INTO perfil_skill (id_perfil, id_skill) VALUES (3, 4);

INSERT INTO proyecto (nombre, fecha_inicio, fecha_termino) VALUES ('COPEC', '2020-05-17', '2020-09-11');
INSERT INTO proyecto (nombre, fecha_inicio, fecha_termino) VALUES ('CGR', '2020-06-17', '2020-10-01');
INSERT INTO proyecto (nombre, fecha_inicio, fecha_termino) VALUES ('HOMECENTER', '2020-07-17', '2020-11-03');
INSERT INTO proyecto (nombre, fecha_inicio, fecha_termino) VALUES ('WALMART', '2020-08-17', '2020-12-30');

INSERT INTO empleado (apellidom, apellidop, email, enabled, fecha_nacimiento, nombre, sexo, id_proyecto) VALUES ('pirul', 'marambio', 'cristian@gmail.com', true, '1992-05-17', 'Cristian', 1, 1);
INSERT INTO empleado (apellidom, apellidop, email, enabled, fecha_nacimiento, nombre, sexo, id_proyecto) VALUES ('soto', 'lara', 'victor@gmail.com', true, '1990-12-18', 'Victor', 1, 1);
INSERT INTO empleado (apellidom, apellidop, email, enabled, fecha_nacimiento, nombre, sexo, id_proyecto) VALUES ('armani', 'muñoz', 'alberto@gmail.com', true, '1980-01-03', 'Alberto', 1, 1);
INSERT INTO empleado (apellidom, apellidop, email, enabled, fecha_nacimiento, nombre, sexo, id_proyecto) VALUES ('grey', 'rojas', 'lorena@gmail.com', true, '1985-06-10', 'Lorena', 0, 1);

INSERT INTO perfil_empleado (id_perfil, id_empleado) VALUES (1, 1);
INSERT INTO perfil_empleado (id_perfil, id_empleado) VALUES (2, 2);
INSERT INTO perfil_empleado (id_perfil, id_empleado) VALUES (3, 3);
INSERT INTO perfil_empleado (id_perfil, id_empleado) VALUES (4, 4);
INSERT INTO perfil_empleado (id_perfil, id_empleado) VALUES (1, 4);
INSERT INTO perfil_empleado (id_perfil, id_empleado) VALUES (2, 3);
INSERT INTO perfil_empleado (id_perfil, id_empleado) VALUES (3, 2);

