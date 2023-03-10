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
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

@Controller
public class PrecedentCRUDController {


    @Autowired
    PrecedentService precedentService;

    @Autowired
    PrecedentCRUDService precedentCRUDService;

    @GetMapping("/precedent/writeprecedent")
    public String writePrecedentPage(@AuthenticationPrincipal LoginUser loginUser,
                                     Precedent precedent,
                                     BindingResult result,
                                     Model model) {
        precedentService.addLoginUserMenu(loginUser, model);

        return "Precedent/writePrecedent";
    }

    @PostMapping("/precedent/create")
    public String precedentCreate(@AuthenticationPrincipal LoginUser loginUser,
                                  @ModelAttribute Precedent precedent,
                                  BindingResult result,
                                  Model model) {
        precedentService.addLoginUserMenu(loginUser, model);
        precedentService.createPrecedent(precedent);

        if (result.hasErrors()) {
            precedentService.subMiss(model);
            return "Precedent/writePrecedent";
        }

        return "Precedent/createComplete";
    }

    @PostMapping("/precedent/update/{precedent_id}/")
    public String precedentUpdate(@PathVariable int precedent_id,
                                  @ModelAttribute PrecedentUpdate precedentUpdate){
        precedentCRUDService.doPrecedentUpdate(precedentUpdate);

        return "redirect:/precedent/all";
    }

    @PostMapping("/precedent/delete/{precedent_id}/")
    public String precedentDelete(@PathVariable int precedent_id){
        precedentCRUDService.doPrecedentDelete(precedent_id);

        return "redirect:/precedent/all";
    }


    @GetMapping("/precedent/{precedent_id}/update/")
    public String precedentUpdatePage(@PathVariable int precedent_id,
                                      @ModelAttribute PrecedentUpdate precedentUpdate,
                                      @AuthenticationPrincipal LoginUser loginUser,
                                      Model model) {
        precedentService.addLoginUserMenu(loginUser, model);
        precedentCRUDService.precedentUpdate(precedent_id, model);

        return "Precedent/precedentUpdate";
    }

    @GetMapping("/precedent/{precedent_id}/delete/")
    public String precedentDeletePage(@PathVariable int precedent_id,
                                      @AuthenticationPrincipal LoginUser loginUser,
                                      Model model) {
        precedentService.addLoginUserMenu(loginUser, model);
        precedentCRUDService.precedentDelete(precedent_id, model);

        return "Precedent/precedentDelete";
    }

    @GetMapping("/precedent/all/changeList/")
    public String precedentListChange(@AuthenticationPrincipal LoginUser loginUser,
                                      @RequestParam("category") String category,
                                      Model model) {
        precedentService.addLoginUserMenu(loginUser, model);

        switch (category) {
            case "all" -> precedentService.findPrecedentList(model);
            case "civil" -> precedentCRUDService.changePrecedentCivilList(model);
            case "criminal" -> precedentCRUDService.changePrecedentCriminalList(model);
            default -> precedentCRUDService.changePrecedentCopyrightList(model);
        }


        return "Precedent/precedentList";
    }
}
