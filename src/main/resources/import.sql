/* Creamos algunos usuarios con sus roles */
INSERT INTO usuario (username, password, nombre, apellido, email, enabled) VALUES ('Cristian','$2a$10$h.Hy6T1NNyCT6C75MnGI4Oi108/Gu7.2B3jYTdMjoTArhNvRf5xQi', 'Cristian', 'Marambio','cristianmarambio17@gmail.com', true);
INSERT INTO usuario (username, password, nombre, apellido, email, enabled) VALUES ('admin','$2a$10$Rd2s.3rXUC9FCrJVGViA2eB4aARdb7rcn4msIGcK6BzDKUVLAC3Ui', 'Admin', 'Administrador','admin@gmail.com', true);

INSERT INTO rol (nombre) VALUES ('ROLE_USER');
INSERT INTO rol (nombre) VALUES ('ROLE_ADMIN');

INSERT INTO usuario_rol (id_usuario, id_rol) VALUES (1, 1);
INSERT INTO usuario_rol (id_usuario, id_rol) VALUES (2, 2);
INSERT INTO usuario_rol (id_usuario, id_rol) VALUES (2, 1);