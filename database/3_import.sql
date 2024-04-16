INSERT INTO animal.role (id, name) VALUES (default, 'admin');
INSERT INTO animal.role (id, name) VALUES (default, 'customer');


INSERT INTO animal."user" (id, role_id, email, password, status) VALUES (default, 1, 'admin', '123', 'A');
INSERT INTO animal."user" (id, role_id, email, password, status) VALUES (default, 2, 'reijo', '123', 'A');
INSERT INTO animal."user" (id, role_id, email, password, status) VALUES (default, 2, 'fred', '123' , 'A');
INSERT INTO animal."user" (id, role_id, email, password, status) VALUES (default, 2, 'kertu', '123', 'A');
