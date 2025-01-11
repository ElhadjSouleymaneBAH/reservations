INSERT INTO role_user (role_id, user_id) VALUES
                                             (1, 1),  -- Utilisateur 1 (ADMIN)
                                             (2, 1),  -- Utilisateur 1 (USER) - un administrateur peut aussi être utilisateur normal
                                             (2, 2),  -- Utilisateur 2 (USER)
                                             (3, 2);  -- Utilisateur 2 (MANAGER)
