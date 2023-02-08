package Mizut452.learn_law.Controller;

import Mizut452.learn_law.Mapper.PreQuizMapper;
import Mizut452.learn_law.Mapper.QuizMapper;
import Mizut452.learn_law.Model.Entity.Login.LoginUser;
import Mizut452.learn_law.Model.Entity.Quiz.Quiz;
import Mizut452.learn_law.Model.Entity.Quiz.QuizUpdateReq;
import Mizut452.learn_law.Service.PreQuizService;
import Mizut452.learn_law.Service.QuizCRUDService;
import Mizut452.learn_law.Service.QuizQuestionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
public class QuizCRUDController {

    @Autowired
    QuizQuestionService quizQuestionService;

    @Autowired
    QuizCRUDService quizCRUDService;

    @Autowired
    PreQuizService preQuizService;


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

    @GetMapping("/quiz/preQuiz")
    public String quizPre(@AuthenticationPrincipal LoginUser loginUser,
                          Model model) {
        preQuizService.selectPreQuiz(model);
        if (loginUser != null) {
            model.addAttribute("role", loginUser.getRoleName());
        }
        return "Quiz/PreQuizList";
    }

    @GetMapping("/quiz/preQuiz/good/{quizId}/")
    public String quizPreGood(@PathVariable int quizId) {
        preQuizService.addGoodService(quizId);

        return "redirect:/quiz/preQuiz";
    }

    @GetMapping("/quiz/preQuiz/createQuiz")
    public String quizPreQuizCreate(@AuthenticationPrincipal LoginUser loginUser,
                                    Quiz quiz,
                                    BindingResult result,
                                    Model model) {
        quizQuestionService.addLoginUserMenu(loginUser, model);
        quizQuestionService.quizRanking(model);

        return "Quiz/quizCreate";
    }

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

    @Autowired
    PreQuizMapper preQuizMapper;
}
