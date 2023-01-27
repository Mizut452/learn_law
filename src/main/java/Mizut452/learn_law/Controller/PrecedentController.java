package Mizut452.learn_law.Controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
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

    @GetMapping("/precedent/criminal/{pre_number}")
    public String precedentCriminal(@PathVariable int pre_number) {
        return "Precedent/precedent";
    }

    @GetMapping("/precedent/civil/top")
    public String precedentCivilTop() {
        return "Precedent/precedent";
    }

    @GetMapping("/precedent/civil/{pre_number}")
    public String precedentCivil(@PathVariable int pre_number) {
        return "Precedent/precedent";
    }

    @GetMapping("/precedent/copyright/top")
    public String precedentCopyrightTop() {
        return "Precedent/precedent";
    }

    @GetMapping("/precedent/copyright/{pre_number}")
    public String precedentCopyright(@PathVariable int pre_number) {
        return "Precedent/precedent";
    }

}
