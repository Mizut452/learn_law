package Mizut452.learn_law.Service;

import Mizut452.learn_law.Mapper.LawBoardMapper;
import Mizut452.learn_law.Model.Entity.LawBoard.LawBoard;
import Mizut452.learn_law.Model.Entity.LawBoard.LawBoardComment;
import Mizut452.learn_law.Model.Entity.LawBoard.LawBoardUpdateReq;
import Mizut452.learn_law.Model.Entity.Login.LoginUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;

import java.util.List;

@Service
public class LawBoardCRUDService {
    @Autowired
    LawBoardMapper lawBoardMapper;

    public void createCommentService(int lawboard_id,
                                     @AuthenticationPrincipal LoginUser loginUser,
                                     @ModelAttribute LawBoardComment lawBoardComment) {
        lawBoardMapper.LAW_BOARD_COMMENT_Sync();
        lawBoardComment.setBoardParent_id(lawboard_id);
        lawBoardComment.setComment_username(loginUser.getUsername());
        lawBoardComment.setComment(lawBoardComment.getComment());

        lawBoardMapper.insertComment(lawBoardComment);

    }

    public void create_threadService(@AuthenticationPrincipal LoginUser loginUser,
                                     @ModelAttribute LawBoard lawBoard) {
        lawBoardMapper.LAW_BOARD_Sync();
        lawBoard.setLawBoard_username(loginUser.getUsername());

        lawBoardMapper.createThread(lawBoard);
    }

    public void lawBoardUpdate(int lawBoard_id,
                               Model model) {
        List<LawBoard> lawBoardList = lawBoardMapper.lawBoardAll();
        LawBoard lawBoard = lawBoardList.get(0);

        LawBoardUpdateReq lawBoardUpdateReq = new LawBoardUpdateReq();
        lawBoardUpdateReq.setLawBoard_id(lawBoard.getLawBoard_id());
        lawBoardUpdateReq.setLawBoard_title(lawBoard.getLawBoard_title());
        lawBoardUpdateReq.setLawBoard_category(lawBoard.getLawBoard_category());
        lawBoardUpdateReq.setLawBoard_mainComment(lawBoard.getLawBoard_mainComment());

        model.addAttribute("LawBoardList", lawBoardUpdateReq);
        model.addAttribute("LawBoard_id", lawBoard_id);
    }

    public void lawBoardDelete(int lawBoard_id,
                               Model model) {
        List<LawBoard> lawBoardList = lawBoardMapper.lawBoardAll();
        LawBoard lawBoard = lawBoardList.get(0);

        LawBoardUpdateReq lawBoardUpdateReq = new LawBoardUpdateReq();
        lawBoardUpdateReq.setLawBoard_id(lawBoard.getLawBoard_id());
        lawBoardUpdateReq.setLawBoard_title(lawBoard.getLawBoard_title());
        lawBoardUpdateReq.setLawBoard_category(lawBoard.getLawBoard_category());
        lawBoardUpdateReq.setLawBoard_mainComment(lawBoard.getLawBoard_mainComment());

        model.addAttribute("LawBoardList", lawBoardUpdateReq);
        model.addAttribute("LawBoard_id", lawBoard_id);
    }

    public void doLawBoardDelete(LawBoardUpdateReq lawBoardUpdateReq) {
        lawBoardMapper.delete(lawBoardUpdateReq);
    }

    public void doLawBoardUpdate(LawBoardUpdateReq lawBoardUpdateReq) {
        lawBoardMapper.update(lawBoardUpdateReq);
    }
}
