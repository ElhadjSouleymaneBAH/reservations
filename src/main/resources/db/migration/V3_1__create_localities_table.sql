CREATE TABLE localities
(
    id          BIGINT (11) NOT NULL AUTO_INCREMENT,
    name        VARCHAR(100) NOT NULL,
    postal_code VARCHAR(10)  NOT NULL,
    locality    VARCHAR(60),
    PRIMARY KEY (id)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;
