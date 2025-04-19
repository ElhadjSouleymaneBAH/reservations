-- phpMyAdmin SQL Dump
-- version 5.2.1
-- https://www.phpmyadmin.net/
--
-- Hôte : 127.0.0.1:3306
-- Généré le : sam. 19 avr. 2025 à 23:08
-- Version du serveur : 8.2.0
-- Version de PHP : 8.3.14

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Base de données : `reservations`
--

-- --------------------------------------------------------

--
-- Structure de la table `artists`
--

DROP TABLE IF EXISTS `artists`;
CREATE TABLE IF NOT EXISTS `artists` (
  `id` bigint NOT NULL AUTO_INCREMENT,
  `firstname` varchar(60) COLLATE utf8mb4_unicode_ci NOT NULL,
  `lastname` varchar(60) COLLATE utf8mb4_unicode_ci NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=14 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;

--
-- Déchargement des données de la table `artists`
--

INSERT INTO `artists` (`id`, `firstname`, `lastname`) VALUES
(1, 'Daniel', 'Marcelin'),
(2, 'Philippe', 'Laurent'),
(3, 'Marius', 'Von Mayenburg'),
(4, 'Olivier', 'Boudon'),
(5, 'Anne Marie', 'Loop'),
(6, 'Pietro', 'Varasso'),
(7, 'Laurent', 'Caron'),
(8, 'Élena', 'Perez'),
(9, 'Guillaume', 'Alexandre'),
(10, 'Claude', 'Semal'),
(11, 'Laurence', 'Warin'),
(12, 'Pierre', 'Wayburn'),
(13, 'Gwendoline', 'Gauthier');

-- --------------------------------------------------------

--
-- Structure de la table `artist_type`
--

DROP TABLE IF EXISTS `artist_type`;
CREATE TABLE IF NOT EXISTS `artist_type` (
  `id` bigint NOT NULL AUTO_INCREMENT,
  `artist_id` bigint NOT NULL,
  `type_id` bigint NOT NULL,
  PRIMARY KEY (`id`),
  KEY `artist_type_artist_id_IDX` (`artist_id`),
  KEY `artist_type_type_id_IDX` (`type_id`)
) ENGINE=InnoDB AUTO_INCREMENT=14 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;

--
-- Déchargement des données de la table `artist_type`
--

INSERT INTO `artist_type` (`id`, `artist_id`, `type_id`) VALUES
(1, 1, 1),
(2, 2, 1),
(3, 3, 2),
(4, 4, 3),
(5, 5, 1),
(6, 6, 2),
(7, 7, 3),
(8, 8, 1),
(9, 9, 2),
(10, 10, 1),
(11, 11, 3),
(12, 12, 2),
(13, 13, 1);

-- --------------------------------------------------------

--
-- Structure de la table `artist_type_show`
--

DROP TABLE IF EXISTS `artist_type_show`;
CREATE TABLE IF NOT EXISTS `artist_type_show` (
  `id` bigint NOT NULL AUTO_INCREMENT,
  `artist_type_id` bigint NOT NULL,
  `show_id` bigint NOT NULL,
  PRIMARY KEY (`id`),
  KEY `IDX_9F6421FED0C1FC64` (`show_id`),
  KEY `IDX_9F6421FE7203D2A4` (`artist_type_id`)
) ENGINE=InnoDB AUTO_INCREMENT=14 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;

--
-- Déchargement des données de la table `artist_type_show`
--

INSERT INTO `artist_type_show` (`id`, `artist_type_id`, `show_id`) VALUES
(1, 1, 1),
(2, 2, 2),
(3, 3, 1),
(4, 4, 2),
(5, 5, 1),
(6, 6, 2),
(7, 7, 1),
(8, 8, 2),
(9, 9, 1),
(10, 10, 2),
(11, 11, 1),
(12, 12, 2),
(13, 13, 1);

-- --------------------------------------------------------

--
-- Structure de la table `flyway_schema_history`
--

DROP TABLE IF EXISTS `flyway_schema_history`;
CREATE TABLE IF NOT EXISTS `flyway_schema_history` (
  `installed_rank` int NOT NULL,
  `version` varchar(50) COLLATE utf8mb4_unicode_ci DEFAULT NULL,
  `description` varchar(200) COLLATE utf8mb4_unicode_ci NOT NULL,
  `type` varchar(20) COLLATE utf8mb4_unicode_ci NOT NULL,
  `script` varchar(1000) COLLATE utf8mb4_unicode_ci NOT NULL,
  `checksum` int DEFAULT NULL,
  `installed_by` varchar(100) COLLATE utf8mb4_unicode_ci NOT NULL,
  `installed_on` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `execution_time` int NOT NULL,
  `success` tinyint(1) NOT NULL,
  PRIMARY KEY (`installed_rank`),
  KEY `flyway_schema_history_s_idx` (`success`)
) ENGINE=MyISAM DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;

--
-- Déchargement des données de la table `flyway_schema_history`
--

INSERT INTO `flyway_schema_history` (`installed_rank`, `version`, `description`, `type`, `script`, `checksum`, `installed_by`, `installed_on`, `execution_time`, `success`) VALUES
(1, '1.1', 'create artists table', 'SQL', 'V1_1__create_artists_table.sql', 1804507767, 'root', '2025-04-19 21:59:43', 39, 1),
(2, '1.2', 'insert artists table', 'SQL', 'V1_2__insert_artists_table.sql', -390020986, 'root', '2025-04-19 21:59:43', 11, 1),
(3, '2.1', 'create types table', 'SQL', 'V2_1__create_types_table.sql', 810902511, 'root', '2025-04-19 21:59:43', 57, 1),
(4, '2.2', 'insert types table', 'SQL', 'V2_2__insert_types_table.sql', 1123719168, 'root', '2025-04-19 21:59:43', 6, 1),
(5, '3.1', 'create localities table', 'SQL', 'V3_1__create_localities_table.sql', -551455237, 'root', '2025-04-19 21:59:43', 32, 1),
(6, '3.2', 'insert localities table', 'SQL', 'V3_2__insert_localities_table.sql', -1554090457, 'root', '2025-04-19 21:59:43', 9, 1),
(7, '4.1', 'create locations table', 'SQL', 'V4_1__create_locations_table.sql', 1150856385, 'root', '2025-04-19 21:59:43', 40, 1),
(8, '4.2', 'insert locations table', 'SQL', 'V4_2__insert_locations_table.sql', 1311695317, 'root', '2025-04-19 21:59:43', 10, 1),
(9, '5.1', 'create shows table', 'SQL', 'V5_1__create_shows_table.sql', -1913531904, 'root', '2025-04-19 21:59:43', 34, 1),
(10, '5.2', 'insert shows table', 'SQL', 'V5_2__insert_shows_table.sql', 449471394, 'root', '2025-04-19 21:59:43', 10, 1),
(11, '6.1', 'create representations table', 'SQL', 'V6_1__create_representations_table.sql', -2010563670, 'root', '2025-04-19 21:59:44', 49, 1),
(12, '6.2', 'insert representations table', 'SQL', 'V6_2__insert_representations_table.sql', 1290660303, 'root', '2025-04-19 21:59:44', 8, 1),
(13, '7.1', 'create users table', 'SQL', 'V7_1__create_users_table.sql', 1381806837, 'root', '2025-04-19 21:59:44', 25, 1),
(14, '7.2', 'insert users table', 'SQL', 'V7_2__insert_users_table.sql', -1436595354, 'root', '2025-04-19 21:59:44', 6, 1),
(15, '8.1', 'create reviews table', 'SQL', 'V8_1__create_reviews_table.sql', -1358001515, 'root', '2025-04-19 21:59:44', 52, 1),
(16, '8.2', 'insert reviews table', 'SQL', 'V8_2__insert_reviews_table.sql', 395790262, 'root', '2025-04-19 21:59:44', 10, 1),
(17, '9.1', 'create reservations table', 'SQL', 'V9_1__create_reservations_table.sql', 989526022, 'root', '2025-04-19 21:59:44', 32, 1),
(18, '9.2', 'insert reservations table', 'SQL', 'V9_2__insert_reservations_table.sql', -1555775399, 'root', '2025-04-19 21:59:44', 5, 1),
(19, '10.1', 'create roles table', 'SQL', 'V10_1__create_roles_table.sql', -1977503890, 'root', '2025-04-19 21:59:44', 23, 1),
(20, '10.2', 'insert roles table', 'SQL', 'V10_2__insert_roles_table.sql', -1971152321, 'root', '2025-04-19 21:59:44', 7, 1),
(21, '11.1', 'create prices table', 'SQL', 'V11_1__create_prices_table.sql', 1643260702, 'root', '2025-04-19 21:59:44', 39, 1),
(22, '11.2', 'insert prices table', 'SQL', 'V11_2__insert_prices_table.sql', -1925039059, 'root', '2025-04-19 21:59:44', 6, 1),
(23, '12.1', 'create representation reservation table', 'SQL', 'V12_1__create_representation_reservation_table.sql', -1890419364, 'root', '2025-04-19 21:59:44', 48, 1),
(24, '12.2', 'insert representation reservation table', 'SQL', 'V12_2__insert_representation_reservation_table.sql', 1386161135, 'root', '2025-04-19 21:59:44', 7, 1),
(25, '13.1', 'create artist type table', 'SQL', 'V13_1__create_artist_type_table.sql', 38326031, 'root', '2025-04-19 21:59:44', 194, 1),
(26, '13.2', 'insert artist type table', 'SQL', 'V13_2__insert_artist_type_table.sql', -1818605420, 'root', '2025-04-19 21:59:44', 7, 1),
(27, '14.1', 'create user role table', 'SQL', 'V14_1__create_user_role_table.sql', 125145133, 'root', '2025-04-19 21:59:44', 25, 1),
(28, '14.2', 'insert user role table', 'SQL', 'V14_2__insert_user_role_table.sql', -708716983, 'root', '2025-04-19 21:59:44', 5, 1),
(29, '15.1', 'create artist type show table', 'SQL', 'V15_1__create_artist_type_show_table.sql', -1179607041, 'root', '2025-04-19 21:59:45', 93, 1),
(30, '15.2', 'insert artist type show table', 'SQL', 'V15_2__insert_artist_type_show_table.sql', -1405223492, 'root', '2025-04-19 21:59:45', 7, 1),
(31, '16.1', 'create show price table', 'SQL', 'V16_1__create_show_price_table.sql', 1081289569, 'root', '2025-04-19 21:59:45', 70, 1),
(32, '16.2', 'insert show price table', 'SQL', 'V16_2__insert_show_price_table.sql', 580849949, 'root', '2025-04-19 21:59:45', 5, 1),
(33, '17.1', 'create tags table', 'SQL', 'V17_1__create_tags_table.sql', -1242393028, 'root', '2025-04-19 21:59:45', 21, 1),
(34, '17.2', 'insert tags table', 'SQL', 'V17_2__insert_tags_table.sql', 951057382, 'root', '2025-04-19 21:59:45', 7, 1),
(35, '18.1', 'create show tags table', 'SQL', 'V18_1__create_show_tags_table.sql', 264785525, 'root', '2025-04-19 21:59:45', 34, 1);

-- --------------------------------------------------------

--
-- Structure de la table `localities`
--

DROP TABLE IF EXISTS `localities`;
CREATE TABLE IF NOT EXISTS `localities` (
  `id` bigint NOT NULL AUTO_INCREMENT,
  `name` varchar(100) COLLATE utf8mb4_unicode_ci NOT NULL,
  `postal_code` varchar(10) COLLATE utf8mb4_unicode_ci NOT NULL,
  `locality` varchar(60) COLLATE utf8mb4_unicode_ci DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;

--
-- Déchargement des données de la table `localities`
--

INSERT INTO `localities` (`id`, `name`, `postal_code`, `locality`) VALUES
(1, 'Bruxelles', '1000', NULL),
(2, 'Namur', '5000', NULL),
(3, 'Liège', '4000', NULL),
(4, 'Anvers', '2000', NULL);

-- --------------------------------------------------------

--
-- Structure de la table `locations`
--

DROP TABLE IF EXISTS `locations`;
CREATE TABLE IF NOT EXISTS `locations` (
  `id` bigint NOT NULL AUTO_INCREMENT,
  `name` varchar(60) COLLATE utf8mb4_unicode_ci NOT NULL,
  `address` varchar(255) COLLATE utf8mb4_unicode_ci NOT NULL,
  `website` varchar(255) COLLATE utf8mb4_unicode_ci DEFAULT NULL,
  `phone` varchar(30) COLLATE utf8mb4_unicode_ci DEFAULT NULL,
  `city` varchar(40) COLLATE utf8mb4_unicode_ci DEFAULT NULL,
  `locality_id` bigint NOT NULL,
  PRIMARY KEY (`id`),
  KEY `locality_id` (`locality_id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;

--
-- Déchargement des données de la table `locations`
--

INSERT INTO `locations` (`id`, `name`, `address`, `website`, `phone`, `city`, `locality_id`) VALUES
(1, 'Théâtre Royal', '123 Rue du Théâtre, Bruxelles', 'http://theatreroyal.be', '+32 2 123 45 67', NULL, 1),
(2, 'Salle des Fêtes', '12 Boulevard de la Liberté, Namur', 'http://salledesfetes.be', '+32 4 567 89 01', NULL, 2);

-- --------------------------------------------------------

--
-- Structure de la table `prices`
--

DROP TABLE IF EXISTS `prices`;
CREATE TABLE IF NOT EXISTS `prices` (
  `id` bigint NOT NULL AUTO_INCREMENT,
  `type` varchar(30) COLLATE utf8mb4_unicode_ci NOT NULL,
  `price` float(10,2) NOT NULL,
  `start_date` date DEFAULT NULL,
  `end_date` date DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;

--
-- Déchargement des données de la table `prices`
--

INSERT INTO `prices` (`id`, `type`, `price`, `start_date`, `end_date`) VALUES
(1, 'Standard', 50.00, '2025-01-01', '2025-12-31'),
(2, 'VIP', 100.00, '2025-01-01', '2025-12-31'),
(3, 'Promotion', 30.00, '2025-03-01', '2025-03-15');

-- --------------------------------------------------------

--
-- Structure de la table `price_shows`
--

DROP TABLE IF EXISTS `price_shows`;
CREATE TABLE IF NOT EXISTS `price_shows` (
  `id` bigint NOT NULL AUTO_INCREMENT,
  `show_id` bigint NOT NULL,
  `price_id` bigint NOT NULL,
  PRIMARY KEY (`id`),
  KEY `show_id` (`show_id`),
  KEY `price_id` (`price_id`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;

--
-- Déchargement des données de la table `price_shows`
--

INSERT INTO `price_shows` (`id`, `show_id`, `price_id`) VALUES
(1, 1, 1),
(2, 1, 2),
(3, 2, 1),
(4, 2, 3);

-- --------------------------------------------------------

--
-- Structure de la table `representations`
--

DROP TABLE IF EXISTS `representations`;
CREATE TABLE IF NOT EXISTS `representations` (
  `id` bigint NOT NULL AUTO_INCREMENT,
  `schedule` datetime NOT NULL,
  `show_id` bigint NOT NULL,
  `location_id` bigint NOT NULL,
  `available_seats` int DEFAULT NULL,
  `price` float(10,2) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `show_id` (`show_id`),
  KEY `location_id` (`location_id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;

--
-- Déchargement des données de la table `representations`
--

INSERT INTO `representations` (`id`, `schedule`, `show_id`, `location_id`, `available_seats`, `price`) VALUES
(1, '2025-03-10 20:00:00', 1, 1, NULL, NULL),
(2, '2025-03-11 20:00:00', 2, 2, NULL, NULL),
(3, '2025-03-12 20:00:00', 1, 2, NULL, NULL);

-- --------------------------------------------------------

--
-- Structure de la table `representation_reservation`
--

DROP TABLE IF EXISTS `representation_reservation`;
CREATE TABLE IF NOT EXISTS `representation_reservation` (
  `id` bigint NOT NULL AUTO_INCREMENT,
  `representation_id` bigint NOT NULL,
  `reservation_id` bigint NOT NULL,
  `price_id` bigint NOT NULL,
  `quantity` int DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `representation_id` (`representation_id`),
  KEY `reservation_id` (`reservation_id`),
  KEY `price_id` (`price_id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;

--
-- Déchargement des données de la table `representation_reservation`
--

INSERT INTO `representation_reservation` (`id`, `representation_id`, `reservation_id`, `price_id`, `quantity`) VALUES
(1, 1, 1, 1, 2),
(2, 2, 2, 2, 1),
(3, 3, 3, 3, 3);

-- --------------------------------------------------------

--
-- Structure de la table `reservations`
--

DROP TABLE IF EXISTS `reservations`;
CREATE TABLE IF NOT EXISTS `reservations` (
  `id` bigint NOT NULL AUTO_INCREMENT,
  `user_name` varchar(60) COLLATE utf8mb4_unicode_ci NOT NULL,
  `user_id` bigint NOT NULL,
  `booking_date` datetime NOT NULL,
  `status` enum('confirmed','pending','cancelled') COLLATE utf8mb4_unicode_ci NOT NULL,
  PRIMARY KEY (`id`),
  KEY `idx_user_id` (`user_id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;

--
-- Déchargement des données de la table `reservations`
--

INSERT INTO `reservations` (`id`, `user_name`, `user_id`, `booking_date`, `status`) VALUES
(1, 'notNull', 1, '2025-03-10 12:00:00', 'confirmed'),
(2, 'notNull', 2, '2025-03-11 14:30:00', 'pending'),
(3, 'notNull', 3, '2025-03-12 16:45:00', 'cancelled');

-- --------------------------------------------------------

--
-- Structure de la table `reviews`
--

DROP TABLE IF EXISTS `reviews`;
CREATE TABLE IF NOT EXISTS `reviews` (
  `id` bigint NOT NULL AUTO_INCREMENT,
  `user_id` bigint NOT NULL,
  `show_id` bigint NOT NULL,
  `review` varchar(1000) COLLATE utf8mb4_unicode_ci NOT NULL,
  `stars` int NOT NULL,
  `validated` tinyint(1) NOT NULL DEFAULT '0',
  `created_at` datetime DEFAULT CURRENT_TIMESTAMP,
  `updated_at` datetime DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  PRIMARY KEY (`id`),
  KEY `user_id` (`user_id`),
  KEY `show_id` (`show_id`)
) ;

--
-- Déchargement des données de la table `reviews`
--

INSERT INTO `reviews` (`id`, `user_id`, `show_id`, `review`, `stars`, `validated`, `created_at`, `updated_at`) VALUES
(1, 1, 1, 'Spectacle impressionnant, à revoir absolument !', 5, 1, '2025-04-19 23:59:44', '2025-04-19 23:59:44'),
(2, 2, 2, 'Très belle mise en scène, mais un peu long.', 4, 1, '2025-04-19 23:59:44', '2025-04-19 23:59:44'),
(3, 3, 1, 'Pas à la hauteur de mes attentes...', 2, 1, '2025-04-19 23:59:44', '2025-04-19 23:59:44');

-- --------------------------------------------------------

--
-- Structure de la table `roles`
--

DROP TABLE IF EXISTS `roles`;
CREATE TABLE IF NOT EXISTS `roles` (
  `id` bigint NOT NULL AUTO_INCREMENT,
  `role` varchar(30) COLLATE utf8mb4_unicode_ci NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;

--
-- Déchargement des données de la table `roles`
--

INSERT INTO `roles` (`id`, `role`) VALUES
(1, 'ADMIN'),
(2, 'USER'),
(3, 'MANAGER');

-- --------------------------------------------------------

--
-- Structure de la table `role_user`
--

DROP TABLE IF EXISTS `role_user`;
CREATE TABLE IF NOT EXISTS `role_user` (
  `role_id` bigint NOT NULL,
  `user_id` bigint NOT NULL,
  PRIMARY KEY (`role_id`,`user_id`),
  KEY `user_id` (`user_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;

--
-- Déchargement des données de la table `role_user`
--

INSERT INTO `role_user` (`role_id`, `user_id`) VALUES
(1, 1),
(2, 1),
(2, 2),
(3, 2);

-- --------------------------------------------------------

--
-- Structure de la table `shows`
--

DROP TABLE IF EXISTS `shows`;
CREATE TABLE IF NOT EXISTS `shows` (
  `id` bigint NOT NULL AUTO_INCREMENT,
  `title` varchar(255) COLLATE utf8mb4_unicode_ci NOT NULL,
  `description` text COLLATE utf8mb4_unicode_ci NOT NULL,
  `poster_url` varchar(255) COLLATE utf8mb4_unicode_ci DEFAULT NULL,
  `duration` int UNSIGNED DEFAULT NULL,
  `created_in` timestamp NULL DEFAULT NULL,
  `bookable` tinyint(1) DEFAULT NULL,
  `location_id` bigint NOT NULL,
  PRIMARY KEY (`id`),
  KEY `location_id` (`location_id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;

--
-- Déchargement des données de la table `shows`
--

INSERT INTO `shows` (`id`, `title`, `description`, `poster_url`, `duration`, `created_in`, `bookable`, `location_id`) VALUES
(1, 'Le Roi Lion', 'Une comédie musicale emblématique inspirée du film Disney.', '/images/le-roi-lion.jpg', 120, '2019-06-05 22:00:00', 1, 1),
(2, 'Phantom of the Opera', 'Une œuvre dramatique intemporelle au cœur de l’opéra de Paris.', '/images/phantom.jpg', 135, '2018-06-05 22:00:00', 1, 2);

-- --------------------------------------------------------

--
-- Structure de la table `show_tags`
--

DROP TABLE IF EXISTS `show_tags`;
CREATE TABLE IF NOT EXISTS `show_tags` (
  `show_id` bigint NOT NULL,
  `tag_id` bigint NOT NULL,
  PRIMARY KEY (`show_id`,`tag_id`),
  KEY `tag_id` (`tag_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;

-- --------------------------------------------------------

--
-- Structure de la table `tags`
--

DROP TABLE IF EXISTS `tags`;
CREATE TABLE IF NOT EXISTS `tags` (
  `id` bigint NOT NULL AUTO_INCREMENT,
  `tag` varchar(30) COLLATE utf8mb4_unicode_ci NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `tag` (`tag`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;

--
-- Déchargement des données de la table `tags`
--

INSERT INTO `tags` (`id`, `tag`) VALUES
(3, 'Classique'),
(1, 'Comédie'),
(4, 'Drame'),
(5, 'Fantaisie'),
(2, 'Musique');

-- --------------------------------------------------------

--
-- Structure de la table `types`
--

DROP TABLE IF EXISTS `types`;
CREATE TABLE IF NOT EXISTS `types` (
  `id` bigint NOT NULL AUTO_INCREMENT,
  `type` varchar(60) COLLATE utf8mb4_unicode_ci NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=14 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;

--
-- Déchargement des données de la table `types`
--

INSERT INTO `types` (`id`, `type`) VALUES
(1, 'Musicien'),
(2, 'Comédien'),
(3, 'Auteur'),
(4, 'Metteur en scène'),
(5, 'Chorégraphe'),
(6, 'Danseur'),
(7, 'Producteur'),
(8, 'Acteur principal'),
(9, 'Pianiste'),
(10, 'Violoniste'),
(11, 'Chef d’orchestre'),
(12, 'Narrateur'),
(13, 'Improvisateur');

-- --------------------------------------------------------

--
-- Structure de la table `users`
--

DROP TABLE IF EXISTS `users`;
CREATE TABLE IF NOT EXISTS `users` (
  `id` bigint NOT NULL AUTO_INCREMENT,
  `login` varchar(60) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NOT NULL,
  `password` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NOT NULL,
  `first_name` varchar(60) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NOT NULL,
  `last_name` varchar(60) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NOT NULL,
  `email` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NOT NULL,
  `langue` varchar(2) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NOT NULL,
  `role` enum('ADMIN','MEMBER','AFFILIATE','PRESS','PRODUCER') CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NOT NULL,
  `created_at` datetime NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;

--
-- Déchargement des données de la table `users`
--

INSERT INTO `users` (`id`, `login`, `password`, `first_name`, `last_name`, `email`, `langue`, `role`, `created_at`) VALUES
(1, 'bob', '12345678', 'Bob', 'Sull', 'bob@sull.com', 'fr', 'ADMIN', '2025-04-19 23:59:44'),
(2, 'anna', '12345678', 'Anna', 'Lyse', 'anna.lyse@sull.com', 'en', 'MEMBER', '2025-04-19 23:59:44'),
(3, 'john', '12345678', 'John', 'Doe', 'john.doe@sull.com', 'fr', 'MEMBER', '2025-04-19 23:59:44');

--
-- Contraintes pour les tables déchargées
--

--
-- Contraintes pour la table `artist_type`
--
ALTER TABLE `artist_type`
  ADD CONSTRAINT `fk_artist_type_artist` FOREIGN KEY (`artist_id`) REFERENCES `artists` (`id`) ON DELETE RESTRICT ON UPDATE CASCADE,
  ADD CONSTRAINT `fk_artist_type_type` FOREIGN KEY (`type_id`) REFERENCES `types` (`id`) ON DELETE RESTRICT ON UPDATE CASCADE;

--
-- Contraintes pour la table `artist_type_show`
--
ALTER TABLE `artist_type_show`
  ADD CONSTRAINT `FK_9F6421FE7203D2A4` FOREIGN KEY (`artist_type_id`) REFERENCES `artist_type` (`id`) ON DELETE RESTRICT ON UPDATE CASCADE,
  ADD CONSTRAINT `FK_9F6421FED0C1FC64` FOREIGN KEY (`show_id`) REFERENCES `shows` (`id`) ON DELETE RESTRICT ON UPDATE CASCADE;

--
-- Contraintes pour la table `locations`
--
ALTER TABLE `locations`
  ADD CONSTRAINT `locations_ibfk_1` FOREIGN KEY (`locality_id`) REFERENCES `localities` (`id`);

--
-- Contraintes pour la table `price_shows`
--
ALTER TABLE `price_shows`
  ADD CONSTRAINT `price_shows_ibfk_1` FOREIGN KEY (`show_id`) REFERENCES `shows` (`id`) ON DELETE CASCADE,
  ADD CONSTRAINT `price_shows_ibfk_2` FOREIGN KEY (`price_id`) REFERENCES `prices` (`id`) ON DELETE CASCADE;

--
-- Contraintes pour la table `representations`
--
ALTER TABLE `representations`
  ADD CONSTRAINT `representations_ibfk_1` FOREIGN KEY (`show_id`) REFERENCES `shows` (`id`),
  ADD CONSTRAINT `representations_ibfk_2` FOREIGN KEY (`location_id`) REFERENCES `locations` (`id`);

--
-- Contraintes pour la table `representation_reservation`
--
ALTER TABLE `representation_reservation`
  ADD CONSTRAINT `representation_reservation_ibfk_1` FOREIGN KEY (`representation_id`) REFERENCES `representations` (`id`) ON DELETE CASCADE,
  ADD CONSTRAINT `representation_reservation_ibfk_2` FOREIGN KEY (`reservation_id`) REFERENCES `reservations` (`id`) ON DELETE CASCADE,
  ADD CONSTRAINT `representation_reservation_ibfk_3` FOREIGN KEY (`price_id`) REFERENCES `prices` (`id`) ON DELETE CASCADE;

--
-- Contraintes pour la table `reservations`
--
ALTER TABLE `reservations`
  ADD CONSTRAINT `reservations_ibfk_1` FOREIGN KEY (`user_id`) REFERENCES `users` (`id`) ON DELETE CASCADE;

--
-- Contraintes pour la table `reviews`
--
ALTER TABLE `reviews`
  ADD CONSTRAINT `reviews_ibfk_1` FOREIGN KEY (`user_id`) REFERENCES `users` (`id`) ON DELETE CASCADE,
  ADD CONSTRAINT `reviews_ibfk_2` FOREIGN KEY (`show_id`) REFERENCES `shows` (`id`) ON DELETE CASCADE;

--
-- Contraintes pour la table `role_user`
--
ALTER TABLE `role_user`
  ADD CONSTRAINT `role_user_ibfk_1` FOREIGN KEY (`role_id`) REFERENCES `roles` (`id`),
  ADD CONSTRAINT `role_user_ibfk_2` FOREIGN KEY (`user_id`) REFERENCES `users` (`id`);

--
-- Contraintes pour la table `shows`
--
ALTER TABLE `shows`
  ADD CONSTRAINT `shows_ibfk_1` FOREIGN KEY (`location_id`) REFERENCES `locations` (`id`);

--
-- Contraintes pour la table `show_tags`
--
ALTER TABLE `show_tags`
  ADD CONSTRAINT `show_tags_ibfk_1` FOREIGN KEY (`show_id`) REFERENCES `shows` (`id`) ON DELETE RESTRICT ON UPDATE CASCADE,
  ADD CONSTRAINT `show_tags_ibfk_2` FOREIGN KEY (`tag_id`) REFERENCES `tags` (`id`) ON DELETE RESTRICT ON UPDATE CASCADE;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
