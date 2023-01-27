package Mizut452.learn_law.Controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class PrecedentController {
    @RequestMapping("/precedent")
    public String precedentHome() {

        return "precedentTop";
    }
}
