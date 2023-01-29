package Mizut452.learn_law.Controller;

import Mizut452.learn_law.Mapper.QuizMapper;
import Mizut452.learn_law.Mapper.UserQuizHistoryMapper;
import Mizut452.learn_law.Model.Entity.Login.LoginUser;
import Mizut452.learn_law.Model.Entity.Quiz.Quiz;
import Mizut452.learn_law.Model.Entity.Quiz.UserQuizHistory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.*;

@Controller
public class QuizController {
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


    @RequestMapping("/quiz")
    public String quizHome(Model model) {
        //クイズランキング上位5位の取得
        model.addAttribute("QuizRank", userQuizHistoryMapper.usersQuizRank());
                return "Quiz/quizStartPage";
            }



    @GetMapping("/quiz/question")
    public String quizQuestionPrepare(Model model) {
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
        questionLength = 10;
        int quizIdAll = quizMapper.selectQuizIdAll().size();

        //for文によってquestionLength個の乱数を生成する。
        for (int i = 0; i < questionLength;) {
            //1~10が乱数
            int randomInt = random.nextInt(quizIdAll) + 1;
            if (i == 0) {
                listQuestionId.add(randomInt);
                i++;
            } else {
                int count = 0;
                for(int c : listQuestionId) {
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

        return "redirect:/quiz/question/" + quizId + "/";
    }

    @GetMapping("/quiz/question/{quizId}/")
    public String quizQuestion(@PathVariable int quizId,
                               @AuthenticationPrincipal LoginUser loginUser,
                               Model model) {
        List<Quiz> quizAllByQuizId = quizMapper.selectQuizAll(quizId);
        Quiz quizList = quizAllByQuizId.get(0);
        String quizSentence = quizList.getQuizQuestionSent();

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
            return "Quiz/quizResult";
        }

        model.addAttribute("QuestionNumber", questionNumber + 1);
        model.addAttribute("QuestionSentence", quizSentence);
        model.addAttribute("quizId", quizId);

        return "Quiz/quizQuestionPage";

    }

    @PostMapping("/quiz/question/{quizId}/judge/")
    public String quizJudge(Model model,
                            @PathVariable int quizId,
                            @ModelAttribute Quiz quiz,
                            @AuthenticationPrincipal LoginUser loginUser) {
        //クイズの〇、×の確認
        //quizId = listQuestionId.get(questionNumber);
        List<Quiz> quizAllByQuizId = quizMapper.selectQuizAll(quizId);

        Quiz quizList = quizAllByQuizId.get(0);
        int questionAnswer = quizList.getQuizRightOrBad();

        //クイズの解説文の取り出し
        String questionCommentary = quizList.getQuizCommentary();
        model.addAttribute("QuestionCommentary", questionCommentary);

        //送信された〇、×の確認
        quiz.setQuizUsersAnswer(quiz.getQuizUsersAnswer());
        quizList.setQuizUsersAnswer(quizList.getQuizUsersAnswer());
        int rightOrBad = quiz.getQuizUsersAnswer();

        questionNumber++;
        int nextQuizId = listQuestionId.get(questionNumber);
        model.addAttribute("quizId", quizId);
        model.addAttribute("nextQuizId", nextQuizId);

        //正解の場合
        if (questionAnswer == rightOrBad) {
            //正解ポイント、民法問題ポイント、民法正解ポイントを増やす
            if(quizMapper.selectCategory(quizId).equals("civil")){
                userPoint++;
                userCivilPoint++;
                civilQuestionNo++;

                return "Quiz/quizRightPage";
            }
            //正解ポイント、刑法問題ポイント、刑法正解ポイントを増やす
            if(quizMapper.selectCategory(quizId).equals("criminal")) {
                userPoint++;
                userCriminalPoint++;
                criminalQuestionNo++;

                return "Quiz/quizRightPage";
            }
        }

        //不正解の場合
        else {
            //正解ポイントは加算せず、民法問題ポイントのみを加算
            if(quizMapper.selectCategory(quizId).equals("civil")) {
                civilQuestionNo++;

                return "Quiz/quizBadPage";
            }
            //正解ポイントは加算せず、刑法問題ポイントのみを加算
            if(quizMapper.selectCategory(quizId).equals("criminal")) {
                criminalQuestionNo++;

                return "Quiz/quizBadPage";
            }
        }
        return "error";
    }
}