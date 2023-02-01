package Mizut452.learn_law.Controller;

import Mizut452.learn_law.Mapper.LawBoardMapper;
import Mizut452.learn_law.Model.Entity.LawBoard.LawBoard;
import Mizut452.learn_law.Model.Entity.LawBoard.LawBoardComment;
import Mizut452.learn_law.Model.Entity.Login.LoginUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
public class LawBoardController {

    @RequestMapping("/lawboard")
    public String LawBoardPage(@AuthenticationPrincipal LoginUser loginUser,
                               Model model) {
        if (loginUser != null) {
            //ログイン中は別のメニューが表示される
            model.addAttribute("UserId", loginUser.getUserId());
        }

        LawBoard lawBoard = lawBoardMapper.lawBoardAll();

        model.addAttribute("LawBoard", lawBoard);

        return "LawBoard/lawboard";
    }

    @GetMapping("/lawboard/{lawboard_id}/")
    public String LawBoardThreadPage(@PathVariable int lawboard_id,
                                     @AuthenticationPrincipal LoginUser loginUser,
                                     Model model) {
        LawBoard lawBoard = lawBoardMapper.lawBoardById(lawboard_id);
        List<LawBoardComment> commentList = lawBoardMapper.lawBoardCommentById(lawboard_id);

        if (loginUser != null) {
            //ログイン中は別のメニューが表示される
            model.addAttribute("UserId", loginUser.getUserId());
        }

        model.addAttribute("LawTitle", lawBoard.getLawBoard_title());
        model.addAttribute("LawCategory", lawBoard.getLawBoard_category());
        model.addAttribute("LawMainComment", lawBoard.getLawBoard_mainComment());
        model.addAttribute("LawUsername", lawBoard.getLawBoard_username());
        model.addAttribute("LawTime", lawBoard.getLawBoard_time());
        model.addAttribute("LawComment", commentList);

        return "LawBoard/lawboard_thread";
    }

    @Autowired
    LawBoardMapper lawBoardMapper;
}
