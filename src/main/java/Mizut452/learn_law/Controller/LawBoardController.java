package Mizut452.learn_law.Controller;

import Mizut452.learn_law.Model.Entity.LawBoard.LawBoardComment;
import Mizut452.learn_law.Model.Entity.Login.LoginUser;
import Mizut452.learn_law.Service.LawBoardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class LawBoardController {

    @Autowired
    LawBoardService lawBoardService;

    @RequestMapping("/lawboard")
    public String LawBoardPage(@AuthenticationPrincipal LoginUser loginUser,
                               Model model) {
        lawBoardService.addLoginUserMenu(loginUser, model);
        lawBoardService.LawBoardAll(model);

        return "LawBoard/lawboard";
    }

    @GetMapping("/lawboard/{lawboard_id}/")
    public String LawBoardThreadPage(@PathVariable int lawboard_id,
                                     @AuthenticationPrincipal LoginUser loginUser,
                                     Model model) {
        lawBoardService.addLoginUserMenu(loginUser, model);
        lawBoardService.ThreadPage(lawboard_id, model);

        return "LawBoard/lawboard_thread";
    }

}
