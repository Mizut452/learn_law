package Mizut452.learn_law.Controller;

import Mizut452.learn_law.Model.Entity.Login.LoginUser;
import Mizut452.learn_law.Service.HomeService;
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
    HomeService homeService;

    @RequestMapping("/")
    public String homePage(Model model,
                           @AuthenticationPrincipal LoginUser loginUser) {
        homeService.addLoginUserMenu(loginUser, model);

        return "Home/home";
    }

    @GetMapping("/mypage/{history_userId}/")
    public String myPage(Model model,
                         @PathVariable int history_userId,
                         @AuthenticationPrincipal LoginUser loginUser) {
        homeService.addLoginUserMenu(loginUser, model);
        homeService.myPageService(history_userId, model, loginUser);

        return "Home/myPage";
    }
}
