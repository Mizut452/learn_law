package Mizut452.learn_law.Controller;

import Mizut452.learn_law.Model.Entity.LawBoard.LawBoard;
import Mizut452.learn_law.Model.Entity.LawBoard.LawBoardComment;
import Mizut452.learn_law.Model.Entity.LawBoard.LawBoardUpdateReq;
import Mizut452.learn_law.Model.Entity.Login.LoginUser;
import Mizut452.learn_law.Service.LawBoardCRUDService;
import Mizut452.learn_law.Service.LawBoardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class LawBoardCRUDController {

    @Autowired
    LawBoardService lawBoardService;

    @Autowired
    LawBoardCRUDService lawBoardCRUDService;


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
        lawBoardCRUDService.create_threadService(loginUser, lawBoard);

        return "redirect:/lawboard";
    }

    @GetMapping("/lawboard/{lawBoard_id}/update/")
    public String lawBoardUpdatePage(@PathVariable int lawBoard_id,
                                     @ModelAttribute LawBoardUpdateReq lawBoardUpdateReq,
                                     @AuthenticationPrincipal LoginUser loginUser,
                                     Model model) {
        lawBoardService.addLoginUserMenu(loginUser, model);
        lawBoardCRUDService.lawBoardUpdate(lawBoard_id, model);

        return "/LawBoard/lawBoardUpdate";
    }

    @GetMapping("/lawboard/{lawBoard_id}/delete/")
    public String lawBoardDeletePage(@PathVariable int lawBoard_id,
                                     @ModelAttribute LawBoardUpdateReq lawBoardUpdateReq,
                                     @AuthenticationPrincipal LoginUser loginUser,
                                     Model model) {
        lawBoardService.addLoginUserMenu(loginUser, model);
        lawBoardCRUDService.lawBoardDelete(lawBoard_id, model);

        return "/LawBoard/lawBoardDelete";
    }

    @PostMapping("lawboard/update/{lawBoard_id}/")
    public String lawBoardUpdate(@PathVariable int lawBoard_id,
                                 @ModelAttribute LawBoardUpdateReq lawBoardUpdateReq) {
        lawBoardCRUDService.doLawBoardUpdate(lawBoardUpdateReq);

        return "redirect:/lawboard";
    }

    @PostMapping("/lawboard/delete/{lawBoard_id}/")
    public String lawBoardDelete(@PathVariable int lawBoard_id,
                                 @ModelAttribute LawBoardUpdateReq lawBoardUpdateReq) {
        lawBoardCRUDService.doLawBoardDelete(lawBoardUpdateReq);

        return "redirect:/lawboard";
    }
}
