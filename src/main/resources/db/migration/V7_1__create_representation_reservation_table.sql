CREATE TABLE `representation_reservation` (
                                              `representation_id` INT(11) NOT NULL,
                                              `reservation_id` INT(11) NOT NULL,
                                              PRIMARY KEY (`representation_id`, `reservation_id`),
                                              FOREIGN KEY (`representation_id`) REFERENCES `representations` (`id`) ON DELETE CASCADE,
                                              FOREIGN KEY (`reservation_id`) REFERENCES `reservations` (`id`) ON DELETE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;

