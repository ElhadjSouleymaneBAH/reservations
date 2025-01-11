CREATE TABLE artist_type (
                             id INT(11) NOT NULL AUTO_INCREMENT,
                             artist_id INT(11) NOT NULL,
                             type_id INT(11) NOT NULL,
                             PRIMARY KEY (id),
                             FOREIGN KEY (artist_id) REFERENCES artists(id),
                             FOREIGN KEY (type_id) REFERENCES types(id)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;
