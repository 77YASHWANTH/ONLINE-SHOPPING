CREATE TABLE category (

	id IDENTITY,
	name VARCHAR(50),
	description VARCHAR(50),
	image_url VARCHAR(50),
	is_active BOOLEAN,
	
	CONSTRAINT pk_category_id PRIMARY KEY(id) 
); 

INSERT INTO category(name,description,image_url,is_active)VALUES('OPPO','THIS IS NEW OPPO','CAT_3.png',true); 
INSERT INTO category(name,description,image_url,is_active)VALUES('SAMSUNG','THIS IS NEW SAMSUNG','CAT_4.png',true); 
INSERT INTO category(name,description,image_url,is_active)VALUES('MOTO-G','THIS IS NEW MOTO','CAT_5.png',true);