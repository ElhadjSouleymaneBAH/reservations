CREATE TABLE reservations (
                              id INT(11) NOT NULL AUTO_INCREMENT,
                              user_id INT(11) NOT NULL,
                              booking_date DATETIME NOT NULL,
                              status VARCHAR(60) NOT NULL,
                              PRIMARY KEY (id),
                              FOREIGN KEY (user_id) REFERENCES users(id)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;
