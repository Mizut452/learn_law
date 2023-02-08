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
INSERT INTO quiz(quizId, quizQuestionSent, quizRightOrBad, quizCommentary, quizCategory, quizAuthor) VALUES (1, 'プログラミング言語は著作権法によって保護されている', 2, '正解は×。プログラミング言語は著作権法の例外となっている。著作権法10条3項3号において著作権法の例外として定められている。', '著作権法', 'top');
INSERT INTO quiz(quizId, quizQuestionSent, quizRightOrBad, quizCommentary, quizCategory, quizAuthor) VALUES (2, '人が作ったプログラムは著作権法によって保護されるため、他人のプログラムを自分のものにしてはいけない。', 1, '正解は〇。　著作権法10条9号において著作権法における著作物の１つとして「プログラムの著作物」があげられている。もし人の作ったプログラムを例えば自分が作ったとして記事を書いてしまうと、それは著作権法違反となる。', '著作権法', 'top');
INSERT INTO quiz(quizId, quizQuestionSent, quizRightOrBad, quizCommentary, quizCategory, quizAuthor) VALUES (3, '刑法には法律の文章を拡大解釈してはいけない（類推適用の原則という）という原則があるため、猿を殺した人に対して殺人罪を適用させることは許されない。', 1, '正解は〇。問題文の通りである。これは刑法の条文に書かれていないことはしてはいけない（罪刑法定主義）という原則から導き出されたものである。', '刑法', 'top');
INSERT INTO quiz(quizId, quizQuestionSent, quizRightOrBad, quizCommentary, quizCategory, quizAuthor) VALUES (4, '池の底に落ちてしまって数か月経つゴルフ場のボールを利用者が自分の物にしたとき、それは犯罪とはならない。', 2, '正解は×。　問題文のボールを盗む行為は、そのゴルフ場がボールの再利用を予定した場合、そのゴルフボールは持ち主なしではなく、ゴルフ場の持ち物となるため遺失物横領罪という落とし物を盗んだ時に適用される罪に該当する。', '刑法', 'top');
INSERT INTO quiz(quizId, quizQuestionSent, quizRightOrBad, quizCommentary, quizCategory, quizAuthor) VALUES (5, 'Ａ君はＢ君から借りたカセットを自分のものにしてしまった。この時、適用される刑法は人の物を盗んだため窃盗罪である。', 2, '正解は×。　窃盗罪は他人に占有がある（他人が持っている）物を盗んだ時に適用される罪である。今回の場合は、（Ｂ君から借りることによって）自分が所有するカセットを自分のものにしたため、横領罪が適用される。', '刑法', 'top');
INSERT INTO quiz(quizId, quizQuestionSent, quizRightOrBad, quizCommentary, quizCategory, quizAuthor) VALUES (6, '子どもが親の財布からお金を盗んだ時、親が許していたとしても刑法が適用され否が応でも裁判になる。', 2, '正解は×。　刑法244条において家族や同居の親族の間で窃盗などを行ったとしても無罪となると規定されている。ただし、強盗には適用されない。', '刑法', 'top');
INSERT INTO quiz(quizId, quizQuestionSent, quizRightOrBad, quizCommentary, quizCategory, quizAuthor) VALUES (7, '恐喝罪における恐喝とは、相手を怖がらせることであるため、どんなに強い言葉で脅したとしても相手が怖がらなければ恐喝罪は適用されない。', 1, '正解は〇。　問題文の通りである。恐喝罪における恐喝とは相手を怖がらせることである。さらにその恐喝は、財産に関わるもののために行わなければ恐喝罪とはならない。', '刑法', 'top');
INSERT INTO quiz(quizId, quizQuestionSent, quizRightOrBad, quizCommentary, quizCategory, quizAuthor) VALUES (8, '条文（法律の文）には著作権がないが、「意外と知らない法律」のようにみんなが知らない法律を紹介する本などには著作権が認められる', 1, '正解は〇。　問題文の通り、著作権法12条において、著作権が適用されない物でもそれを独自の方法で編集したりしたものは、著作権法の保護の対象となる。', '著作権法', 'top');
INSERT INTO quiz(quizId, quizQuestionSent, quizRightOrBad, quizCommentary, quizCategory, quizAuthor) VALUES (9, '著作権の保護は作成者の死後70年間である。そのため2023年末にミッキーマウスは著作権フリーとなり、誰もが使い放題の素材となる。', 2, '正解は×。　著作権は確かに切れてしまうが、ディズニー社は、ミッキーマウスを商標登録しているため無断で使用すると権利侵害となる。', '著作権法', 'top');
INSERT INTO quiz(quizId, quizQuestionSent, quizRightOrBad, quizCommentary, quizCategory, quizAuthor) VALUES (10, 'Ａさんはイラストレーターにイラストを書いてもらうように頼み、それを受け取ったが背景が少し気に入らなかったので描きかえた。このＡさんの行為は著作権法違反になる。', 1, '正解は〇。　著作権者には著作物を他人に変えられないという同一性保持権をもつ。そのためＡさんの行った描きかえるという行為は著作権法違反となる。', '著作権法', 'top');
INSERT INTO quiz(quizId, quizQuestionSent, quizRightOrBad, quizCommentary, quizCategory, quizAuthor) VALUES (11, 'ＣＤに入っている曲を自分のスマホに取り入れる行為は著作権法違反となる。', 2, '正解は×。　著作権法30条によって著作物を個人的に使用する場合は、著作物をコピーをすることができる。', '著作権法', 'second');
INSERT INTO quiz(quizId, quizQuestionSent, quizRightOrBad, quizCommentary, quizCategory, quizAuthor) VALUES (12, '未成年の結婚は親の同意が必要であるため、親が許可しなければ結婚することができない', 2, '正解は×。　結婚は18歳以上しかできないことに加え、2022年の民法改正において成人年齢が18歳に引き下げられたことによって未成年の結婚は不可能となった。', '民法', 'top');
INSERT INTO quiz(quizId, quizQuestionSent, quizRightOrBad, quizCommentary, quizCategory, quizAuthor) VALUES (13, '未成年であるＡ君は親の許可なしに、さらに親のお金でコンビニでアイスを購入した。Ａ君のこの行為は取り消すことができるため、アイスを返品できる。', 1, '正解は〇。 未成年者がする行為は民法で制限がかけられ、親の同意なしで行った場合その行為は取り消すことができる。しかし、例外として民法5条において親が与えたお小遣いなどは取り消すことができないとしているが、今回A君は親のお金でしていることから今回の契約は取り消すことができる。', '刑法', 'Mizut452');
INSERT INTO quiz(quizId, quizQuestionSent, quizRightOrBad, quizCommentary, quizCategory, quizAuthor) VALUES (14, '一夫一妻制は日本の文化的なものであることから、しようと思えば複数の人と婚姻関係になることができる。', 2, '正解は×。　民法732条において複数の人と重ねて婚姻をすることが禁止されている。', '民法', 'top');
INSERT INTO quiz(quizId, quizQuestionSent, quizRightOrBad, quizCommentary, quizCategory, quizAuthor) VALUES (15, '逃亡中の犯人をかくまうと犯罪となるが、その犯人と家族の関係にあればその刑は免除される。', 1, '正解は〇。　刑法105条は犯人の親族にある者が犯人をかくまっても無罪としている。', '刑法', 'top');

--掲示板表題
INSERT INTO LawBoard(lawBoard_id, lawBoard_username, lawBoard_category, lawBoard_title, lawBoard_mainComment, lawBoard_time) VALUES (1, 'top', '刑法', '殺人罪について教えてください！', '殺人罪について教えていただきたいです！', '2023-02-01 13:00');

--掲示板コメント
INSERT INTO LawBoard_comment (boardParent_id, comment_id, comment, comment_time, comment_username) VALUES (1, 1, 'どういったことでお困りでしょうか？', '2023-02-01 13:06', 'second');
INSERT INTO LawBoard_comment (boardParent_id, comment_id, comment, comment_time, comment_username) VALUES (1, 2, '殺人罪って人を殺したときに適用される罪ですよね？　それにもかかわらずヒト科であるオランウータンを殺しても殺人罪が適用されないのはなぜなのでしょうか', '2023-02-01 13:21', 'top');

--判例
INSERT INTO precedent(precedent_id, precedent_title, precedent_category, precedent_number,
                      precedent_subtitle, precedent_overview,
                       precedent_claim, precedent_judgement)
                      VALUES(1, '窃盗事件？遺失物横領事件？', '刑法', '昭和３５（う）９２７号'
                             , '加害者が落とし物と認識して、他人の物を盗んだ時どうなる？'
                             ,
                             '被害者は、切符を購入するために置いたカメラを忘れて改札を通ろうとしたが、すぐに気づいて取りに戻ったが、すでにカメラは加害者Xによって盗まれていた。しかし、加害者Xは周囲の人にカメラを忘れていないか聞き、誰も忘れていないと言ったのでそのカメラを被害者が数分前に置き忘れた物ということを全く認識せず、所有者不明の忘れ物と認識してそのカメラを得た。
                              　まず、窃盗罪と遺失物等横領罪の両者の関係である。窃盗罪は「他人の物」を盗んだ時、遺失物等横領罪は「他人の手にない物（占有のない物）」を盗んだ時に成立する犯罪である。
                              ここで問題となるのが①このカメラは被害者の手にない物として認識されるのか否か、②仮に被害者の手にある物として認められた場合、被害者目線では窃盗罪、加害者目線では遺失物等横領罪になる。この際、刑法上どのように処理されるのか。この点をみていく。'
                              ,
                             '被害者（検察官）側の主張は、カメラを置き忘れたのは確かだが、５分も経たずにすぐに引き返したため、被害者の手にある物として認められるべき。さらに被害者の手にある物と認められるなら、遺失物等横領罪ではなく、窃盗罪が適用されるべきと主張した。
                              それに対して加害者側の主張は、加害者の目線からすれば、カメラを置き忘れた物ということを知る由もない。さらに加害者はカメラを持ち去る際、周囲の人間にこのカメラは「あなたの物ですか」と聞き、誰もが違うと答えたので所有者不明の忘れ物だと考えた。よって窃盗罪は該当しないと主張した。'
                              ,
                             '被害者が主張するように置き忘れてすぐに取りに戻った場合、社会一般的に考えて被害者の占有を離れたということはできない。さらに過去の判例においても、置き忘れたことに気づいてすぐに引き返した場合には、その物の占有は離れていないとしている。
                              　しかし、今回の犯人はカメラが誰の所有物であるかが全く分からず、完全に落とし物と認識して持ち去っている。この場合刑法38条の「重い罪に当たるべき行為をしたのに、行為の時にその重い罪に当たることとなる事実を知らなかった者は、その重い罪によって処断することはできない」という条文に当てはまるため、たとえ、見かけ上窃盗の罪をしていたとしても、加害者が重い罪である窃盗罪に当たると知らなければ窃盗罪を当てはめることはできない。これらから遺失物等横領罪が適当であると判断した。'
                              );
INSERT INTO precedent(precedent_id, precedent_title, precedent_category, precedent_number,
                      precedent_subtitle, precedent_overview,
                      precedent_claim, precedent_judgement)
                      VALUES(2, 'いいねが侮辱に？', '民法', '令４（ネ）１９２２号'
                             , 'いいねが侮辱にあたる理由',
                             '',
                             '',
                             '');
INSERT INTO precedent(precedent_id, precedent_title, precedent_category, precedent_number,
                      precedent_subtitle, precedent_overview,
                       precedent_claim, precedent_judgement)
                      VALUES(3, '著作権？', '民法', '昭和３５（う）９２７号'
                             , '著作権が成立する条件とは？',
                             '',
                             '',
                             '');
INSERT INTO precedent(precedent_id, precedent_title, precedent_category, precedent_number,
                      precedent_subtitle, precedent_overview, precedent_claim, precedent_judgement)
                      VALUES(4, 'ASKA事件', '著作権法', '平２９（ワ）２７３７４号'
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