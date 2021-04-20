/* Creamos algunos usuarios con sus roles */
INSERT INTO usuario (username, password, nombre, apellido, email, enabled) VALUES ('Cristian','123', 'Cristian', 'Marambio','cristianmarambio17@gmail.com', true);
INSERT INTO usuario (username, password, nombre, apellido, email, enabled) VALUES ('admin','123', 'Admin', 'Administrador','admin@gmail.com', true);

INSERT INTO rol (nombre) VALUES ('ROLE_USER');
INSERT INTO rol (nombre) VALUES ('ROLE_ADMIN');

INSERT INTO usuario_rol (id_usuario, id_rol) VALUES (1, 1);
INSERT INTO usuario_rol (id_usuario, id_rol) VALUES (2, 2);
INSERT INTO usuario_rol (id_usuario, id_rol) VALUES (2, 1);