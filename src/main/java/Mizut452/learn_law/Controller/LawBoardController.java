package Mizut452.learn_law.Controller;

import Mizut452.learn_law.Mapper.LawBoardMapper;
import Mizut452.learn_law.Model.Entity.LawBoard.LawBoard;
import Mizut452.learn_law.Model.Entity.LawBoard.LawBoardComment;
import Mizut452.learn_law.Model.Entity.Login.LoginUser;
import Mizut452.learn_law.Service.LawBoardCreateService;
import Mizut452.learn_law.Service.LawBoardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.awt.*;
import java.util.List;

@Controller
public class LawBoardController {

    @Autowired
    LawBoardService lawBoardService;

    @Autowired
    LawBoardCreateService lawBoardCreateService;

    @RequestMapping("/lawboard")
    public String LawBoardPage(@AuthenticationPrincipal LoginUser loginUser,
                               Model model) {
        lawBoardService.addLoginUserMenu(loginUser, model);
        lawBoardService.LawBoardAll(model);

        return "LawBoard/lawboard";
    }

    @GetMapping("/lawboard/{lawboard_id}/")
    public String LawBoardThreadPage(@PathVariable int lawboard_id,
                                     @AuthenticationPrincipal LoginUser loginUser,
                                     Model model) {
        lawBoardService.addLoginUserMenu(loginUser, model);
        lawBoardService.ThreadPage(lawboard_id, model);

        return "LawBoard/lawboard_thread";
    }

    @PostMapping("/lawboard/{lawboard_id}/createcomment/")
    public String createComment(@PathVariable int lawboard_id,
                                @AuthenticationPrincipal LoginUser loginUser,
                                @ModelAttribute LawBoardComment lawBoardComment) {

            lawBoardService.createCommentService(lawboard_id, loginUser, lawBoardComment);


            return "redirect:/lawboard/" + lawboard_id + "/";
    }

    @GetMapping("/lawboard/create_thread")
    public String create_threadPage(@AuthenticationPrincipal LoginUser loginUser,
                                    Model model) {
        lawBoardService.addLoginUserMenu(loginUser, model);

        return "/LawBoard/createTopic";
    }

    @PostMapping("/lawboard/create")
    public String create(@AuthenticationPrincipal LoginUser loginUser,
                         @ModelAttribute LawBoard lawBoard) {
        lawBoardCreateService.create_threadService(loginUser, lawBoard);

        return "redirect:/lawboard";
    }
}
