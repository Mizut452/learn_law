--パスワードは"top"
INSERT INTO userList(userId, email, username, password, roleName) VALUES(1, 'top@top.com', 'top', '$2a$10$0Jh/VfaS8k9HVfA3/f6lLuviOq8jVG0lGBRQNLUG8Fl69oHA7PmE6', 'ROLE_ADMIN');
--パスワードは"second"
INSERT INTO userList(userId, email, username, password, roleName) VALUES (2, 'second@second.com', 'second', '$2a$10$WtleMW4PbahhhxRTpQ0Gyu87FUxQJO0Cw6M.AV518/Cb3cTFeEy7e', 'ROLE_GENERAL');
--SECRET
INSERT INTO userList(userId, email, username, password, roleName) VALUES(3, 'ssvror444@gmail.com', 'Mizut452', '$2a$10$4dqctMrn.ivlJrYtnpR8B.62omHi4Ptw47N6HTUmdbHKOV4f87vbm', 'ROLE_ADMIN');

--クイスの問題文と答え
INSERT INTO quiz(quizId, quizQuestionSent, quizRightOrBad, quizCommentary) VALUES (1, 'パンはパンでも食べられないパンはフライパンである。', 1, 'これは有名ななぞなぞ問題である。パンという食べられるものであっても、その前にフライという文字がくっつくと料理で使うフライパンとなり、食べられないものになる。');
INSERT INTO quiz(quizId, quizQuestionSent, quizRightOrBad, quizCommentary) VALUES (2, '４つの岩を持っている生き物とはガンジーである。', 2, '岩４（いわし）とのダジャレである。');
INSERT INTO quiz(quizId, quizQuestionSent, quizRightOrBad, quizCommentary) VALUES (3, '手のひらをくっつける文房具ではない「のり」とは、ノリノリである', 2, 'ノリノリの時、必ずしも手のひらをくっつけるものではない。答えはいのりである。');
INSERT INTO quiz(quizId, quizQuestionSent, quizRightOrBad, quizCommentary) VALUES (4, 'Javaにおいて繰り返しの処理ができるのは、「for文」だけではない', 1, 'for, while文などがある。');
INSERT INTO quiz(quizId, quizQuestionSent, quizRightOrBad, quizCommentary) VALUES (5, 'Javaにおいて条件分岐の処理ができるのは、「if文」だけである', 2, 'if文、switch文,がある。');
INSERT INTO quiz(quizId, quizQuestionSent, quizRightOrBad, quizCommentary) VALUES (6, 'たぬき、きつね、ねこ、この中で仲間はずれなのはきつねである。', 2, 'ここに上げられるたぬき、きつね、ねこは三者ともに動物であり、仲間外れといえない');
INSERT INTO quiz(quizId, quizQuestionSent, quizRightOrBad, quizCommentary) VALUES (7, '残暑　この感じの読みは「ざんしょ」である。', 1, '正解、のこりなつではない');
INSERT INTO quiz(quizId, quizQuestionSent, quizRightOrBad, quizCommentary) VALUES (8, '2022年紅白歌合戦でVaundyがうたった歌とは、しわあわせではない。', 1, '怪獣の花唄である');
INSERT INTO quiz(quizId, quizQuestionSent, quizRightOrBad, quizCommentary) VALUES (9, 'Money この単語の意味は「ロックオン」である。', 2, 'お金');
INSERT INTO quiz(quizId, quizQuestionSent, quizRightOrBad, quizCommentary) VALUES (10, 'キャベツは野菜である', 1, 'レタス同様にキャベツは野菜である。');
INSERT INTO quiz(quizId, quizQuestionSent, quizRightOrBad, quizCommentary) VALUES (11, 'DXはでらっくすと読む', 2, 'DXはデジタルトランスフォーメーションの略である。');
INSERT INTO quiz(quizId, quizQuestionSent, quizRightOrBad, quizCommentary) VALUES (12, 'SQLはWebページのデザインを作るものである', 2, 'ＳＱＬはデータベースを操作する言語である・');
INSERT INTO quiz(quizId, quizQuestionSent, quizRightOrBad, quizCommentary) VALUES (13, 'JavaScriptはJavaのフレームワークの１つである。', 2, 'JavaScriptとJavaは異なる言語である。');
INSERT INTO quiz(quizId, quizQuestionSent, quizRightOrBad, quizCommentary) VALUES (14, '拡張子、txtは画像ファイルである。', 2, 'テキストファイルである');
INSERT INTO quiz(quizId, quizQuestionSent, quizRightOrBad, quizCommentary) VALUES (15, '拡張子、csvファイルはJavaScriptのファイルでない', 1, 'CSVファイルとは、値や項目を,で区切って書いたテキストファイル・データである。');