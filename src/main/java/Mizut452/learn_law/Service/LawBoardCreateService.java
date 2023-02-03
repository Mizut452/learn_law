package Mizut452.learn_law.Service;

import Mizut452.learn_law.Mapper.LawBoardMapper;
import Mizut452.learn_law.Model.Entity.LawBoard.LawBoard;
import Mizut452.learn_law.Model.Entity.Login.LoginUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.ModelAttribute;

@Service
public class LawBoardCreateService {
    @Autowired
    LawBoardMapper lawBoardMapper;

    public void create_threadService(@AuthenticationPrincipal LoginUser loginUser,
                                     @ModelAttribute LawBoard lawBoard) {
        lawBoard.setLawBoard_username(loginUser.getUsername());
        lawBoard.setLawBoard_title(lawBoard.getLawBoard_title());
        lawBoard.setLawBoard_category(lawBoard.getLawBoard_category());
        lawBoard.setLawBoard_mainComment(lawBoard.getLawBoard_mainComment());

        lawBoardMapper.createThread(lawBoard);
    }
}
