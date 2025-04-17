CREATE TABLE IF NOT EXISTS representation_reservation (
    id INT(11) NOT NULL AUTO_INCREMENT,
    representation_id INT(11) NOT NULL,
    reservation_id INT(11) NOT NULL,
    price_id INT(11) NOT NULL,
    quantity TINYINT(4),

    PRIMARY KEY (id),
    FOREIGN KEY (representation_id) REFERENCES representations(id) ON DELETE CASCADE,
    FOREIGN KEY (reservation_id) REFERENCES reservations(id) ON DELETE CASCADE,
    FOREIGN KEY (price_id) REFERENCES prices(id) ON DELETE CASCADE
    ) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;
