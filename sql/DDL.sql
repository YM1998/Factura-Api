CREATE TABLE attribute (
	id INT NOT NULL,
	name VARCHAR(255) not NULL,
	 PRIMARY KEY (id)
);

CREATE TABLE payment_type (
	id INT NOT NULL,
	name varchar(150) NULL,
	 PRIMARY KEY (id)
);


CREATE TABLE person (
	id INT NOT null AUTO_INCREMENT,
	name varchar(255) NULL,
	last_name varchar(255) NULL,
	nit varchar(20) NULL,
	email varchar(255) NULL,
	phone varchar(255) NULL,
	 PRIMARY KEY (id)
);

CREATE TABLE roles (
	id INT NOT null,
	name varchar(50) not NULL,
	PRIMARY KEY (id)
);

CREATE TABLE selling_points (
	id INT NOT null,
	name varchar(50) NULL,
	PRIMARY KEY (id)
);


CREATE table state (
	id INT NOT null,
	name varchar(10) NULL,
	PRIMARY KEY (id)
);

CREATE table type_movement_stock (
	id INT NOT null,
	name varchar(50) NULL,
	 PRIMARY KEY (id)
);

CREATE TABLE category (
	id INT NOT NULL,
	creation_user varchar(255) ,
	modification_user varchar(255) ,
	name varchar(255) ,
	state_id INT NULL,
	create_at DATE,
	update_date DATE,
	PRIMARY KEY (id),
	CONSTRAINT category_state_fk FOREIGN KEY (state_id) REFERENCES state(id)
);

CREATE TABLE client (
	id INT NOT null AUTO_INCREMENT,
	person_id INT NULL,
	PRIMARY KEY (id),
	CONSTRAINT fk_client_person FOREIGN KEY (person_id) REFERENCES person(id)
);

CREATE TABLE product (
	id INT  NOT null AUTO_INCREMENT,
	code varchar(255) NULL,
	cost DECIMAL  NULL,
	created_at date NULL,
	creation_user varchar(255) NULL,
	description varchar(255) NULL,
	iva DECIMAL  NULL,
	modification_user varchar(255) NULL,
	name varchar(255) NULL,
	price DECIMAL  NULL,
	update_date date NULL,
	category_id INT NULL,
	state_id INT NULL,
	CONSTRAINT product_pkey PRIMARY KEY (id),
	CONSTRAINT fk_category_product FOREIGN KEY (category_id) REFERENCES category(id),
	CONSTRAINT fk_state_product FOREIGN KEY (state_id) REFERENCES state(id)
);


CREATE TABLE selling_points_product_stock (
	id INT  NOT null AUTO_INCREMENT,
	product_id INT NULL,
	selling_point_id INT NULL,
	stock INT NULL,
	CONSTRAINT selling_points_product_stock_pkey PRIMARY KEY (id),
	CONSTRAINT selling_points_product_stock_product_id_fkey FOREIGN KEY (product_id) REFERENCES product(id),
	CONSTRAINT selling_points_product_stock_selling_point_id_fkey FOREIGN KEY (selling_point_id) REFERENCES selling_points(id)
);
	

CREATE TABLE users (
	id INT NOT null AUTO_INCREMENT,
	person_id INT NULL,
	user_account varchar(50) NULL,
	password varchar(255) NULL,
	CONSTRAINT seller_pkey PRIMARY KEY (id),
	CONSTRAINT fk_sellert_person FOREIGN KEY (person_id) REFERENCES person(id)
);


CREATE TABLE attribute_product (
	id BIGINT NOT null AUTO_INCREMENT,
	value varchar(255) NULL,
	attribute_id INT NULL,
	product_id INT NULL,
	CONSTRAINT attribute_product_pkey PRIMARY KEY (id),
	CONSTRAINT fkmh3byg0xvw3supiufsutfx9kg FOREIGN KEY (product_id) REFERENCES product(id),
	CONSTRAINT fkn9b873lpwtfg9wyn9fioq0ck8 FOREIGN KEY (attribute_id) REFERENCES attribute(id)
);

CREATE TABLE invoice (
	id BIGINT NOT null AUTO_INCREMENT,
	cost DECIMAL NOT NULL,
	created_at date NOT NULL,
	iva DECIMAL NOT NULL,
	subtotal DECIMAL NOT NULL,
	total DECIMAL NOT NULL,
	client_id INT NOT NULL,
	user_id INT NOT NULL,
	payment_type_id INT NOT NULL,
	selling_point_id INT NOT NULL,
	CONSTRAINT invoice_pkey PRIMARY KEY (id),
	CONSTRAINT fk_invoice_client FOREIGN KEY (client_id) REFERENCES client(id),
	CONSTRAINT fk_invoice_payment_type FOREIGN KEY (payment_type_id) REFERENCES payment_type(id),
	CONSTRAINT fk_invoice_seller FOREIGN KEY (user_id) REFERENCES users(id),
	CONSTRAINT fk_selling_invoice FOREIGN KEY (selling_point_id) REFERENCES selling_points(id)
);

CREATE TABLE invoice_detail (
	id BIGINT NOT null AUTO_INCREMENT,
	amount INT NULL,
	cost DECIMAL NULL,
	iva DECIMAL NULL,
	price DECIMAL NULL,
	subtotal DECIMAL NULL,
	total DECIMAL NULL,
	invoice_id BIGINT NULL,
	product_id INT NULL,
	CONSTRAINT invoice_detail_pkey PRIMARY KEY (id),
	CONSTRAINT fkbe6c21nke5fy4m3vw00f23qsf FOREIGN KEY (product_id) REFERENCES product(id),
	CONSTRAINT fkit1rbx4thcr6gx6bm3gxub3y4 FOREIGN KEY (invoice_id) REFERENCES invoice(id)
);

CREATE TABLE movement_stock (
	id BIGINT NOT null AUTO_INCREMENT,
	type_movement_stock_id INT NULL,
	product_id INT NOT NULL,
	last_value_stock INT NULL,
	current_value INT NULL,
	reason varchar(255) NULL,
	movement_value INT NULL,
	created_at date NULL,
	selling_point_id INT NULL,
	CONSTRAINT pk_movement_stock PRIMARY KEY (id),
	CONSTRAINT movement_stock_product_id_fkey FOREIGN KEY (product_id) REFERENCES product(id),
	CONSTRAINT movement_stock_selling_point_id_fkey FOREIGN KEY (selling_point_id) REFERENCES selling_points(id),
	CONSTRAINT movement_stock_type_movement_stock_id_fkey FOREIGN KEY (type_movement_stock_id) REFERENCES type_movement_stock(id)
);

CREATE TABLE roles_user (
	id INT NOT null AUTO_INCREMENT,
	user_id INT NULL,
	rol_id INT NULL,
	CONSTRAINT roles_usuario_pkey PRIMARY KEY (id),
	CONSTRAINT roles_usuario_rol_id_fkey FOREIGN KEY (rol_id) REFERENCES roles(id),
	CONSTRAINT roles_usuario_user_id_fkey FOREIGN KEY (user_id) REFERENCES users(id)
);
