/* Creamos algunos usuarios con sus roles */
INSERT INTO usuario (username, password, nombre, apellido, email, enabled) VALUES ('Cristian','$2a$10$h.Hy6T1NNyCT6C75MnGI4Oi108/Gu7.2B3jYTdMjoTArhNvRf5xQi', 'Cristian', 'Marambio','cristianmarambio17@gmail.com', true);
INSERT INTO usuario (username, password, nombre, apellido, email, enabled) VALUES ('admin','$2a$10$Rd2s.3rXUC9FCrJVGViA2eB4aARdb7rcn4msIGcK6BzDKUVLAC3Ui', 'Admin', 'Administrador','admin@gmail.com', true);

INSERT INTO rol (nombre) VALUES ('ROLE_USER');
INSERT INTO rol (nombre) VALUES ('ROLE_ADMIN');

INSERT INTO usuario_rol (id_usuario, id_rol) VALUES (1, 1);
INSERT INTO usuario_rol (id_usuario, id_rol) VALUES (2, 2);
INSERT INTO usuario_rol (id_usuario, id_rol) VALUES (2, 1);

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

INSERT INTO perfil (nombre, nivel, enabled) VALUES ('Desarrollador Java','Junior', true);
INSERT INTO perfil (nombre, nivel, enabled) VALUES ('Desarrollador .Net','Semi Senior', true);
INSERT INTO perfil (nombre, nivel, enabled) VALUES ('Arquitecto','Senior', true);
INSERT INTO perfil (nombre, nivel, enabled) VALUES ('Jefe de Proyecto','Junior', true);

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