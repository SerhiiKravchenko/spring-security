INSERT INTO users (email, password,is_non_locked,last_success_login_timestamp,attempts_count) VALUES ('user@gmail.com','$2a$10$N1Ue9OkY22W10rR1H5mOTey8oKwXtTOF649wq6reug/w/UE9iQG6S', TRUE,0,0);
INSERT INTO users (email, password,is_non_locked,last_success_login_timestamp,attempts_count) VALUES ('user1@gmail.com','$2a$10$N1Ue9OkY22W10rR1H5mOTey8oKwXtTOF649wq6reug/w/UE9iQG6S', TRUE,0,0);
INSERT INTO users (email, password,is_non_locked,last_success_login_timestamp,attempts_count) VALUES ('admin@gmail.com', '$2a$11$1U8YN8KJFlyhludB31DlsO9oBAbe0aNb5xfwMtq.gZwXjS5eQrUSO', TRUE,0,0);

INSERT INTO auth_user_group (email, auth_group) VALUES('user@gmail.com', 'VIEW_INFO');
INSERT INTO auth_user_group (email, auth_group) VALUES('user1@gmail.com', 'VIEW_INFO');
INSERT INTO auth_user_group (email, auth_group) VALUES('admin@gmail.com', 'VIEW_ADMIN');
INSERT INTO auth_user_group (email, auth_group) VALUES('admin@gmail.com', 'VIEW_INFO');