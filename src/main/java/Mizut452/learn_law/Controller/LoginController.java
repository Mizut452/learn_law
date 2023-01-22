package Mizut452.learn_law.Controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class LoginController {

    @RequestMapping("/login")
    public String Login() {
        return "Login/login";
    }

    @RequestMapping("/createaccount")
    public String createAccount() {
        return "Login/createAccount";
    }

    @PostMapping("/createaccount/create")
    public String createMethod() {
        return "redirect:/createaccount/roles";
    }

    @PostMapping("/createaccount/roles")
    public String createRoles() {
        return "Login/Complete";
    }
}
