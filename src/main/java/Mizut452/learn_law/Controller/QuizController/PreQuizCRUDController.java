package Mizut452.learn_law.Controller.QuizController;

import Mizut452.learn_law.Mapper.QuizMapper;
import Mizut452.learn_law.Model.Entity.Login.LoginUser;
import Mizut452.learn_law.Model.Entity.Quiz.Quiz;
import Mizut452.learn_law.Service.PreQuizService;
import Mizut452.learn_law.Service.QuizQuestionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class PreQuizCRUDController {

    @Autowired
    PreQuizService preQuizService;

    @Autowired
    QuizQuestionService quizQuestionService;

    @Autowired
    QuizMapper quizMapper;

    //いいねの処理
    @GetMapping("/quiz/preQuiz/good/{quizId}/")
    public String quizPreGood(@PathVariable int quizId) {
        preQuizService.addGoodService(quizId);

        return "redirect:/quiz/preQuiz";
    }

    //プレクイズ作成画面
    @GetMapping("/quiz/preQuiz/createQuiz")
    public String quizPreQuizCreate(@AuthenticationPrincipal LoginUser loginUser,
                                    Quiz quiz,
                                    BindingResult result,
                                    Model model) {
        quizQuestionService.addLoginUserMenu(loginUser, model);
        quizQuestionService.quizRanking(model);

        return "Quiz/quizCreate";
    }

    //プレクイズ作成の処理
    @PostMapping("/quiz/preQuiz/create")
    public String quizPreCreate(@AuthenticationPrincipal LoginUser loginUser,
                                @Validated
                                @ModelAttribute Quiz quiz,
                                BindingResult result,
                                Model model) {
        quizQuestionService.addLoginUserMenu(loginUser, model);
        quizQuestionService.quizRanking(model);
        if(result.hasErrors()) {
            preQuizService.subMiss(model);
            return "Quiz/quizCreate";
        }
        String username = loginUser.getUsername();
        preQuizService.quizPreInsert(quiz, username);
        quizQuestionService.quizRanking(model);

        return "redirect:/quiz/preQuiz";
    }

    //プレクイズをクイズに採用するときの処理
    @GetMapping("/quiz/preQuiz/insert/{quizId}/")
    public String quizPreInsert(@PathVariable int quizId) {
        preQuizService.insertPreQuizToQuiz(quizId);
        preQuizService.deletePreQuiz(quizId);

        return "redirect:/quiz/preQuiz";
    }

    //プレクイズを却下するときの処理
    @GetMapping("/quiz/preQuiz/delete/{quizId}/")
    public String quizPreDelete(@PathVariable int quizId) {
        preQuizService.deletePreQuiz(quizId);

        return "redirect:/quiz/preQuiz";
    }
}
