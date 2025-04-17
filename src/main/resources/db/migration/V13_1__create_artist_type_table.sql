CREATE TABLE `artist_type`
(
    `id`        INT(11) NOT NULL AUTO_INCREMENT,
    `artist_id` INT(11) NOT NULL,
    `type_id`   INT(11) NOT NULL,
    PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;

-- Index
ALTER TABLE `artist_type`
    ADD KEY `artist_type_artist_id_IDX` (`artist_id`);

ALTER TABLE `artist_type`
    ADD KEY `artist_type_type_id_IDX` (`type_id`);

-- Contraintes
ALTER TABLE `artist_type`
    ADD CONSTRAINT `fk_artist_type_artist` FOREIGN KEY (`artist_id`) REFERENCES `artists` (`id`) ON UPDATE CASCADE ON DELETE RESTRICT;

ALTER TABLE `artist_type`
    ADD CONSTRAINT `fk_artist_type_type` FOREIGN KEY (`type_id`) REFERENCES `types` (`id`) ON UPDATE CASCADE ON DELETE RESTRICT;
