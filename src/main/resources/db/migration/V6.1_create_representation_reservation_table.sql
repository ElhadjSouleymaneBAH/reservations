CREATE TABLE representation_reservation (
                                            id INT(11) NOT NULL AUTO_INCREMENT,
                                            representation_id INT(11) NOT NULL,
                                            reservation_id INT(11) NOT NULL,
                                            price DECIMAL(10,2) NOT NULL,
                                            quantity TINYINT(4) NOT NULL,
                                            PRIMARY KEY (id),
                                            FOREIGN KEY (representation_id) REFERENCES representations(id),
                                            FOREIGN KEY (reservation_id) REFERENCES reservations(id)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;
