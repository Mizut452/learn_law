package Mizut452.learn_law.Controller;

import Mizut452.learn_law.Model.Entity.Login.LoginUser;
import Mizut452.learn_law.Service.PrecedentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class PrecedentController {

    @Autowired
    PrecedentService precedentService;

    @RequestMapping("/precedent")
    public String precedentHome(@AuthenticationPrincipal LoginUser loginUser,
                                Model model) {
        precedentService.addLoginUserMenu(loginUser, model);

        return "Precedent/precedentTop";
    }

    @GetMapping("/precedent/{precedent_id}/")
    public String precedentCivil(@PathVariable int precedent_id,
                                 @AuthenticationPrincipal LoginUser loginUser,
                                 Model model) {
        precedentService.addLoginUserMenu(loginUser, model);
        precedentService.findPrecedentByPrecedentId(precedent_id, model);

        return "Precedent/precedent";
    }

    @GetMapping("/precedent/all")
    public String precedentList(@AuthenticationPrincipal LoginUser loginUser,
                                Model model) {
        precedentService.addLoginUserMenu(loginUser, model);
        precedentService.findPrecedentList(model);
        return "Precedent/precedentList";
    }
}
