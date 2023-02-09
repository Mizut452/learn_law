package Mizut452.learn_law.Service;

import Mizut452.learn_law.Mapper.PrecedentMapper;
import Mizut452.learn_law.Model.Entity.Precedent.Precedent;
import Mizut452.learn_law.Model.Entity.Precedent.PrecedentUpdate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;

import java.util.List;

@Service
public class PrecedentCRUDService {

    @Autowired
    PrecedentMapper precedentMapper;

    public void precedentUpdateDelete(int precedent_id,
                                Model model) {
       Precedent precedent = precedentMapper.findByPrecedentId(precedent_id);

        model.addAttribute("Precedent_Id", precedent_id);
        model.addAttribute("precedent", precedent);
    }

    public void precedentUpdate(int precedent_id,
                                Model model) {
        List<Precedent> precedentList = precedentMapper.precedentList();
        Precedent precedent = precedentList.get(0);

        PrecedentUpdate precedentUpdate = new PrecedentUpdate();
        precedentUpdate.setPrecedent_id(precedent.getPrecedent_id());
        precedentUpdate.setPrecedent_title(precedent.getPrecedent_title());
        precedentUpdate.setPrecedent_category(precedent.getPrecedent_category());
        precedentUpdate.setPrecedent_number(precedent.getPrecedent_number());
        precedentUpdate.setPrecedent_subtitle(precedent.getPrecedent_subtitle());
        precedentUpdate.setPrecedent_overview(precedent.getPrecedent_overview());
        precedentUpdate.setPrecedent_claim(precedent.getPrecedent_claim());
        precedentUpdate.setPrecedent_judgement(precedent.getPrecedent_judgement());

        model.addAttribute("precedentList", precedentUpdate);
        model.addAttribute("Precedent_Id", precedent_id);
    }

    public void doPrecedentUpdate(PrecedentUpdate precedentUpdate) {
        precedentMapper.updatePrecedent(precedentUpdate);
    }

    public void doPrecedentDelete(int precedent_id) {
        precedentMapper.delete(precedent_id);
    }

    public void changePrecedentCivilList(Model model) {
        precedentMapper.precedentCivilList();
        model.addAttribute("PrecedentList", precedentMapper.precedentCivilList());
    }

    public void changePrecedentCriminalList(Model model) {
        precedentMapper.precedentCriminalList();
        model.addAttribute("PrecedentList", precedentMapper.precedentCriminalList());
    }

    public void changePrecedentCopyrightList(Model model) {
        model.addAttribute("PrecedentList", precedentMapper.precedentCopyrightList());
    }
}

