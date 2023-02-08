package Mizut452.learn_law.Service;

import Mizut452.learn_law.Mapper.PrecedentMapper;
import Mizut452.learn_law.Model.Entity.Login.LoginUser;
import Mizut452.learn_law.Model.Entity.Precedent.Precedent;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;

import java.util.List;

@Service
public class PrecedentService {

    @Autowired
    PrecedentMapper precedentMapper;

    public void addLoginUserMenu(@AuthenticationPrincipal LoginUser loginUser,
                                 Model model) {
        if (loginUser != null) {
            model.addAttribute("UserId", loginUser.getUserId());
        }
    }

    public void findPrecedentByPrecedentId(int precedent_id,
                                           Model model) {
        Precedent precedent = precedentMapper.findByPrecedentId(precedent_id);

        model.addAttribute("precedent", precedent);
    }

    public void findPrecedentList(Model model) {
        model.addAttribute("PrecedentList", precedentMapper.precedentList());
    }

    public void createPrecedent(@ModelAttribute Precedent precedent) {
        precedentMapper.PRECEDENT_SYNC();
        precedentMapper.createPrecedent(precedent);
    }


}
