package Mizut452.learn_law.Service;

import Mizut452.learn_law.Mapper.LoginUserMapper;
import Mizut452.learn_law.Mapper.UserQuizHistoryMapper;
import Mizut452.learn_law.Model.Entity.Login.LoginUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DuplicateKeyException;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;

@Service
public class LoginService {

    @Autowired
    LoginUserMapper loginUserMapper;

    @Autowired
    PasswordEncoder passwordEncoder;

    @Autowired
    UserQuizHistoryMapper userQuizHistoryMapper;

    public void addLoginUserMenu(@AuthenticationPrincipal LoginUser loginUser,
                                 Model model) {
        if (loginUser != null) {
            model.addAttribute("UserId", loginUser.getUserId());
        }
    }

    public void selectAll(Model model) {
        model.addAttribute("UserList", loginUserMapper.selectAll());
    }

    public void createMethodService(@ModelAttribute LoginUser loginUser) {
        //SQLに登録
        //プライマリーキーと自動採番を同期させる
        loginUserMapper.primaryKeySync();
            loginUser.setPassword(passwordEncoder.encode(loginUser.getPassword()));
            loginUserMapper.create(loginUser);
            //成績用のSQL登録
            loginUser = loginUserMapper.findByUsername(loginUser.getUsername());
            userQuizHistoryMapper.USER_QUIZ_HISTORY_SYNC();
            userQuizHistoryMapper.insertNewUserQuizHistory(loginUser.getUserId(), loginUser.getUsername());
    }

    public void subMiss(Model model) {
        model.addAttribute("SubMiss", "登録に失敗しました。");
    }

    public void duplicateMiss(Model model) {
        model.addAttribute("SubMiss", "登録に失敗しました。登録されているユーザーネーム、メールアドレスが入力された可能性があります。");
    }

    public void loginMiss(Model model) {
        model.addAttribute("LoginMiss", "ログインに失敗しました");
    }
}
