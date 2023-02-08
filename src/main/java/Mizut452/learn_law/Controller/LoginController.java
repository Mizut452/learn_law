package Mizut452.learn_law.Controller;

import Mizut452.learn_law.Service.LoginService;
import org.springframework.beans.factory.annotation.Autowired;
import Mizut452.learn_law.Model.Entity.Login.LoginUser;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@Controller
public class LoginController {

    @Autowired
    LoginService loginService;

    @RequestMapping("/login")
    public String Login(LoginUser loginUser,
                        BindingResult result,
                        Model model) {
        return "Login/login";
    }

    @GetMapping("/login/error")
    public String LoginError(@Validated LoginUser loginUser,
                             BindingResult result,
                             Model model) {
        if(result.hasErrors()) {
            loginService.loginMiss(model);
            return "Login/login";
        }

        return "Login/login";
    }

    @GetMapping("/userlist")
    public String userListPage(Model model,
                               @AuthenticationPrincipal LoginUser loginUser) {
        loginService.selectAll(model);
        loginService.addLoginUserMenu(loginUser, model);

        return "Login/userList";
    }
}

