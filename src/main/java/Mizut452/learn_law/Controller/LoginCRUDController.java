package Mizut452.learn_law.Controller;

import Mizut452.learn_law.Model.Entity.Login.LoginUser;
import Mizut452.learn_law.Service.LoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class LoginCRUDController {

    @Autowired
    LoginService loginService;

    @RequestMapping("/createaccount")
    public String createAccount() {
        return "Login/createAccount";
    }

    @PostMapping("/createaccount/create")
    public String createMethod(@ModelAttribute LoginUser loginUser) {
        loginService.createMethodService(loginUser);

        return "Login/Complete";
    }
}
