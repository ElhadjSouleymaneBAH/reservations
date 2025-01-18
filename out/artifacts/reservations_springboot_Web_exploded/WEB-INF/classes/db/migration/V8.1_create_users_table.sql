CREATE TABLE users (
                       id INT(11) NOT NULL AUTO_INCREMENT,
                       login VARCHAR(30) NOT NULL,
                       password VARCHAR(255) NOT NULL,
                       firstname VARCHAR(60) NOT NULL,
                       lastname VARCHAR(60) NOT NULL,
                       email VARCHAR(255) NOT NULL,
                       langue VARCHAR(2),
                       PRIMARY KEY (id)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;
