
-- city table to store city information
CREATE TABLE CITY (
    id INT AUTO_INCREMENT PRIMARY KEY,
    name VARCHAR(50) NOT NULL,
    pincode INT NOT NULL,
    active BOOLEAN DEFAULT TRUE,
    created_time timestamp DEFAULT CURRENT_TIMESTAMP,
    modified_time timestamp
);

CREATE TABLE THEATER (
    id INT AUTO_INCREMENT PRIMARY KEY,
    name VARCHAR(100) NOT NULL,
    address VARCHAR(1000) NOT NULL,
    city_id INT NOT NULL,
    active BOOLEAN DEFAULT TRUE,
    created_time timestamp DEFAULT CURRENT_TIMESTAMP,
    modified_time timestamp,
    CONSTRAINT fk_city_id FOREIGN KEY(city_id) REFERENCES CITY(id)
);

CREATE TABLE MOVIE (
    id INT AUTO_INCREMENT PRIMARY KEY,
    title VARCHAR(100) NOT NULL,
    description VARCHAR(1000) NOT NULL,
    duration TIME NOT NULL,
    movie_languages VARCHAR(1000) NOT NULL,
    release_date DATE NOT NULL,
    dimension VARCHAR(5) NOT NULL,
    active BOOLEAN DEFAULT TRUE,
    created_time timestamp DEFAULT CURRENT_TIMESTAMP,
    modified_time timestamp
);

CREATE TABLE MOVIE_THEATER (
    id INT AUTO_INCREMENT PRIMARY KEY,
    movie_id INT NOT NULL,
    theater_id INT NOT NULL,
    active BOOLEAN DEFAULT TRUE,
    created_time timestamp DEFAULT CURRENT_TIMESTAMP,
    modified_time timestamp,
    CONSTRAINT fk_movie_theater_id FOREIGN KEY(theater_id) REFERENCES THEATER(id),
    CONSTRAINT fk_movie_id FOREIGN KEY(movie_id) REFERENCES MOVIE(id)
);

CREATE TABLE SHOW_TIMING (
    id INT AUTO_INCREMENT PRIMARY KEY,
    show_time TIME NOT NULL,
    active BOOLEAN DEFAULT TRUE,
    created_time timestamp DEFAULT CURRENT_TIMESTAMP,
    modified_time timestamp
);

CREATE TABLE THEATER_SHOW_TIMING (
    id INT AUTO_INCREMENT PRIMARY KEY,
    theater_id INT NOT NULL,
    show_timing_id INT NOT NULL,
    show_date DATE NOT NULL,
    active BOOLEAN DEFAULT TRUE,
    created_time timestamp DEFAULT CURRENT_TIMESTAMP,
    modified_time timestamp,
    CONSTRAINT fk_theater_id FOREIGN KEY(theater_id) REFERENCES THEATER(id),
    CONSTRAINT fk_show_timing_id FOREIGN KEY(show_timing_id) REFERENCES SHOW_TIMING(id)
);

CREATE TABLE THEATER_SEAT (
    id INT AUTO_INCREMENT PRIMARY KEY,
    seat_row VARCHAR(2) NOT NULL,
    seat_col INT NOT NULL,
    seat_type ENUM ('REGULAR', 'ECONOMY', 'ACCESSIBLE'),
    theater_id INT NOT NULL,
    price NUMERIC(10, 2) NOT NULL,
    active BOOLEAN DEFAULT TRUE,
    created_time timestamp DEFAULT CURRENT_TIMESTAMP,
    modified_time timestamp,
    CONSTRAINT fk_seat_theater_id FOREIGN KEY(theater_id) REFERENCES THEATER(id)
);

CREATE TABLE BOOKING (
    id INT AUTO_INCREMENT,
    booking_number VARCHAR(20) NOT NULL PRIMARY KEY,
    no_of_seats INT NOT NULL,
    status ENUM ('REQUESTED', 'IN_PROGRESS', 'CONFIRMED', 'CANCELLED'),
    theater_id INT NOT NULL,
    show_time TIME NOT NULL,
    show_date DATE NOT NULL,
    active BOOLEAN DEFAULT TRUE,
    created_time timestamp DEFAULT CURRENT_TIMESTAMP,
    modified_time timestamp,
    CONSTRAINT fk_booking_theater_id FOREIGN KEY(theater_id) REFERENCES THEATER(id)
);

CREATE TABLE BOOKING_SEAT (
    id INT AUTO_INCREMENT PRIMARY KEY,
    booking_number VARCHAR(20) NOT NULL,
    theater_seat_id INT NOT NULL,
    active BOOLEAN DEFAULT TRUE,
    created_time timestamp DEFAULT CURRENT_TIMESTAMP,
    modified_time timestamp,
    CONSTRAINT fk_booking_id FOREIGN KEY(booking_number) REFERENCES BOOKING(booking_number),
    CONSTRAINT fk_theater_seat_id FOREIGN KEY(theater_seat_id) REFERENCES THEATER_SEAT(id)
);

CREATE TABLE DISCOUNT (
    id INT AUTO_INCREMENT PRIMARY KEY,
    city_id VARCHAR(20) NOT NULL,
    theater_id INT NOT NULL,
    discount_type ENUM ('FIFTY_PERCENT', 'TWENTY_PERCENT'),
    active BOOLEAN DEFAULT TRUE,
    created_time timestamp DEFAULT CURRENT_TIMESTAMP,
    modified_time timestamp,
    CONSTRAINT fk_discount_city_id FOREIGN KEY(city_id) REFERENCES CITY(id),
    CONSTRAINT fk_discount_theater_id FOREIGN KEY(theater_id) REFERENCES THEATER(id)
);