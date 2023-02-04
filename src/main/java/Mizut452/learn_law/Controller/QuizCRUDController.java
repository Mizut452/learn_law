package Mizut452.learn_law.Controller;

import Mizut452.learn_law.Mapper.QuizMapper;
import Mizut452.learn_law.Model.Entity.Login.LoginUser;
import Mizut452.learn_law.Model.Entity.Quiz.QuizUpdateReq;
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


    @PostMapping("/quiz/update/{quizId}/")
    public String quizUpdate(@PathVariable int quizId,
                             @ModelAttribute QuizUpdateReq quizUpdateReq) {
        quizQuestionService.doQuizUpdate(quizUpdateReq);

        return "redirect:/quiz/questionList";
    }

    @PostMapping("/quiz/delete/{quizId}/")
    public String quizDelete(@PathVariable int quizId,
                             @ModelAttribute QuizUpdateReq quizUpdateReq) {
        quizQuestionService.doQuizDelete(quizUpdateReq);

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
        quizQuestionService.quizUpdate(quizId, model);
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
        quizQuestionService.quizDelete(quizId, model);

        return "Quiz/quizDelete";
    }
}
