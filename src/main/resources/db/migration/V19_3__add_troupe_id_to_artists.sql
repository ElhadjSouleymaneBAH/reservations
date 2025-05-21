ALTER TABLE `artists`
    ADD COLUMN `troupe_id` bigint DEFAULT NULL,
ADD CONSTRAINT `fk_artist_troupe` FOREIGN KEY (`troupe_id`) REFERENCES `troupes` (`id`) ON DELETE CASCADE ON UPDATE CASCADE;