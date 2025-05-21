INSERT INTO `users` (
    `id`,
    `langue`,
    `login`,
    `first_name`,
    `last_name`,
    `email`,
    `password`,
    `role`,
    `created_at`
) VALUES
      (1, 'fr', 'bob', 'Bob', 'Sull', 'bob@sull.com',
       '$2a$12$EyDxX5wWsrJGIyo2MFIRR.LqLmmqssUdPgwasMrG7TvZmjW9ECeLW', 'ADMIN', NOW()),
      (2, 'en', 'anna', 'Anna', 'Lyse', 'anna.lyse@sull.com',
       '$2a$12$EyDxX5wWsrJGIyo2MFIRR.LqLmmqssUdPgwasMrG7TvZmjW9ECeLW', 'MEMBER', NOW()),
      (3, 'fr', 'john', 'John', 'Doe', 'john.doe@sull.com',
       '$2a$12$EyDxX5wWsrJGIyo2MFIRR.LqLmmqssUdPgwasMrG7TvZmjW9ECeLW', 'MEMBER', NOW());
