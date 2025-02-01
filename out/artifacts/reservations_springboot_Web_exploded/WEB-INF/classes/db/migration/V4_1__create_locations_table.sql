CREATE TABLE locations (
                           id INT(11) NOT NULL AUTO_INCREMENT,
                           name VARCHAR(60) NOT NULL,
                           address VARCHAR(255) NOT NULL,
                           website VARCHAR(255),
                           phone VARCHAR(30),
                           locality_id INT(11) NOT NULL,
                           PRIMARY KEY (id),
                           FOREIGN KEY (locality_id) REFERENCES localities(id)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;
