package Mizut452.learn_law.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import Mizut452.learn_law.Model.Entity.LoginUser;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
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
    public String createMethod(@ModelAttribute LoginUser loginUser) {
        loginUser.setEmail(loginUser.getEmail());
        loginUser.setUsername(loginUser.getUsername());
        loginUser.setPassword(loginUser.getPassword());

        return "redirect:/createaccount/roles";
    }

    @PostMapping("/createaccount/roles")
    public String createRoles(@ModelAttribute LoginUser loginUser) {
        loginUser.setRoleList(loginUser.getRoleList());

        return "Login/Complete";
    }
}
