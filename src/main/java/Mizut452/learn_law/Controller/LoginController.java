package Mizut452.learn_law.Controller;

import Mizut452.learn_law.Service.LoginService;
import org.springframework.beans.factory.annotation.Autowired;
import Mizut452.learn_law.Model.Entity.Login.LoginUser;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class LoginController {

    @Autowired
    LoginService loginService;

    @RequestMapping("/login")
    public String Login(@ModelAttribute LoginUser loginUser) {

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

