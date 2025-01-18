CREATE TABLE reviews (
                         id INT(11) NOT NULL AUTO_INCREMENT,
                         user_id INT(11) NOT NULL,
                         show_id INT(11) NOT NULL,
                         review VARCHAR(1000) NOT NULL,
                         stars TINYINT UNSIGNED NOT NULL,
                         validated TINYINT(1) NOT NULL,
                         created_at DATETIME,
                         updated_at DATETIME,
                         PRIMARY KEY (id),
                         FOREIGN KEY (user_id) REFERENCES users(id),
                         FOREIGN KEY (show_id) REFERENCES shows(id)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;
