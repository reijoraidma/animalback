INSERT INTO animal.role (id, name) VALUES (default, 'admin');
INSERT INTO animal.role (id, name) VALUES (default, 'customer');


INSERT INTO animal."user" (id, role_id, email, password, status) VALUES (default, 1, 'admin', '123', 'A');
INSERT INTO animal."user" (id, role_id, email, password, status) VALUES (default, 2, 'reijo', '123', 'A');
INSERT INTO animal."user" (id, role_id, email, password, status) VALUES (default, 2, 'fred', '123' , 'A');
INSERT INTO animal."user" (id, role_id, email, password, status) VALUES (default, 2, 'kertu', '123', 'A');

INSERT INTO animal.animal_type (id, name, image_data, status) VALUES (default, 'Koer', 'AAAAAA', 'A');
INSERT INTO animal.animal_type (id, name, image_data, status) VALUES (default, 'Kass', 'AAAAAA', 'A');
INSERT INTO animal.animal_type (id, name, image_data, status) VALUES (default, 'Madu', 'AAAA', 'A');

INSERT INTO animal.breed (id, type, animal_type_id,image_data, status) VALUES (default, 'Taks', 1, 'AAAAAA', 'A');
INSERT INTO animal.breed (id, type, animal_type_id,image_data, status) VALUES (default, 'Siiam', 2, 'AAAAAA', 'A');
INSERT INTO animal.breed (id, type, animal_type_id,image_data, status) VALUES (default, 'Nastik', 3, 'AAAAAA', 'A');
INSERT INTO animal.breed (id, type, animal_type_id,image_data, status) VALUES (default, 'SaksaLamba', 1, 'AAAAAA', 'A');
INSERT INTO animal.breed (id, type, animal_type_id,image_data, status) VALUES (default, 'Kolli', 1, 'AAAAAA', 'A');
INSERT INTO animal.breed (id, type, animal_type_id,image_data, status) VALUES (default, 'KuriMuri', 1, 'AAAAAA', 'A');

INSERT INTO animal.gender (id, type) VALUES (default, 'male');
INSERT INTO animal.gender (id, type) VALUES (default, 'female');

INSERT INTO animal.animal (id, animal_type_id, gender_id, breed_id, size, age, color) VALUES (default, 2, 1, 2, 'keskmine', 'noor', 'lilla');


