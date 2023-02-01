package Mizut452.learn_law.Service;

import Mizut452.learn_law.Mapper.QuizMapper;
import Mizut452.learn_law.Mapper.UserQuizHistoryMapper;
import Mizut452.learn_law.Model.Entity.Login.LoginUser;
import Mizut452.learn_law.Model.Entity.Quiz.Quiz;
import Mizut452.learn_law.Model.Entity.Quiz.UserQuizHistory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

@Service
public class QuizQuestionService {

    @Autowired
    QuizMapper quizMapper;

    @Autowired
    UserQuizHistoryMapper userQuizHistoryMapper;

    private List<Integer> listQuestionId = new ArrayList<>();
    //問題数
    private int questionLength = 0;
    //問題番号
    private int questionNumber = 0;
    private int quizId = 0;
    //ユーザーの正解数
    private int userPoint = 0;
    //ユーザーの民法問題正解数
    private int userCivilPoint = 0;
    //ユーザーの刑法問題正解数
    private int userCriminalPoint = 0;
    //挑戦した民法問題数
    private int civilQuestionNo = 0;
    //挑戦した刑法問題数
    private int criminalQuestionNo = 0;

    public void addLoginUserMenu(@AuthenticationPrincipal LoginUser loginUser,
                                 Model model) {
        if (loginUser != null) {
            model.addAttribute("UserId", loginUser.getUserId());
        }
    }

    public void quizRanking(Model model) {
        model.addAttribute("QuizRank", userQuizHistoryMapper.usersQuizRank());
    }

    public int questionPrepare() {
        //初期化
        listQuestionId = new ArrayList<>();
        questionNumber = 0;
        userPoint = 0;
        userCriminalPoint = 0;
        userCivilPoint = 0;
        civilQuestionNo = 0;
        criminalQuestionNo = 0;
        quizId = 0;

        //出題する問題を選ぶ（questionIdを生成する）
        Random random = new Random();
        //いま登録されているクイズの数を呼び出す→乱数の範囲をクイズの問題の数だけに指定するため。
        int quizIdAll = quizMapper.selectQuizIdAll().size();

        //for文によって10個の乱数を生成する。＝10問の問題を出題する
        for (int i = 0; i < 10; ) {
            //Randomの仕様により0も出力されるため+1をして1~quizIdAll個出力するように
            int randomInt = random.nextInt(quizIdAll) + 1;
            //１つめは数が被ることがないため無条件でリストに格納
            if (i == 0) {
                listQuestionId.add(randomInt);
                i++;
            } else {
                //リストに入っている全ての数を確かめ、１つでも同じのがあればリストに入らないように
                int count = 0;
                //cにリストの値が代入されて比較し、randomIntと同じ値が出たらcountして除外。
                for (int c : listQuestionId) {
                    if (c == randomInt) {
                        count++;
                    }
                }
                if (count == 0) {
                    listQuestionId.add(randomInt);
                    i++;
                }
            }
        }
        quizId = listQuestionId.get(questionNumber);
        return quizId;
    }

    public void getQuizQuestionSent(int quizId,
                                    Model model) {
        List<Quiz> quizAllByQuizId = quizMapper.selectQuizAll(quizId);
        Quiz quizList = quizAllByQuizId.get(0);
        String quizSentence = quizList.getQuizQuestionSent();
        model.addAttribute("QuestionSentence", quizSentence);
    }

    public void goFinishQuiz(@AuthenticationPrincipal LoginUser loginUser) {
        if (questionNumber + 1 == 10) {
            if (loginUser != null) {
                UserQuizHistory userQuizHistory = userQuizHistoryMapper.quizHistoryMapperList(loginUser.getUserId());

                //プレイヤーが挑戦した問題数と正解数を足す
                int pointAll = userQuizHistory.getPointAll();
                int questionAll = userQuizHistory.getQuestionAll();
                int questionCivilAll = userQuizHistory.getCivilQuestionAll();
                int questionCriminalAll = userQuizHistory.getCriminalQuestionAll();
                int pointCivilLaw = userQuizHistory.getPointCivilLaw();
                int pointCriminalLaw = userQuizHistory.getPointCriminalLaw();

                userQuizHistory.setPointAll(pointAll + userPoint + 1);
                userQuizHistory.setQuestionAll(questionAll + questionNumber + 1);
                userQuizHistory.setCivilQuestionAll(questionCivilAll + civilQuestionNo + 1);
                userQuizHistory.setCriminalQuestionAll(questionCriminalAll + criminalQuestionNo + 1);
                userQuizHistory.setPointCivilLaw(pointCivilLaw + userCivilPoint + 1);
                userQuizHistory.setPointCriminalLaw(pointCriminalLaw + userCriminalPoint + 1);

                //insert文
                userQuizHistoryMapper.updateUserQuizHistory(userQuizHistory);
            }
        }
    }

    public void plusUserPandQNumber(Model model) {
        model.addAttribute("QuestionNumber", questionNumber+1);
        model.addAttribute("userPoint", userPoint+1);
    }

    public void quizQuestion(@AuthenticationPrincipal LoginUser loginUser,
                             Model model) {
        //クイズの問題がなくなったとき。
        if (questionNumber + 1 == questionLength) {
            if (loginUser != null) {

                UserQuizHistory userQuizHistory = userQuizHistoryMapper.quizHistoryMapperList(loginUser.getUserId());

                //プレイヤーが挑戦した問題数と正解数を足す
                int pointAll = userQuizHistory.getPointAll();
                int questionAll = userQuizHistory.getQuestionAll();
                int questionCivilAll = userQuizHistory.getCivilQuestionAll();
                int questionCriminalAll = userQuizHistory.getCriminalQuestionAll();
                int pointCivilLaw = userQuizHistory.getPointCivilLaw();
                int pointCriminalLaw = userQuizHistory.getPointCriminalLaw();

                userQuizHistory.setPointAll(pointAll + userPoint + 1);
                userQuizHistory.setQuestionAll(questionAll + questionNumber + 1);
                userQuizHistory.setCivilQuestionAll(questionCivilAll + civilQuestionNo + 1);
                userQuizHistory.setCriminalQuestionAll(questionCriminalAll + criminalQuestionNo + 1);
                userQuizHistory.setPointCivilLaw(pointCivilLaw + userCivilPoint + 1);
                userQuizHistory.setPointCriminalLaw(pointCriminalLaw + userCriminalPoint + 1);

                //insert文
                userQuizHistoryMapper.updateUserQuizHistory(userQuizHistory);
            }
            model.addAttribute("QuestionNumber", questionNumber + 1);
            model.addAttribute("userPoint", userPoint + 1);
        }
    }
}
