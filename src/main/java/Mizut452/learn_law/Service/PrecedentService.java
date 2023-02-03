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

    public void findPrecedentCriminalService(Model model) {
        List<Precedent> precedentList = precedentMapper.findCriminal();
        model.addAttribute("PrecedentList", precedentList);
    }

    public void findPrecedentCivilService(Model model) {
        List<Precedent> precedentList = precedentMapper.findCivil();
        model.addAttribute("PrecedentList", precedentList);
    }

    public void findPrecedentCopyright(Model model) {
        List<Precedent> precedentList = precedentMapper.findCopyright();
        model.addAttribute("PrecedentList", precedentList);
    }

    public void findPrecedentByPrecedentId(int precedent_id,
                                           Model model) {
        Precedent precedent = precedentMapper.findByPrecedentId(precedent_id);

        model.addAttribute("Pre_title", precedent.getPrecedent_title());
        model.addAttribute("Pre_category", precedent.getPrecedent_category());
        model.addAttribute("Pre_number", precedent.getPrecedent_number());
        model.addAttribute("Pre_subtitle", precedent.getPrecedent_subtitle());
        model.addAttribute("Pre_overview", precedent.getPrecedent_overview());
        model.addAttribute("Pre_claim", precedent.getPrecedent_claim());
        model.addAttribute("Pre_judgement", precedent.getPrecedent_judgement());
        model.addAttribute("precedent_id", precedent_id);
    }

    public void findPrecedentList(Model model) {
        model.addAttribute("PrecedentList", precedentMapper.precedentList());
    }

    public void createPrecedent(@ModelAttribute Precedent precedent) {
        precedent.setPrecedent_title(precedent.getPrecedent_title());
        precedent.setPrecedent_category(precedent.getPrecedent_category());
        precedent.setPrecedent_number(precedent.getPrecedent_number());
        precedent.setPrecedent_subtitle(precedent.getPrecedent_subtitle());
        precedent.setPrecedent_overview(precedent.getPrecedent_overview());
        precedent.setPrecedent_claim(precedent.getPrecedent_claim());
        precedent.setPrecedent_judgement(precedent.getPrecedent_judgement());

        precedentMapper.createPrecedent(precedent);
    }


}
