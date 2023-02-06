package Mizut452.learn_law.Controller;

import Mizut452.learn_law.Model.Entity.Login.LoginUser;
import Mizut452.learn_law.Service.LoginCRUDService;
import Mizut452.learn_law.Service.LoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@Controller
public class LoginCRUDController {

    @Autowired
    LoginService loginService;

    @Autowired
    LoginCRUDService loginCRUDService;

    @RequestMapping("/createaccount")
    public String createAccount(@ModelAttribute LoginUser loginUser,
                                BindingResult result,
                                Model model) {
        if(result.hasErrors()) {
            loginService.subMiss(model);
            return "Login/createAccount";
        }
        return "Login/createAccount";
    }

    @PostMapping("/createaccount/create")
    public String createMethod(@Validated
                               @ModelAttribute LoginUser loginUser,
                               BindingResult result,
                               Model model) {

        if(result.hasErrors()) {
            loginService.subMiss(model);
            return "Login/createAccount";
        }

        loginService.createMethodService(loginUser);

        return "Login/Complete";
    }

    @PostMapping("/userlist/{userId}/changeRole/")
    public String changeRole(@PathVariable int userId,
                             @AuthenticationPrincipal LoginUser loginUser,
                             String roleName,
                             Model model) {
        loginCRUDService.updateUserRole(roleName, userId);
        loginService.addLoginUserMenu(loginUser, model);
        loginService.selectAll(model);

        return "Login/userList";
    }

    @GetMapping("/userlist/update/{userId}/")
    public String updateUserPage(@PathVariable int userId) {
        loginCRUDService.updateUserPageService(userId);

        return "";
    }

    @GetMapping("/userlist/delete/{userId}/")
    public String deleteUserPage(@PathVariable int userId) {


        return "";
    }
}
