CREATE TABLE show_price (
                            show_id BIGINT NOT NULL,
                            price_id BIGINT NOT NULL,
                            PRIMARY KEY (show_id, price_id),
                            FOREIGN KEY (show_id) REFERENCES shows(id) ON DELETE CASCADE,
                            FOREIGN KEY (price_id) REFERENCES prices(id) ON DELETE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;
