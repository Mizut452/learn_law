package Mizut452.learn_law.Controller;

import Mizut452.learn_law.Mapper.QuizMapper;
import Mizut452.learn_law.Mapper.UserQuizHistoryMapper;
import Mizut452.learn_law.Model.Entity.Login.LoginUser;
import Mizut452.learn_law.Model.Entity.Quiz.Quiz;
import Mizut452.learn_law.Model.Entity.Quiz.QuizUpdateReq;
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
    QuizQuestionService quizQuestionService;

    //問題番号
    private int questionNumber = 0;
    private int questionAnswer = 0;
    private int rightOrBad = 0;


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
        questionNumber = 0;
        int quizId = quizQuestionService.questionPrepare();

        return "redirect:/quiz/question/" + quizId + "/";
    }

    @GetMapping("/quiz/question/{quizId}/")
    public String quizQuestion(@PathVariable int quizId,
                               @AuthenticationPrincipal LoginUser loginUser,
                               Model model) {
        quizQuestionService.addLoginUserMenu(loginUser, model);
        if(questionNumber == 10) {
            quizQuestionService.goFinishQuiz(loginUser, model);
            return "Quiz/quizResult";
        }
        quizQuestionService.getQuizQuestionSent(quizId, model);
        quizQuestionService.plusUserPandQNumber(model);

        return "Quiz/quizQuestionPage";

    }

    @PostMapping("/quiz/question/{quizId}/judge/")
    public String quizJudge(Model model,
                            @PathVariable int quizId,
                            @ModelAttribute Quiz quiz,
                            @AuthenticationPrincipal LoginUser loginUser) {
        questionNumber++;
        quizQuestionService.addLoginUserMenu(loginUser, model);
        quizQuestionService.verificationAnswer(quizId, model, quiz);
        rightOrBad = quiz.getQuizUsersAnswer();
        quiz = quizMapper.selectQuizByQuizId(quizId);
        questionAnswer = quiz.getQuizRightOrBad();

        if(questionAnswer == rightOrBad) {
            quizQuestionService.trueQuestion(quizId);
            return "Quiz/quizRightPage";
        } else {
            quizQuestionService.falseQuestion(quizId);
            return "Quiz/quizBadPage";
        }
    }

    @GetMapping("/quiz/questionList")
    public String quizList(@AuthenticationPrincipal LoginUser loginUser,
                           Model model) {
        quizQuestionService.addLoginUserMenu(loginUser, model);
        quizQuestionService.quizList(loginUser, model);

        return "Quiz/quizList";
    }

    @RequestMapping("/quiz/questionList/{quizId}/update/")
    public String quizUpdate(@PathVariable int quizId,
                             @ModelAttribute QuizUpdateReq quizUpdateReq,
                             Model model) {
        quizQuestionService.quizUpdate(quizId, quizUpdateReq, model);
        return "Quiz/quizUpdate";
    }
}