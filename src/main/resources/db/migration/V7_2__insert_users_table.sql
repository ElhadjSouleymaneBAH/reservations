INSERT INTO `users` (`id`, `login`, `password`, `first_name`, `last_name`, `email`, `langue`, `role`, `created_at`)
VALUES (1, 'bob', '12345678', 'Bob', 'Sull', 'bob@sull.com', 'fr', 'ADMIN', NOW()),
       (2, 'anna', '12345678', 'Anna', 'Lyse', 'anna.lyse@sull.com', 'en', 'MEMBER', NOW()),
       (3, 'john', '12345678', 'John', 'Doe', 'john.doe@sull.com', 'fr', 'MEMBER', NOW());
