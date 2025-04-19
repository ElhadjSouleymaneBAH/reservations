CREATE TABLE tags (
                      id BIGINT NOT NULL AUTO_INCREMENT,
                      tag VARCHAR(30) NOT NULL UNIQUE,
                      PRIMARY KEY (id)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;
