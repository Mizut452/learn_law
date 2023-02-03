package Mizut452.learn_law.Controller;

import Mizut452.learn_law.Mapper.LoginUserMapper;
import Mizut452.learn_law.Mapper.UserQuizHistoryMapper;
import Mizut452.learn_law.Model.Entity.Login.Book;
import Mizut452.learn_law.Service.CreateAccountService;
import Mizut452.learn_law.Service.LoginService;
import Mizut452.learn_law.Service.bookService;
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

    @Autowired
    LoginService loginService;

    @Autowired
    bookService bookService;

    @RequestMapping("/login")
    public String Login() {
        return "Login/login";
    }

    @GetMapping("/userlist")
    public String userListPage(Model model,
                               @AuthenticationPrincipal LoginUser loginUser) {
        loginService.selectAll(model);
        loginService.addLoginUserMenu(loginUser, model);

        return "Login/userList";
    }

    @RequestMapping("/createaccount")
    public String createAccount() {
        return "Login/createAccount";
    }

    @PostMapping("/createaccount/create")
    public String createMethod(@ModelAttribute LoginUser loginUser) {
        loginService.createMethodService(loginUser);

        return "Login/Complete";
    }

    @RequestMapping("/toroku")
    public String torokuPage() {

        return "/ex/toroku";
    }

    @PostMapping("/toroku/create")
    public String toroku(Book book) {
        //後で設定するサービスクラス
        bookService.insertBookService(book);

        return "redirect:/toroku";
    }

    @GetMapping("/toroku/bookList")
    public String bookListPage(Model model) {
        //後で設定するサービスクラス
        bookService.selectBookService(model);

        return "/Login/BookList";
    }
}

