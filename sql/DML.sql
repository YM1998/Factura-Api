
INSERT INTO attribute VALUES (1, 'Talla');
INSERT INTO attribute VALUES (2, 'Color');



INSERT INTO payment_type VALUES (1, 'Efectivo');
INSERT INTO payment_type VALUES (2, 'Tarjeta Debito');
INSERT INTO payment_type VALUES (3, 'Tarjeta Credito');
INSERT INTO payment_type VALUES (4, 'Transferencia Nequi');
INSERT INTO payment_type VALUES (5, 'Transferencia Bancolombia');
INSERT INTO payment_type VALUES (6, 'Transferencia Daviplata');


INSERT INTO roles VALUES (1, 'ROLE_ADMIN');
INSERT INTO roles VALUES (2, 'ROLE_SELLER');

insert into selling_points (id, name) values (1,'Nicky Estilo - Almacen 1 ');
insert into selling_points (id, name) values (2,'Nicky Estilo - Almacen 2 ');

insert into state (id, name) values (1,'ACTIVO');
insert into state (id, name) values (2,'INACTIVO');

INSERT INTO type_movement_stock VALUES (1, 'Entrada');
INSERT INTO type_movement_stock VALUES (2, 'Salida');
INSERT INTO type_movement_stock VALUES (3, 'Actualizacion');
INSERT INTO type_movement_stock VALUES (4, 'Factura Venta');

	
insert into category (id, create_at, creation_user, name, update_date, state_id) values(1,CURDATE(), 'admin', 'Jeans',CURDATE(), 1);
insert into category (id, create_at, creation_user, name, update_date, state_id) values(2,CURDATE(), 'admin', 'Blusas',CURDATE(), 1);
insert into category (id, create_at, creation_user, name, update_date, state_id) values(3,CURDATE(), 'admin', 'Mochos',CURDATE(), 1);



INSERT INTO facturacion_db.person (name, last_name, nit, email, phone)
VALUES('Luz dary', 'segura', '6654638', 'yesidmurillogura@hotmail.com', '37666484');

INSERT INTO facturacion_db.person (name, last_name, nit, email, phone)
VALUES('Publico General', 'Publico General', 'Publico General', 'PublicoGeneral@hotmail.com', '37666484');

