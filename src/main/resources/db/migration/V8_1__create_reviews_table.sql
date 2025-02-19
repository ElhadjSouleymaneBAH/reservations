CREATE TABLE reviews (
                         id INT(11) NOT NULL AUTO_INCREMENT,
                         user_id INT(11) NOT NULL,
                         show_id INT(11) NOT NULL,
                         review VARCHAR(1000) NOT NULL,
                         stars TINYINT UNSIGNED NOT NULL CHECK (stars BETWEEN 1 AND 5),
                         validated TINYINT(1) NOT NULL DEFAULT 0,
                         created_at DATETIME DEFAULT CURRENT_TIMESTAMP,
                         updated_at DATETIME DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
                         PRIMARY KEY (id),
                         FOREIGN KEY (user_id) REFERENCES users(id) ON DELETE CASCADE,
                         FOREIGN KEY (show_id) REFERENCES shows(id) ON DELETE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;
