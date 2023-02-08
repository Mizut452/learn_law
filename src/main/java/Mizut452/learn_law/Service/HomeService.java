package Mizut452.learn_law.Service;

import Mizut452.learn_law.Mapper.LoginUserMapper;
import Mizut452.learn_law.Mapper.UserQuizHistoryMapper;
import Mizut452.learn_law.Model.Entity.Login.LoginUser;
import Mizut452.learn_law.Model.Entity.Quiz.UserQuizHistory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;

@Service
public class HomeService {

    @Autowired
    LoginUserMapper loginUserMapper;

    @Autowired
    UserQuizHistoryMapper userQuizHistoryMapper;

    public void addLoginUserMenu(@AuthenticationPrincipal LoginUser loginUser,
                                 Model model) {
        if (loginUser != null) {
            model.addAttribute("UserId", loginUser.getUserId());
        }
    }

    public void myPageService(int history_userId,
                              Model model,
                              @ModelAttribute LoginUser loginUser) {
        //ユーザーの検索
        LoginUser findByUserId = loginUserMapper.findByUserId(history_userId);

        String username = findByUserId.getUsername();
        //成績の反映
        UserQuizHistory userQuizHistory = userQuizHistoryMapper.usersQuizHistoryList(history_userId);

        model.addAttribute("username", username);
        model.addAttribute("userQuizHistory", userQuizHistory);
        model.addAttribute("UserId", loginUser.getUserId());
    }
}
