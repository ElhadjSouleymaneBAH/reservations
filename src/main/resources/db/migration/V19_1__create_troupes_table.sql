DROP TABLE IF EXISTS `troupes`;
CREATE TABLE IF NOT EXISTS `troupes` (
                                         `id` bigint NOT NULL AUTO_INCREMENT,
                                         `name` varchar(60) COLLATE utf8mb4_unicode_ci NOT NULL,
    `logo_url` varchar(255) COLLATE utf8mb4_unicode_ci NOT NULL UNIQUE,
    PRIMARY KEY (`id`)
    ) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;