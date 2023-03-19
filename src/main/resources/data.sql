
--Insert City information
INSERT INTO CITY(name, pincode) VALUES ('Delhi', 110001);
INSERT INTO CITY(name, pincode) VALUES ('Ghaziabad', 208001);
INSERT INTO CITY(name, pincode) VALUES ('Noida', 226001);

--Insert Theater information
INSERT INTO THEATER(name, address, city_id) VALUES ('Silver City Multiplex', 'C-34 West Delhi', 1);
INSERT INTO THEATER(name, address, city_id) VALUES ('PVR VVIP', 'Noida Sec-35', 1);
INSERT INTO THEATER(name, address, city_id) VALUES ('Urvashi Theatre', 'Chaudhary More Ghaziabad', 2);
INSERT INTO THEATER(name, address, city_id) VALUES ('Wave Movie''s Theater', 'Silver City Lal Kuan', 2);
INSERT INTO THEATER(name, address, city_id) VALUES ('PVR Logix Noida', 'Logix Mall Noida', 3);

--Insert Movie information
INSERT INTO MOVIE(title, description, duration, movie_languages, release_date, dimension) VALUES ('Das Ka Dhamki', 'Drama', '02:45', 'Hindi', '2023-03-23', '2D');
INSERT INTO MOVIE(title, description, duration, movie_languages, release_date, dimension) VALUES ('The Era Of 1990', 'Action, Drama', '01:45', 'Hindi', '2024-03-24', '3D');
INSERT INTO MOVIE(title, description, duration, movie_languages, release_date, dimension) VALUES ('Agent Narasimha-117', 'Action, Drama', '02:24', 'Telugu', '2023-03-30', '2D');
INSERT INTO MOVIE(title, description, duration, movie_languages, release_date, dimension) VALUES ('Dungeons and Dragons: Honor Among Thieves', 'Action, Adventure, Fantasy', '03:15', 'English, Telugu, Tamil', '2023-03-31', '3D');

--Create theater movie mapping
INSERT INTO MOVIE_THEATER(movie_id, theater_id) VALUES (1, 2);
INSERT INTO MOVIE_THEATER(movie_id, theater_id) VALUES (1, 3);
INSERT INTO MOVIE_THEATER(movie_id, theater_id) VALUES (1, 4);
INSERT INTO MOVIE_THEATER(movie_id, theater_id) VALUES (2, 1);
INSERT INTO MOVIE_THEATER(movie_id, theater_id) VALUES (2, 2);
INSERT INTO MOVIE_THEATER(movie_id, theater_id) VALUES (2, 4);
INSERT INTO MOVIE_THEATER(movie_id, theater_id) VALUES (2, 5);
INSERT INTO MOVIE_THEATER(movie_id, theater_id) VALUES (3, 1);
INSERT INTO MOVIE_THEATER(movie_id, theater_id) VALUES (3, 2);
INSERT INTO MOVIE_THEATER(movie_id, theater_id) VALUES (3, 3);
INSERT INTO MOVIE_THEATER(movie_id, theater_id) VALUES (3, 4);
INSERT INTO MOVIE_THEATER(movie_id, theater_id) VALUES (3, 5);
INSERT INTO MOVIE_THEATER(movie_id, theater_id) VALUES (3, 5);
INSERT INTO MOVIE_THEATER(movie_id, theater_id) VALUES (4, 3);
INSERT INTO MOVIE_THEATER(movie_id, theater_id) VALUES (4, 5);

--Create default show timings
INSERT INTO SHOW_TIMING(show_time) VALUES ('12:00');
INSERT INTO SHOW_TIMING(show_time) VALUES ('12:10');
INSERT INTO SHOW_TIMING(show_time) VALUES ('12:25');
INSERT INTO SHOW_TIMING(show_time) VALUES ('13:05');
INSERT INTO SHOW_TIMING(show_time) VALUES ('15:15');
INSERT INTO SHOW_TIMING(show_time) VALUES ('19:45');
INSERT INTO SHOW_TIMING(show_time) VALUES ('20:30');

--Create theater show timings including start and end date
INSERT INTO THEATER_SHOW_TIMING(theater_id, show_timing_id, show_date) VALUES (1, 1, '2023-03-23');
INSERT INTO THEATER_SHOW_TIMING(theater_id, show_timing_id, show_date) VALUES (1, 4, '2023-03-23');
INSERT INTO THEATER_SHOW_TIMING(theater_id, show_timing_id, show_date) VALUES (1, 7, '2023-03-23');
INSERT INTO THEATER_SHOW_TIMING(theater_id, show_timing_id, show_date) VALUES (2, 2, '2023-03-23');
INSERT INTO THEATER_SHOW_TIMING(theater_id, show_timing_id, show_date) VALUES (2, 6, '2023-03-23');
INSERT INTO THEATER_SHOW_TIMING(theater_id, show_timing_id, show_date) VALUES (3, 3, '2023-03-25');
INSERT INTO THEATER_SHOW_TIMING(theater_id, show_timing_id, show_date) VALUES (4, 4, '2023-03-25');
INSERT INTO THEATER_SHOW_TIMING(theater_id, show_timing_id, show_date) VALUES (4, 6, '2023-03-25');
INSERT INTO THEATER_SHOW_TIMING(theater_id, show_timing_id, show_date) VALUES (5, 5, '2023-03-29');
INSERT INTO THEATER_SHOW_TIMING(theater_id, show_timing_id, show_date) VALUES (5, 7, '2023-03-29');
INSERT INTO THEATER_SHOW_TIMING(theater_id, show_timing_id, show_date) VALUES (1, 1, '2023-03-31');
INSERT INTO THEATER_SHOW_TIMING(theater_id, show_timing_id, show_date) VALUES (1, 4, '2023-03-31');
INSERT INTO THEATER_SHOW_TIMING(theater_id, show_timing_id, show_date) VALUES (1, 7, '2023-03-27');
INSERT INTO THEATER_SHOW_TIMING(theater_id, show_timing_id, show_date) VALUES (2, 2, '2023-04-02');
INSERT INTO THEATER_SHOW_TIMING(theater_id, show_timing_id, show_date) VALUES (2, 6, '2023-04-09');
INSERT INTO THEATER_SHOW_TIMING(theater_id, show_timing_id, show_date) VALUES (3, 3, '2023-04-02');
INSERT INTO THEATER_SHOW_TIMING(theater_id, show_timing_id, show_date) VALUES (4, 4, '2023-04-07');
INSERT INTO THEATER_SHOW_TIMING(theater_id, show_timing_id, show_date) VALUES (4, 6, '2023-04-07');
INSERT INTO THEATER_SHOW_TIMING(theater_id, show_timing_id, show_date) VALUES (5, 5, '2023-04-07');
INSERT INTO THEATER_SHOW_TIMING(theater_id, show_timing_id, show_date) VALUES (5, 7, '2023-04-07');


--Insert theater seats
INSERT INTO THEATER_SEAT(seat_row, seat_col, seat_type, theater_id, price) VALUES ('A', 1, 'REGULAR', 1, 200.00);
INSERT INTO THEATER_SEAT(seat_row, seat_col, seat_type, theater_id, price) VALUES ('A', 2, 'REGULAR', 1, 200.00);
INSERT INTO THEATER_SEAT(seat_row, seat_col, seat_type, theater_id, price) VALUES ('A', 3, 'REGULAR', 1, 200.00);
INSERT INTO THEATER_SEAT(seat_row, seat_col, seat_type, theater_id, price) VALUES ('B', 5, 'ECONOMY', 2, 250.00);
INSERT INTO THEATER_SEAT(seat_row, seat_col, seat_type, theater_id, price) VALUES ('B', 6, 'ECONOMY', 2, 250.00);
INSERT INTO THEATER_SEAT(seat_row, seat_col, seat_type, theater_id, price) VALUES ('C', 1, 'ACCESSIBLE', 3, 150.00);

--Insert discount details
INSERT INTO DISCOUNT(city_id, theater_id, discount_type) VALUES (1, 1, 'FIFTY_PERCENT');
INSERT INTO DISCOUNT(city_id, theater_id, discount_type) VALUES (1, 1, 'TWENTY_PERCENT');