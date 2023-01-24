--パスワードは"top"
INSERT INTO userList(userId, email, username, password, roleName) VALUES(1, 'top@top.com', 'top', '$2a$10$0Jh/VfaS8k9HVfA3/f6lLuviOq8jVG0lGBRQNLUG8Fl69oHA7PmE6', 'ROLE_ADMIN');
--パスワードは"second"
INSERT INTO userList(userId, email, username, password, roleName) VALUES (2, 'second@second.com', 'second', '$2a$10$WtleMW4PbahhhxRTpQ0Gyu87FUxQJO0Cw6M.AV518/Cb3cTFeEy7e', 'ROLE_GENERAL');
--SECRET
INSERT INTO userList(userId, email, username, password, roleName) VALUES(3, 'ssvror444@gmail.com', 'Mizut452', '$2a$10$4dqctMrn.ivlJrYtnpR8B.62omHi4Ptw47N6HTUmdbHKOV4f87vbm', 'ROLE_ADMIN');

--クイスの問題文と答え
INSERT INTO quiz(quizId, quizQuestionSent, quizRightOrBad, quizCommentary, quizCategory) VALUES (1, '信義則は民法の基本である。', 1, '民法の基本の原則である', 'civil');
INSERT INTO quiz(quizId, quizQuestionSent, quizRightOrBad, quizCommentary, quizCategory) VALUES (2, '類推適用の原則は民法の基本の原則である。', 2, '民法の基本ではない', 'civil');
INSERT INTO quiz(quizId, quizQuestionSent, quizRightOrBad, quizCommentary, quizCategory) VALUES (3, '類推適用の原則とは、刑罰には時効を適用させなければならないという原則である。', 2, '類推適用の原則とは、刑法の条文を拡大解釈などをしてはならないという原則です。例えば殺人罪の成立要件は「人を殺す」ことであるが、それを拡大解釈して猿を殺したときにも殺人罪を適用させるのは類推適用になる。', 'criminal');
INSERT INTO quiz(quizId, quizQuestionSent, quizRightOrBad, quizCommentary, quizCategory) VALUES (4, '刑法199条とは殺人罪である', 1, 'その通りであり、刑法199条は殺人罪について規定した法律である。', 'criminal');
INSERT INTO quiz(quizId, quizQuestionSent, quizRightOrBad, quizCommentary, quizCategory) VALUES (5, 'ショッピングセンターの客が忘れた荷物は、刑法上、その荷物は持ち主なしになる', 2, 'その荷物はショッピングセンターの荷物になる。', 'criminal');
INSERT INTO quiz(quizId, quizQuestionSent, quizRightOrBad, quizCommentary, quizCategory) VALUES (6, '横領は窃盗罪の中の１つである。', 2, '横領罪と窃盗罪はまったく異なる罪である。', 'criminal');
INSERT INTO quiz(quizId, quizQuestionSent, quizRightOrBad, quizCommentary, quizCategory) VALUES (7, '刑法上、遺言　この感じの読みは「いごん」である。', 1, 'いごんである。ゆいごんではない。', 'criminal');
INSERT INTO quiz(quizId, quizQuestionSent, quizRightOrBad, quizCommentary, quizCategory) VALUES (8, '刑法上、一月　この漢字の読みは「いちげつ」である。', 1, 'いちげつと読む。いっかげつ、いちがつではない。', 'criminal');
INSERT INTO quiz(quizId, quizQuestionSent, quizRightOrBad, quizCommentary, quizCategory) VALUES (9, '刑法を英語で書くとcivil lawである', 2, 'criminal lawである。', 'criminal');
INSERT INTO quiz(quizId, quizQuestionSent, quizRightOrBad, quizCommentary, quizCategory) VALUES (10, '親が子を助けなかったら犯罪になる。', 1, 'その通り', 'criminal');
INSERT INTO quiz(quizId, quizQuestionSent, quizRightOrBad, quizCommentary, quizCategory) VALUES (11, '見知らぬ人が溺れていた時、その人を助けなければ犯罪となる。', 2, '犯罪とならない。', 'criminal');
INSERT INTO quiz(quizId, quizQuestionSent, quizRightOrBad, quizCommentary, quizCategory) VALUES (12, '外出時、人が忘れた物を盗むとそれは窃盗罪である。', 2, '遺失物横領罪となる', 'criminal');
INSERT INTO quiz(quizId, quizQuestionSent, quizRightOrBad, quizCommentary, quizCategory) VALUES (13, 'Ａさんの家にＢさんが荷物を忘れた。その荷物をＣさんが盗んでも犯罪とはならない。', 2, '大犯罪者である。', 'criminal');
INSERT INTO quiz(quizId, quizQuestionSent, quizRightOrBad, quizCommentary, quizCategory) VALUES (14, '成立要件とは、起訴が行われる要件の事である', 2, '犯罪が成立する要件の事である。', 'criminal');
INSERT INTO quiz(quizId, quizQuestionSent, quizRightOrBad, quizCommentary, quizCategory) VALUES (15, '人を殴って血が出ると傷害罪である。', 1, 'その通り！', 'criminal');