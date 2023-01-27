package Mizut452.learn_law.Controller;

import Mizut452.learn_law.Mapper.LoginUserMapper;
import Mizut452.learn_law.Mapper.UserQuizHistoryMapper;
import Mizut452.learn_law.Model.Entity.LoginUser;
import Mizut452.learn_law.Model.Entity.UserQuizHistory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class HomeController {

    @Autowired
    UserQuizHistoryMapper userQuizHistoryMapper;

    @Autowired
    LoginUserMapper loginUserMapper;

    @RequestMapping("/")
    public String homePage(Model model,
                           @AuthenticationPrincipal LoginUser loginUser) {
        if(loginUser != null) {
            model.addAttribute("UserId", loginUser.getUserId());
        }
        return "Home/home";
    }

    @GetMapping("/mypage/{history_userId}")
    public String myPage(Model model,
                         @PathVariable int history_userId,
                         @AuthenticationPrincipal LoginUser loginUser) {
        //ユーザーの検索
        LoginUser findByUserId = loginUserMapper.findByUserId(history_userId);

        //存在しないユーザーIDが入力された場合の処理
        if(findByUserId == null) {
            return "Home/error";
        }

        String username = findByUserId.getUsername();
        //成績の反映
        UserQuizHistory userQuizHistory = userQuizHistoryMapper.usersQuizHistoryList(history_userId);
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

        return "Home/myPage";
    }
}
