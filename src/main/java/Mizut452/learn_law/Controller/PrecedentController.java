package Mizut452.learn_law.Controller;

import Mizut452.learn_law.Mapper.PrecedentMapper;
import Mizut452.learn_law.Model.Entity.Login.LoginUser;
import Mizut452.learn_law.Model.Entity.Precedent.Precedent;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class PrecedentController {
    @RequestMapping("/precedent")
    public String precedentHome() {

        return "Precedent/precedentTop";
    }

    @GetMapping("/precedent/criminal/top")
    public String precedentCriminalTop() {
        return "Precedent/precedent";
    }

    @GetMapping("/precedent/civil/top")
    public String precedentCivilTop() {
        return "Precedent/precedent";
    }

    @GetMapping("/precedent/{category}/{precedent_id}/")
    public String precedentCivil(@PathVariable int precedent_id,
                                 @AuthenticationPrincipal LoginUser loginUser,
                                 Model model) {
        if (loginUser != null) {
            //ログイン中は別のメニューが表示される
            model.addAttribute("UserId", loginUser.getUserId());
        }
        Precedent precedent = precedentMapper.findByPrecedentId(precedent_id);

        model.addAttribute("Pre_title", precedent.getPrecedent_title());
        model.addAttribute("Pre_category", precedent.getPrecedent_category());
        model.addAttribute("Pre_number", precedent.getPrecedent_number());
        model.addAttribute("Pre_subtitle", precedent.getPrecedent_subtitle());
        model.addAttribute("Pre_overview", precedent.getPrecedent_overview());
        model.addAttribute("Pre_claim", precedent.getPrecedent_claim());
        model.addAttribute("Pre_judgement", precedent.getPrecedent_judgement());

        return "Precedent/precedent";
    }

    @GetMapping("/precedent/copyright/top")
    public String precedentCopyrightTop(@AuthenticationPrincipal LoginUser loginUser,
                                        Model model) {
        if (loginUser != null) {
            //ログイン中は別のメニューが表示される
            model.addAttribute("UserId", loginUser.getUserId());
        }
        return "Precedent/precedent";
    }

    @GetMapping("/precedent/copyright/{pre_number}/")
    public String precedentCopyright(@PathVariable int pre_number) {
        return "Precedent/precedent";
    }

    @GetMapping("/precedent/all")
    public String precedentList(@AuthenticationPrincipal LoginUser loginUser,
                                Model model) {
        if (loginUser != null) {
            //ログイン中は別のメニューが表示される
            model.addAttribute("UserId", loginUser.getUserId());
        }
        model.addAttribute("PrecedentList", precedentMapper.precedentList());
        return "Precedent/precedentList";
    }

    @GetMapping("/precedent/writeprecedent")
    public String writePrecedentPage(@AuthenticationPrincipal LoginUser loginUser,
                                     Model model) {
        model.addAttribute("UserId", loginUser.getUserId());

        return "Precedent/writePrecedent";
    }

    @PostMapping("/precedent/create")
    public String precedentCreate() {
        precedent.setPrecedent_title(precedent.getPrecedent_title());
        precedent.setPrecedent_category(precedent.getPrecedent_category());
        precedent.setPrecedent_number(precedent.getPrecedent_number());
        precedent.setPrecedent_subtitle(precedent.getPrecedent_subtitle());
        precedent.setPrecedent_overview(precedent.getPrecedent_overview());
        precedent.setPrecedent_claim(precedent.getPrecedent_claim());
        precedent.setPrecedent_judgement(precedent.getPrecedent_judgement());

        precedentMapper.createPrecedent(precedent);


        return "Precedent/createComplete";
    }


    private Precedent precedent;

    @Autowired
    PrecedentMapper precedentMapper;
}
