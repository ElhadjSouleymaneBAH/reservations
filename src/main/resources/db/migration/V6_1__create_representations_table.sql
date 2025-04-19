CREATE TABLE representations
(
    id              BIGINT (11) NOT NULL AUTO_INCREMENT,
    schedule        DATETIME NOT NULL,
    show_id         BIGINT (11) NOT NULL,
    location_id     BIGINT (11) NOT NULL,
    available_seats INTEGER(11),
    price FLOAT(10,2),
    PRIMARY KEY (id),
    FOREIGN KEY (show_id) REFERENCES shows (id),
    FOREIGN KEY (location_id) REFERENCES locations (id)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;
