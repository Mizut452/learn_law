--パスワードは"top"
INSERT INTO userList(userId, email, username, password, roleName) VALUES(1, 'top@top.com', 'top', '$2a$10$0Jh/VfaS8k9HVfA3/f6lLuviOq8jVG0lGBRQNLUG8Fl69oHA7PmE6', 'ROLE_ADMIN');
--パスワードは"second"
INSERT INTO userList(userId, email, username, password, roleName) VALUES (2, 'second@second.com', 'second', '$2a$10$WtleMW4PbahhhxRTpQ0Gyu87FUxQJO0Cw6M.AV518/Cb3cTFeEy7e', 'ROLE_GENERAL');
--SECRET
INSERT INTO userList(userId, email, username, password, roleName) VALUES(3, 'ssvror444@gmail.com', 'Mizut452', '$2a$10$4dqctMrn.ivlJrYtnpR8B.62omHi4Ptw47N6HTUmdbHKOV4f87vbm', 'ROLE_ADMIN');

INSERT INTO userQuizHistory(history_userId, history_username, questionAll, civilQuestionAll, criminalQuestionAll, pointAll, pointCivilLaw, pointCriminalLaw) VALUES(1, 'top', 30, 8, 22, 23, 5, 18);
INSERT INTO userQuizHistory(history_userId, history_username, questionAll, civilQuestionAll, criminalQuestionAll, pointAll, pointCivilLaw, pointCriminalLaw) VALUES(2, 'second', 20, 2, 18, 11, 2, 9);
INSERT INTO userQuizHistory(history_userId, history_username, questionAll, civilQuestionAll, criminalQuestionAll, pointAll, pointCivilLaw, pointCriminalLaw) VALUES(3, 'Mizut452', 5, 1, 4, 3, 1, 2);

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

--掲示板表題
INSERT INTO LawBoard(lawBoard_id, lawBoard_username, lawBoard_category, lawBoard_title, lawBoard_mainComment, lawBoard_time) VALUES (1, 'top', '刑法', '類推適用禁止について教えてください！', '類推適用について教えていただきたいです！', '2023-02-01 13:00');

--掲示板コメント
INSERT INTO LawBoard_comment (boardParent_id, comment_id, comment, comment_time) VALUES (1, 1, 'どういったことでお困りでしょうか？', '2023-02-01 13:06');
INSERT INTO LawBoard_comment (boardParent_id, comment_id, comment, comment_time) VALUES (1, 2, '類推適用の禁止の範囲がわかりません。　例えば、199条の殺人罪において猿が範囲に入らないのはなぜなのでしょうか', '2023-02-01 2023-02-1 13:21');

--判例
INSERT INTO precedent(precedent_id, precedent_title, precedent_category, precedent_number,
                      precedent_subtitle, precedent_overview,
                       precedent_claim, precedent_judgement)
                      VALUES(1, '窃盗事件？遺失物横領事件？', 'criminal', '昭和３５（う）９２７号'
                             , '窃盗罪が成立する条件とは？',
                             '',
                             '',
                             '');
INSERT INTO precedent(precedent_id, precedent_title, precedent_category, precedent_number,
                      precedent_subtitle, precedent_overview,
                      precedent_claim, precedent_judgement)
                      VALUES(2, '民法', 'civil', '昭和３５（う）９２７号'
                             , '民法が成立する条件とは？',
                             '',
                             '',
                             '');
INSERT INTO precedent(precedent_id, precedent_title, precedent_category, precedent_number,
                      precedent_subtitle, precedent_overview,
                       precedent_claim, precedent_judgement)
                      VALUES(3, '著作権？', 'copyright', '昭和３５（う）９２７号'
                             , '著作権が成立する条件とは？',
                             '',
                             '',
                             '');
INSERT INTO precedent(precedent_id, precedent_title, precedent_category, precedent_number,
                      precedent_subtitle, precedent_overview, precedent_claim, precedent_judgement)
                      VALUES(4, 'ASKA事件', 'copyright', '平２９（ワ）２７３７４号'
                             , 'アーティストがまだ公表していない曲を他人が勝手に公表してしまったら？',
                             '被告Xさんは出演していたテレビの放送番組内において、アーティストであるASKAさんの捜索した未発表の楽曲の一部をASKAさんの許可なく番組内で再生した。これに対して、ASKAさんは、Ｘさんが著作権と公表権を侵害したとして損害賠償金3307万円を請求した。',
                             '被告Ｘたちの主張
                              ①楽曲の公表は無許可で行ったわけではない
                              　ASKAさんは、Ｘさんが芸能リポーターであることを知っている上で、なおかつ「外に公表しないでほしい」との断りもなく、被告Xさんに未発表の楽曲を送信した。
                              　被告Xは、芸能リポーターとして、様々な媒体で広く情報を発信することを前提として芸能人の情報を入手しているため、ASKAさんが被告Xに楽曲を送信するにあたって、被告Xが送信した楽曲を公表してしまうことを認識していたはずである。そのため無許可で行ったとはいえないと主張した。

                              原告の反論
                              　ASKAさんは、芸能リポーターとして芸能に携わっている被告Ｘに楽曲を聴いてもらって得、その感想を参考にするために提供したのである。さらに被告Ｘにはそのことを伝え、なおかつ楽曲を公開しないことを求めていた。そのため、本件の楽曲は無許可で行われたというほかない。


                              ②著作権法41条の時事の事件の報道のための利用にあたるものである
                              【前提：著作権法41条：どのような事件なのかについて、又は事件の過程を説明するために必要な著作物は報道の目的上正当な範囲において複製、利用することができる。】

                              　被告Xは、今回の番組において(1)警察庁がASKAさんを覚せい剤使用の疑いで逮捕する方針であること、(2)ASKAさんが有罪判決を受けた後の執行猶予期間中に音楽活動を行い更生に向けた活動をしていたこと、(3)今回の楽曲は②でのASKAさんが更生中に作られた楽曲で、②の時事の事件を構成するものであることなどから、今回の番組内における楽曲の再生は著作権法41条に基づく適法な利用であると主張

                              原告の反論
                              　そもそも(2) ASKAさんが有罪判決を受けた後の執行猶予期間中に音楽活動を行い更生に向けた活動をしていたということは、ASKAさんの音楽活動の状況に関するものであって、そもそも時事の事件に該当しない。また(1)の警察庁がASKAさんを覚せい剤使用の疑いで逮捕する方針であることについては、時事の事件に該当するものの音楽活動の内容とは関係がなく、今回再生された楽曲は、著作権法41条のいう時事の事件を構成するものではない。


                              ③正当業務行為などによって公表権侵害の行為が適法になる
                              【前提：正当業務行為とは、例えその行為が法律に触れる行為であっても、その行為が正当な業務による行為であれば、違法性が認められず適法になる。】

                              　今回の番組内での楽曲の再生は、執行猶予中のASKAさんが覚せい剤の使用により逮捕されそうであるという差し迫った状況において、有罪判決後のASKAさんの音楽活動や更生に向けた活動などを具体的に報道するという表現の自由に照らして重要な目的をもっておこなわれたものであったことなどから、今回の被告Ｘの楽曲の再生は、正当業務行為などの事由によって適法な行為になるべき。

                              原告の反論
                              　被告Ｘたちは、覚せい剤使用の疑いとは何ら関係のない楽曲をASKAさんに無断で放送したものであって、楽曲を再生する正当な理由も認められないから違法性があることは明らかである。
                              　さらに、芸能リポーターも法令を守って業務を行う必要があり、番組内で今回の楽曲が再生された前後において、ASKAさんの更生について今回の楽曲と関連付けたやりとりをしておらず、楽曲の感想を少し述べただけで終了したことから、ASKAさんが更生していることを示すために楽曲を再生したというのは後付けの理由であり、楽曲の一番重要である箇所を再生したことから、必要最低限の行為であったともいえない。よって被告Ｘの行為は正当業務行為には当たらない。',
                             '①楽曲の公表は無許可で行ったわけではない
                              証拠からASKAさんは被告Ｘに対して、楽曲の感想を聞くために楽曲のデータを送った。そしてその際、楽曲の感想を聞くためという目的も伝えた。被告Ｘはそれを承諾した。（ASKAさんが楽曲を公開しないようにと言ったことについては証拠不十分でその主張は採用されなかった）

                              このことから、ASKAさんはあくまでも感想を聞くために楽曲のデータを送ったのであって、被告人の職業を考えても、許可をしたものであるといえない。

                              ②著作権法41条の時事の事件の報道のための利用にあたるものである
                              　被告Ｘたちは、楽曲は、①「警察庁がASKAさんを覚せい剤使用の疑いで逮捕する方針であること」という時事の事件を構成するもので、②ASKAさんが執行猶予期間中に更生に向けて行っていた音楽活動の成果物であること、この２点から「ASKAさんが有罪判決後に更生のための活動を行っている」という時事の事件を構成するものであるという主張しているが、今回の楽曲は、警察庁が原告に対する覚せい剤使用の疑いで逮捕状を請求する予定であるという時事の事件の主題になるものでなく、この事件と直接関係のあるものでもないため、時事の事件を構成する著作物に当たると認められない。

                              ③正当業務行為などによって公表権侵害の行為が適法になる
                              　番組内においては、ASKAさんの音楽活動に軽く触れただけであって、音楽活動の具体的な紹介がないものであること、ASKAさんが更生していることを示すために音楽データの一部を再生したものであるから芸能リポーターとしての正統な業務行為を行ったまでである主張に対しては、ASKAさんの具体的な音楽活動の紹介がないまま、音楽データの一部を再生したとしても、ASKAさんが更生していることを具体的に示すものではないからこの主張も認められるものではない。

                              これらから原告の主張が認められ、公表権の侵害等が認められることから慰謝料の額は100万円と認める。'
                              );