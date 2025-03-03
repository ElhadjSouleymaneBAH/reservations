CREATE TABLE reservations (
                              id INT(11) NOT NULL AUTO_INCREMENT,
                              user_id INT(11) NOT NULL,
                              booking_date DATETIME NOT NULL,
                              status ENUM('confirmed', 'pending', 'cancelled') NOT NULL,
                              PRIMARY KEY (id),
                              INDEX idx_user_id (user_id),
                              FOREIGN KEY (user_id) REFERENCES users(id) ON DELETE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;
