package Mizut452.learn_law.Controller;

import Mizut452.learn_law.Mapper.LawBoardMapper;
import Mizut452.learn_law.Model.Entity.LawBoard.LawBoard;
import Mizut452.learn_law.Model.Entity.LawBoard.LawBoardComment;
import Mizut452.learn_law.Model.Entity.Login.LoginUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.awt.*;
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
        model.addAttribute("LawBoard_ID", lawboard_id);

        return "LawBoard/lawboard_thread";
    }

    @PostMapping("/lawboard/{lawboard_id}/createcomment/")
    public String createComment(@PathVariable int lawboard_id,
                                @AuthenticationPrincipal LoginUser loginUser,
                                @ModelAttribute LawBoardComment lawBoardComment) {
        System.out.println(loginUser.getUsername());
        System.out.println(lawboard_id);

        lawBoardComment.setBoardParent_id(lawboard_id);
        lawBoardComment.setComment_username(loginUser.getUsername());
        lawBoardComment.setComment(lawBoardComment.getComment());

        lawBoardMapper.insertComment(lawBoardComment);


        return "redirect:/lawboard/" + lawboard_id +"/";
    }

    @Autowired
    LawBoardMapper lawBoardMapper;
}
