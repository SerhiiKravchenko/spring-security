CREATE TABLE users (
  user_id BIGINT AUTO_INCREMENT PRIMARY KEY,
  email VARCHAR(128) NOT NULL UNIQUE,
  password VARCHAR(256) NOT NULL,
  is_non_locked BOOLEAN NOT NULL,
  last_success_login_timestamp BIGINT,
  attempts_count BIGINT
);

CREATE TABLE auth_user_group (
  auth_user_group_id BIGINT AUTO_INCREMENT PRIMARY KEY,
  email VARCHAR(128) NOT NULL,
  auth_group VARCHAR(128) NOT NULL,
  CONSTRAINT user_auth_user_group_fk FOREIGN KEY(email) REFERENCES users(email),
  UNIQUE (email, auth_group)
);