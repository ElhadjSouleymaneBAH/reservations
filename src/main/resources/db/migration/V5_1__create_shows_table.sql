CREATE TABLE shows
(
    id           BIGINT(11) NOT NULL AUTO_INCREMENT,
    title        VARCHAR(255) NOT NULL,
    description  TEXT NOT NULL,
    poster_url   VARCHAR(255),
    duration     INTEGER(5) UNSIGNED,
    created_in   TIMESTAMP,
    bookable     TINYINT(1),
    location_id  BIGINT(11) NOT NULL,
    PRIMARY KEY (id),
    FOREIGN KEY (location_id) REFERENCES locations(id)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;
