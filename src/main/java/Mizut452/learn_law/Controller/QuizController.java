package Mizut452.learn_law.Controller;

import Mizut452.learn_law.Mapper.QuizMapper;
import Mizut452.learn_law.Mapper.UserQuizHistoryMapper;
import Mizut452.learn_law.Model.Entity.Login.LoginUser;
import Mizut452.learn_law.Model.Entity.Quiz.Quiz;
import Mizut452.learn_law.Model.Entity.Quiz.UserQuizHistory;
import Mizut452.learn_law.Service.QuizQuestionService;
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

    @Autowired
    QuizQuestionService quizQuestionService;

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
    public String quizHome(@AuthenticationPrincipal LoginUser loginUser,
                           Model model) {

        quizQuestionService.addLoginUserMenu(loginUser, model);

        //クイズランキング上位5位の取得
        quizQuestionService.quizRanking(model);
                return "Quiz/quizStartPage";
            }



    @GetMapping("/quiz/question")
    public String quizQuestionPrepare(Model model) {
        int quizId = quizQuestionService.questionPrepare();

        return "redirect:/quiz/question/" + quizId + "/";
    }

    @GetMapping("/quiz/question/{quizId}/")
    public String quizQuestion(@PathVariable int quizId,
                               @AuthenticationPrincipal LoginUser loginUser,
                               Model model) {
        quizQuestionService.addLoginUserMenu(loginUser, model);
        quizQuestionService.getQuizQuestionSent(quizId, model);
        quizQuestionService.goFinishQuiz(loginUser);
        quizQuestionService.plusUserPandQNumber(model);

        return "Quiz/quizQuestionPage";

    }

    @PostMapping("/quiz/question/{quizId}/judge/")
    public String quizJudge(Model model,
                            @PathVariable int quizId,
                            @ModelAttribute Quiz quiz,
                            @AuthenticationPrincipal LoginUser loginUser) {
        quizQuestionService.addLoginUserMenu(loginUser, model);
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
            if(quizMapper.selectCategory(quizId).equals("民法")){
                userPoint++;
                userCivilPoint++;
                civilQuestionNo++;

                return "Quiz/quizRightPage";
            }
            //正解ポイント、刑法問題ポイント、刑法正解ポイントを増やす
            if(quizMapper.selectCategory(quizId).equals("刑法")) {
                userPoint++;
                userCriminalPoint++;
                criminalQuestionNo++;

                return "Quiz/quizRightPage";
            }
        }

        //不正解の場合
        else {
            //正解ポイントは加算せず、民法問題ポイントのみを加算
            if(quizMapper.selectCategory(quizId).equals("民法")) {
                civilQuestionNo++;

                return "Quiz/quizBadPage";
            }
            //正解ポイントは加算せず、刑法問題ポイントのみを加算
            if(quizMapper.selectCategory(quizId).equals("刑法")) {
                criminalQuestionNo++;

                return "Quiz/quizBadPage";
            }
        }
        return "error";
    }
}