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

    @GetMapping("/precedent/criminal/{pre_number}")
    public String precedentCriminal(@PathVariable int pre_number) {
        return "Precedent/precedent";
    }
}
