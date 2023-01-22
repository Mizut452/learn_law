--役割テーブル
INSERT INTO roles(id, name) VALUES(1, 'ROLE_ADMIN');
INSERT INTO roles(id, name) VALUES(2, 'ROLE_GENERAL');

--パスワードは"top"
INSERT INTO userList(userId, email, username, password) VALUES(1, 'top@example.com', 'top', '$2a$10$0Jh/VfaS8k9HVfA3/f6lLuviOq8jVG0lGBRQNLUG8Fl69oHA7PmE6');
--パスワードは"second"
INSERT INTO userList(userId, email, username, password) VALUES(2, 'second@example.com', 'admin', '$2a$10$WtleMW4PbahhhxRTpQ0Gyu87FUxQJO0Cw6M.AV518/Cb3cTFeEy7e');
--SECRET
INSERT INTO userList(userId, email, username, password) VALUES(3, 'ssvror444@gmail.com', 'Mizut452', '$2a$10$4dqctMrn.ivlJrYtnpR8B.62omHi4Ptw47N6HTUmdbHKOV4f87vbm');

--ユーザー役割テーブル
INSERT INTO user_role(user_id, role_id) VALUES(1, 1);
INSERT INTO user_role(user_id, role_id) VALUES(2, 1);
INSERT INTO user_role(user_id, role_id) VALUES(2, 2);
INSERT INTO user_role(user_id, role_id) VALUES (3, 1);
INSERT INTO user_role(user_id, role_id) VALUES (3, 2);