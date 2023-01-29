package Mizut452.learn_law.Controller;

import Mizut452.learn_law.Mapper.PrecedentMapper;
import Mizut452.learn_law.Model.Entity.Precedent;
import org.springframework.beans.factory.annotation.Autowired;
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

    @GetMapping("/precedent/criminal/{pre_number}/")
    public String precedentCriminal(@PathVariable int pre_number) {
        return "Precedent/precedent";
    }

    @GetMapping("/precedent/civil/top")
    public String precedentCivilTop() {
        return "Precedent/precedent";
    }

    @GetMapping("/precedent/civil/{pre_number}/")
    public String precedentCivil(@PathVariable int pre_number) {
        return "Precedent/precedent";
    }

    @GetMapping("/precedent/copyright/top")
    public String precedentCopyrightTop() {
        return "Precedent/precedent";
    }

    @GetMapping("/precedent/copyright/{pre_number}/")
    public String precedentCopyright(@PathVariable int pre_number) {
        return "Precedent/precedent";
    }

    @GetMapping("/precedent/all")
    public String precedentList(Model model) {
        model.addAttribute("PrecedentList", precedentMapper.precedentList());
        return "Precedent/precedentList";
    }

    @GetMapping("/precedent/writeprecedent")
    public String writePrecedentPage() {
        return "Precedent/writePrecedent";
    }

    @PostMapping("/precedent/create")
    public String precedentCreate() {
        precedent.setPrecedent_title(precedent.getPrecedent_title());
        precedent.setPrecedent_category(precedent.getPrecedent_category());
        precedent.setPrecedent_number(precedent.getPrecedent_number());
        precedent.setPrecedent_subtitle(precedent.getPrecedent_subtitle());
        precedent.setPrecedent_overview(precedent.getPrecedent_overview());
        precedent.setPrecedent_plClaim(precedent.getPrecedent_plClaim());
        precedent.setPrecedent_deClaim(precedent.getPrecedent_deClaim());
        precedent.setPrecedent_judgement(precedent.getPrecedent_judgement());

        precedentMapper.createPrecedent(precedent);


        return "Precedent/createComplete";
    }


    private Precedent precedent;

    @Autowired
    PrecedentMapper precedentMapper;
}
