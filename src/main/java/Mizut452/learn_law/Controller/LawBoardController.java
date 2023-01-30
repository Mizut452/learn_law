package Mizut452.learn_law.Controller;

import Mizut452.learn_law.Model.Entity.Login.LoginUser;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class LawBoardController {

    @RequestMapping("/lawboard")
    public String LawBoardPage(@AuthenticationPrincipal LoginUser loginUser,
                               Model model) {
        if (loginUser != null) {
            //ログイン中は別のメニューが表示される
            model.addAttribute("UserId", loginUser.getUserId());
        }



        return "LawBoard/lawboard";
    }

    @GetMapping("/lawboard/{lawboard_id}")
    public String LawBoardThreadPage(@AuthenticationPrincipal LoginUser loginUser,
                                     Model model) {
        if (loginUser != null) {
            //ログイン中は別のメニューが表示される
            model.addAttribute("UserId", loginUser.getUserId());
        }

        return "LawBoard/lawboard_thread";
    }
}
