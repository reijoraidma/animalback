INSERT INTO animal.role (id, name) VALUES (default, 'admin');
INSERT INTO animal.role (id, name) VALUES (default, 'customer');


INSERT INTO animal."user" (id, role_id, email, password) VALUES (default, 1, 'admin', '123');
INSERT INTO animal."user" (id, role_id, email, password) VALUES (default, 2, 'reijo', '123');
INSERT INTO animal."user" (id, role_id, email, password) VALUES (default, 2, 'fred', '123');
INSERT INTO animal."user" (id, role_id, email, password) VALUES (default, 2, 'kertu', '123');
