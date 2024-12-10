CREATE TABLE `localities` (
  `id` INT AUTO_INCREMENT PRIMARY KEY,
  `postal_code` VARCHAR(6) COLLATE=utf8mb4_unicode_ci NOT NULL,
  `locality` VARCHAR(60) COLLATE=utf8mb4_unicode_ci NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;
