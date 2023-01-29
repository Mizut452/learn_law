package Mizut452.learn_law.Controller;

import Mizut452.learn_law.Mapper.LoginUserMapper;
import Mizut452.learn_law.Mapper.UserQuizHistoryMapper;
import Mizut452.learn_law.Service.CreateAccountService;
import org.springframework.beans.factory.annotation.Autowired;
import Mizut452.learn_law.Model.Entity.Login.LoginUser;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class LoginController {

    @RequestMapping("/login")
    public String Login() {
        return "Login/login";
    }

    @GetMapping("/userlist")
    public String userListPage(Model model,
                               @AuthenticationPrincipal LoginUser loginUser) {
        model.addAttribute("UserList", loginUserMapper.selectAll());
        model.addAttribute("UserId", loginUser.getUserId());
        return "Login/userList";
    }

    @RequestMapping("/createaccount")
    public String createAccount() {
        return "Login/createAccount";
    }

    @PostMapping("/createaccount/create")
    public String createMethod(@ModelAttribute LoginUser loginUser) {
        //SQLに登録
        loginUser.setEmail(loginUser.getEmail());
        loginUser.setUsername(loginUser.getUsername());
        loginUser.setPassword(loginUser.getPassword());
        loginUser.setRoleName(loginUser.getRoleName());

        createAccountService.createAccount(loginUser);

        //成績用のSQL登録
        loginUser = loginUserMapper.findByUsername(loginUser.getUsername());
        userQuizHistoryMapper.insertNewUserQuizHistory(loginUser.getUserId(), loginUser.getUsername());

        return "Login/Complete";
    }


    @Autowired
    CreateAccountService createAccountService;

    @Autowired
    LoginUserMapper loginUserMapper;

    @Autowired
    UserQuizHistoryMapper userQuizHistoryMapper;

}
