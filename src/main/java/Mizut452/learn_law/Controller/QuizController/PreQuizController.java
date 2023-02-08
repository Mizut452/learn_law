package Mizut452.learn_law.Controller.QuizController;

import Mizut452.learn_law.Model.Entity.Login.LoginUser;
import Mizut452.learn_law.Service.PreQuizService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class PreQuizController {

    @Autowired
    PreQuizService preQuizService;

    @GetMapping("/quiz/preQuiz")
    public String quizPre(@AuthenticationPrincipal LoginUser loginUser,
                          Model model) {
        preQuizService.selectPreQuiz(model);
        if (loginUser != null) {
            model.addAttribute("role", loginUser.getRoleName());
        }
        return "Quiz/PreQuizList";
    }
}
