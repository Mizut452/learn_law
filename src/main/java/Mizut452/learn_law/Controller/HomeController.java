package Mizut452.learn_law.Controller;

import Mizut452.learn_law.Mapper.LoginUserMapper;
import Mizut452.learn_law.Mapper.QuizMapper;
import Mizut452.learn_law.Model.Entity.LoginUser;
import Mizut452.learn_law.Model.Entity.Quiz;
import Mizut452.learn_law.Model.Entity.UserQuizHistory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
public class HomeController {

    @Autowired
    QuizMapper quizMapper;

    @Autowired
    LoginUserMapper loginUserMapper;

    @RequestMapping("/")
    public String homePage() {
        return "Home/home";
    }

    @GetMapping("/mypage/{userId}")
    public String myPage(Model model,
                         @PathVariable int userId,
                         @AuthenticationPrincipal LoginUser loginUser) {
        LoginUser findByUserId = loginUserMapper.findByUserId(userId);
        String username = findByUserId.getUsername();

        UserQuizHistory userQuizHistory = quizMapper.usersQuizHistoryList(userId);
        int pointAll = userQuizHistory.getPointAll();
        int questionAll = userQuizHistory.getQuestionAll();
        int civilQuestionAll = userQuizHistory.getCivilQuestionAll();
        int criminalQuestionAll = userQuizHistory.getCriminalQuestionAll();
        int pointCriminal = userQuizHistory.getPointCriminalLaw();
        int pointCivil = userQuizHistory.getPointCivilLaw();

        model.addAttribute("username", username);
        model.addAttribute("pointAll", pointAll);
        model.addAttribute("questionAll", questionAll);
        model.addAttribute("civilQuestionAll", civilQuestionAll);
        model.addAttribute("criminalQuestionAll", criminalQuestionAll);
        model.addAttribute("pointCriminal", pointCriminal);
        model.addAttribute("pointCivil", pointCivil);



        if (loginUser != null) {

            return "Home/myPage";
        } else {
            return "Home/myPage";
        }
    }
}
