package Mizut452.learn_law.Controller;

import Mizut452.learn_law.Mapper.LoginUserMapper;
import Mizut452.learn_law.Mapper.UserQuizHistoryMapper;
import Mizut452.learn_law.Service.CreateAccountService;
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
        loginUser.setRoleName(loginUser.getRoleName());

        createAccountService.createAccount(loginUser);
         loginUser = loginUserMapper.findByUsername(loginUser.getUsername());
        userQuizHistoryMapper.insertNewUserQuizHistory(loginUser.getUserId());

        return "Login/Complete";
    }

    @PostMapping("/createaccount/createhistory")
    public String createHistoryMethod() {

        return "Login/Complete";
    }


    @Autowired
    private CreateAccountService createAccountService;

    @Autowired
    private LoginUserMapper loginUserMapper;

    @Autowired
    private UserQuizHistoryMapper userQuizHistoryMapper;

}
