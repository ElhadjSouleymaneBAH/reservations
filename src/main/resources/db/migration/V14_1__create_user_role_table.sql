CREATE TABLE role_user (
                           role_id BIGINT (11) NOT NULL,
                           user_id BIGINT (11) NOT NULL,
                           PRIMARY KEY (role_id, user_id),
                           FOREIGN KEY (role_id) REFERENCES roles(id),
                           FOREIGN KEY (user_id) REFERENCES users(id)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;
