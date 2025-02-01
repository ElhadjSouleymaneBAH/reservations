CREATE TABLE `artist_type_show` (
                                    `id` INT(11) NOT NULL AUTO_INCREMENT,
                                    `artist_type_id` INT(11) NOT NULL,
                                    `show_id` INT(11) NOT NULL,
                                    PRIMARY KEY (`id`),
                                    FOREIGN KEY (`artist_type_id`) REFERENCES `artist_type`(`id`) ON DELETE CASCADE ON UPDATE CASCADE,
                                    FOREIGN KEY (`show_id`) REFERENCES `shows`(`id`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;
