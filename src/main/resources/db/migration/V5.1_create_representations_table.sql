CREATE TABLE representations (
                                 id INT(11) NOT NULL AUTO_INCREMENT,
                                 schedule DATETIME NOT NULL,
                                 show_id INT(11) NOT NULL,
                                 location_id INT(11) NOT NULL,
                                 PRIMARY KEY (id),
                                 FOREIGN KEY (show_id) REFERENCES shows(id),
                                 FOREIGN KEY (location_id) REFERENCES locations(id)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;
