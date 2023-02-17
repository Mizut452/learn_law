package Mizut452.learn_law.Service;

import Mizut452.learn_law.Mapper.LawBoardMapper;
import Mizut452.learn_law.Model.Entity.LawBoard.LawBoard;
import Mizut452.learn_law.Model.Entity.LawBoard.LawBoardComment;
import Mizut452.learn_law.Model.Entity.Login.LoginUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;

import java.util.List;

@Service
public class LawBoardService {

    @Autowired
    LawBoardMapper lawBoardMapper;

    public void addLoginUserMenu(@AuthenticationPrincipal LoginUser loginUser,
                                 Model model) {
        if (loginUser != null) {
            model.addAttribute("UserId", loginUser.getUserId());
        }
    }

    public void addLoginUser(@AuthenticationPrincipal LoginUser loginUser,
                             Model model) {
        if(loginUser != null) {
            model.addAttribute("UserRole", loginUser.getRoleName());
        }
    }

    public void LawBoardAll(Model model) {
        List<LawBoard> lawBoard = lawBoardMapper.lawBoardAll();
        model.addAttribute("LawBoard", lawBoard);
    }

    public void ThreadPage(int lawboard_id,
                           Model model) {
        LawBoard lawBoard = lawBoardMapper.lawBoardById(lawboard_id);
        List<LawBoardComment> commentList = lawBoardMapper.lawBoardCommentById(lawboard_id);
        model.addAttribute("lawBoard", lawBoard);
        model.addAttribute("LawComment", commentList);
        model.addAttribute("LawBoard_ID", lawboard_id);
    }
}
