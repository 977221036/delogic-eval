
/* SETUP INICIAL */


/* User Table */
CREATE TABLE users (
    id BIGINT PRIMARY KEY,
    username VARCHAR(10) NOT NULL,
	firstname VARCHAR(50) NOT NULL,
	lastname VARCHAR(50) NOT NULL,
    city VARCHAR(50) NOT NULL,
	state CHAR(2) NOT NULL,
    email VARCHAR(80) NOT NULL,
    phone VARCHAR(80) NOT NULL,
    /*preference flags: */
    sports BOOLEAN NULL default 0,
    theatre BOOLEAN NULL default 0, 
    concerts BOOLEAN NULL default 0, 
    jazz BOOLEAN NULL default 0,
    classical BOOLEAN NULL default 0, 
    opera BOOLEAN NULL default 0, 
    rock BOOLEAN NULL default 0, 
    vegas BOOLEAN NULL default 0, 
    broadway BOOLEAN NULL default 0, 
    musicals BOOLEAN NULL default 0
);	
	
/* Venue Table */	
CREATE TABLE venues ( 
    id BIGINT PRIMARY KEY,
    name VARCHAR(50) NOT NULL,
	city VARCHAR(80) NOT NULL,
    state CHAR(2) NOT NULL,
    seating_capacity INT default 0
);	

/* Categories Table */
CREATE TABLE categories (
    id BIGINT PRIMARY KEY,
    group_name VARCHAR(20) NOT NULL,
    name VARCHAR(20) NOT NULL,
    description VARCHAR(100) NOT NULL
);

/* Dates Table */
CREATE TABLE dates (
	id BIGINT PRIMARY KEY,
    date DATE NOT NULL,  
    day  CHAR(2) NOT NULL,
    week INT NOT NULL, 
    month CHAR(3) NOT NULL,
    quarter INT NOT NULL, 
    year INT NOT NULL,    
    holiday BOOLEAN NULL default 0	
);

/* Events Table */
CREATE TABLE events (
	id BIGINT PRIMARY KEY,
    venue_id BIGINT NOT NULL,
    category_id BIGINT NOT NULL,
    date_id BIGINT NOT NULL,
    name VARCHAR(255) NOT NULL,
    event_start timestamp
);

ALTER TABLE events
ADD FOREIGN KEY (venue_id) REFERENCES venues(id);

ALTER TABLE events
ADD FOREIGN KEY (category_id) REFERENCES categories(id);

ALTER TABLE events
ADD FOREIGN KEY (date_id) REFERENCES dates(id);


/* Listings Table */
CREATE TABLE listings (
	id BIGINT PRIMARY KEY,
    seller_id BIGINT NOT NULL,
    event_id BIGINT NOT NULL,
    date_id BIGINT NOT NULL,
    number_of_tickets INT NOT NULL,
    price_per_ticket DECIMAL(10,2) NOT NULL,
    total_price DECIMAL(10,2) NOT NULL,
    listing_time timestamp
    
); 

ALTER TABLE listings
ADD FOREIGN KEY (seller_id) REFERENCES users(id);

ALTER TABLE listings
ADD FOREIGN KEY (event_id) REFERENCES events(id);

ALTER TABLE listings
ADD FOREIGN KEY (date_id) REFERENCES dates(id);


/* Sales Table */
CREATE TABLE sales (
	id BIGINT PRIMARY KEY,
    listing_id BIGINT NOT NULL,
    seller_id BIGINT NOT NULL,
    buyer_id BIGINT NOT NULL,
    event_id BIGINT NOT NULL,    
    date_id BIGINT NOT NULL,
    quantity_sold INT NOT NULL,
    price_paid DECIMAL(10,2) NOT NULL,
    commission_amount DECIMAL(10,2) NOT NULL,
    sale_time timestamp    
); 


ALTER TABLE sales
ADD FOREIGN KEY (listing_id) REFERENCES listings(id);

ALTER TABLE sales
ADD FOREIGN KEY (seller_id) REFERENCES users(id);

ALTER TABLE sales
ADD FOREIGN KEY (event_id) REFERENCES events(id);

ALTER TABLE sales
ADD FOREIGN KEY (buyer_id) REFERENCES users(id);

ALTER TABLE sales
ADD FOREIGN KEY (date_id) REFERENCES dates(id);





