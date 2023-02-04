package Mizut452.learn_law.Controller;

import Mizut452.learn_law.Model.Entity.Login.LoginUser;
import Mizut452.learn_law.Model.Entity.Precedent.Precedent;
import Mizut452.learn_law.Model.Entity.Precedent.PrecedentUpdate;
import Mizut452.learn_law.Service.PrecedentCRUDService;
import Mizut452.learn_law.Service.PrecedentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class PrecedentCRUDController {


    @Autowired
    PrecedentService precedentService;

    @Autowired
    PrecedentCRUDService precedentCRUDService;

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

    @PostMapping("/precedent/update/{precedent_id}/")
    public String precedentUpdate(@PathVariable int precedent_id,
                                  @ModelAttribute PrecedentUpdate precedentUpdate){
        precedentCRUDService.doPrecedentUpdate(precedentUpdate);

        return "redirect:/precedent/all";
    }

    @PostMapping("/precedent/delete/{precedent_id}/")
    public String precedentDelete(@PathVariable int precedent_id,
                                  @ModelAttribute PrecedentUpdate precedentUpdate){
        precedentCRUDService.doPrecedentDelete(precedentUpdate);

        return "redirect:/precedent/all";
    }


    @GetMapping("/precedent/update/{precedent_id}")
    public String precedentUpdatePage(@PathVariable int precedent_id,
                                      @AuthenticationPrincipal LoginUser loginUser,
                                      Model model) {
        precedentService.addLoginUserMenu(loginUser, model);
        precedentCRUDService.precedentUpdateDelete(precedent_id, model);

        return "Precedent/precedentUpdate";
    }

    @GetMapping("/precedent/delete/{precedent_id}")
    public String precedentDeletePage(@PathVariable int precedent_id,
                                      @AuthenticationPrincipal LoginUser loginUser,
                                      Model model) {
        precedentService.addLoginUserMenu(loginUser, model);
        precedentCRUDService.precedentUpdateDelete(precedent_id, model);

        return "Precedent/precedentDelete";
    }
}
