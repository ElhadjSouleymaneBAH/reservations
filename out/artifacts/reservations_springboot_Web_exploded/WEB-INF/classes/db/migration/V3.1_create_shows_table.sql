CREATE TABLE shows (
                       id INT(11) NOT NULL AUTO_INCREMENT,
                       title VARCHAR(255) NOT NULL,
                       poster_url VARCHAR(255),
                       duration SMALLINT(5) UNSIGNED,
                       created_in YEAR,
                       bookable TINYINT(1),
                       location_id INT(11) NOT NULL,
                       PRIMARY KEY (id),
                       FOREIGN KEY (location_id) REFERENCES locations(id)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;
