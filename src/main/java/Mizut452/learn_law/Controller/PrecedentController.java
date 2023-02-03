package Mizut452.learn_law.Controller;

import Mizut452.learn_law.Mapper.PrecedentMapper;
import Mizut452.learn_law.Model.Entity.Login.LoginUser;
import Mizut452.learn_law.Model.Entity.Precedent.Precedent;
import Mizut452.learn_law.Service.PrecedentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

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

    @GetMapping("/precedent/criminal/top")
    public String precedentCriminalTop(@AuthenticationPrincipal LoginUser loginUser,
                                       Model model) {
        precedentService.addLoginUserMenu(loginUser, model);
        precedentService.findPrecedentCriminalService(model);

        return "Precedent/precedentCriminal";
    }

    @GetMapping("/precedent/civil/top")
    public String precedentCivilTop(Model model,
                                    @AuthenticationPrincipal LoginUser loginUser) {
        precedentService.addLoginUserMenu(loginUser, model);
        precedentService.findPrecedentCivilService(model);

        return "Precedent/precedentCivil";
    }

    @GetMapping("/precedent/copyright/top")
    public String precedentCopyright(@AuthenticationPrincipal LoginUser loginUser,
                                     Model model) {
        precedentService.addLoginUserMenu(loginUser, model);
        precedentService.findPrecedentCopyright(model);

        return "Precedent/precedentCopyright";
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

    @GetMapping("/precedent/writeprecedent")
    public String writePrecedentPage(@AuthenticationPrincipal LoginUser loginUser,
                                     Model model) {
        precedentService.addLoginUserMenu(loginUser, model);

        return "Precedent/writePrecedent";
    }

    @PostMapping("/precedent/create")
    public String precedentCreate(@ModelAttribute Precedent precedent) {
        precedentService.createPrecedent(precedent);

        return "Precedent/createComplete";
    }
}
