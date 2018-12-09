CREATE TABLE category (

	id IDENTITY,
	name VARCHAR(50),
	description VARCHAR(50),
	image_url VARCHAR(50),
	is_active BOOLEAN,
	
	CONSTRAINT pk_category_id PRIMARY KEY(id) 
); 

INSERT INTO category (name, description,image_url,is_active) VALUES ('Laptop', 'This is description for Laptop category!', 'CAT_1.png', true);
INSERT INTO category (name, description,image_url,is_active) VALUES ('Television', 'This is description for Television category!', 'CAT_2.png', true);
INSERT INTO category (name, description,image_url,is_active) VALUES ('Mobile', 'This is description for Mobile category!', 'CAT_3.png', true);

CREATE TABLE user_detail (

	id IDENTITY,
	first_name VARCHAR(50),
	last_name VARCHAR(50),
	role VARCHAR(50),
	enabled BOOLEAN,
	password VARCHAR(50),
	email VARCHAR(100),
	contact_number VARCHAR(15),
	
	
	CONSTRAINT pk_user_id PRIMARY KEY(id) 
);  

INSERT INTO user_detail(first_name,last_name,role,enabled,password,email,contact_number)VALUES('YUVAN','YASHWANTH','SUPPLIER',true,'yapo0718','77yashwanth@gmail.com','9677069816'); 
INSERT INTO user_detail(first_name,last_name,role,enabled,password,email,contact_number)VALUES('ALPHA','AMERICAN','SUPPLIER',true,'alpha','alpha@gmail.com','9677685859'); 
INSERT INTO user_detail(first_name,last_name,role,enabled,password,email,contact_number)VALUES('BETA','BRAZIL','SUPPLIER',true,'beta','beta@gmail.com','6770691677'); 

CREATE TABLE product(
	id IDENTITY,
	code varchar(20),
	name varchar(50),
	brand varchar(50),
	description varchar(255),
	unit_price DECIMAL(10,2),
	quantity INT,
	is_active boolean,
	category_id INT,
	supplier_id INT,
	purchases INT DEFAULT 0,
	views INT DEFAULT 0,
	CONSTRAINT pk_product_id PRIMARY KEY(id),
	CONSTRAINT fk_product_category_id FOREIGN KEY (category_id) REFERENCES category(id),
	CONSTRAINT fk_product_supplier_id FOREIGN KEY (supplier_id) REFERENCES user_detail(id),
	);  
	
INSERT INTO product (code, name, brand, description, unit_price, quantity, is_active, category_id, supplier_id, purchases, views)
VALUES ('PRDDEF123DEFX', 'Samsung s7', 'SAMSUNG', 'A smart phone by samsung!', 32000, 2, true, 7, 3, 0, 0 );
INSERT INTO product (code, name, brand, description, unit_price, quantity, is_active, category_id, supplier_id, purchases, views)
VALUES ('PRDPQR123WGTX', 'Oppo Pixel', 'OPPO', 'This is one of the best android smart phone available in the market right now!', 57000, 5, true, 5, 2, 0, 0 );
INSERT INTO product (code, name, brand, description, unit_price, quantity, is_active, category_id, supplier_id, purchases, views)
VALUES ('PRDMNO123PQRX', ' Redmi note 6', 'REDMI', 'This is one of the best laptops available in the market right now!', 54000, 3, true, 3, 2, 0, 0 );
