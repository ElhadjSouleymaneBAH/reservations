CREATE TABLE show_tags (
                           show_id BIGINT NOT NULL,
                           tag_id BIGINT NOT NULL,
                           PRIMARY KEY (show_id, tag_id),
                           FOREIGN KEY (show_id) REFERENCES shows(id) ON UPDATE CASCADE ON DELETE RESTRICT,
                           FOREIGN KEY (tag_id) REFERENCES tags(id) ON UPDATE CASCADE ON DELETE RESTRICT
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;
