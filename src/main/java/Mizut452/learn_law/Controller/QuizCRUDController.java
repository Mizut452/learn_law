package Mizut452.learn_law.Controller;

import Mizut452.learn_law.Model.Entity.Login.LoginUser;
import Mizut452.learn_law.Model.Entity.Quiz.QuizUpdateReq;
import Mizut452.learn_law.Service.QuizCRUDService;
import Mizut452.learn_law.Service.QuizQuestionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class QuizCRUDController {

    @Autowired
    QuizQuestionService quizQuestionService;

    @Autowired
    QuizCRUDService quizCRUDService;


    @PostMapping("/quiz/update/{quizId}/")
    public String quizUpdate(@PathVariable int quizId,
                             @ModelAttribute QuizUpdateReq quizUpdateReq) {
        quizCRUDService.doQuizUpdate(quizUpdateReq);

        return "redirect:/quiz/questionList";
    }

    @PostMapping("/quiz/delete/{quizId}/")
    public String quizDelete(@PathVariable int quizId,
                             @ModelAttribute QuizUpdateReq quizUpdateReq) {
        quizCRUDService.doQuizDelete(quizUpdateReq);

        return "redirect:/quiz/questionList";
    }

    @GetMapping("/quiz/questionList")
    public String quizList(@AuthenticationPrincipal LoginUser loginUser,
                           Model model) {
        quizQuestionService.addLoginUserMenu(loginUser, model);
        quizQuestionService.quizRanking(model);
        quizQuestionService.quizList(loginUser, model);

        return "Quiz/quizList";
    }

    @GetMapping("/quiz/questionList/{quizId}/update/")
    public String quizUpdatePage(@PathVariable int quizId,
                                 @ModelAttribute QuizUpdateReq quizUpdateReq,
                                 @AuthenticationPrincipal LoginUser loginUser,
                                 Model model) {
        quizCRUDService.quizUpdate(quizId, model);
        quizQuestionService.addLoginUserMenu(loginUser, model);
        quizQuestionService.quizRanking(model);

        return "Quiz/quizUpdate";
    }

    @GetMapping("/quiz/questionList/{quizId}/delete/")
    public String quizDeletePage(@PathVariable int quizId,
                                 @ModelAttribute QuizUpdateReq quizUpdateReq,
                                 @AuthenticationPrincipal LoginUser loginUser,
                                 Model model) {
        quizQuestionService.addLoginUserMenu(loginUser, model);
        quizQuestionService.quizRanking(model);
        quizCRUDService.quizDelete(quizId, model);

        return "Quiz/quizDelete";
    }
}
