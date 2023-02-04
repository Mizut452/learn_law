package Mizut452.learn_law.Service;

import Mizut452.learn_law.Mapper.PrecedentMapper;
import Mizut452.learn_law.Model.Entity.Precedent.Precedent;
import Mizut452.learn_law.Model.Entity.Precedent.PrecedentUpdate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;

import java.util.List;

@Service
public class PrecedentCRUDService {

    @Autowired
    PrecedentMapper precedentMapper;

    public void precedentUpdateDelete(int precedent_id,
                                Model model) {
        List<Precedent> precedentList = precedentMapper.precedentAllList();
        Precedent precedent = precedentList.get(0);

        PrecedentUpdate precedentUpdate = new PrecedentUpdate();
        precedentUpdate.setPreUpdate_id(precedent.getPrecedent_id());
        precedentUpdate.setPreUpdate_title(precedent.getPrecedent_title());
        precedentUpdate.setPreUpdate_number(precedent.getPrecedent_number());
        precedentUpdate.setPreUpdate_category(precedent.getPrecedent_category());
        precedentUpdate.setPreUpdate_subtitle(precedent.getPrecedent_subtitle());
        precedentUpdate.setPreUpdate_overview(precedent.getPrecedent_overview());
        precedentUpdate.setPreUpdate_claim(precedent.getPrecedent_claim());
        precedentUpdate.setPreUpdate_judgement(precedent.getPrecedent_judgement());

        model.addAttribute("PrecedentList", precedentUpdate);
        model.addAttribute("Precedent_Id", precedent_id);
    }

    public void doPrecedentUpdate(PrecedentUpdate precedentUpdate) {
        precedentMapper.updatePrecedent(precedentUpdate);
    }

    public void doPrecedentDelete(PrecedentUpdate precedentUpdate) {
        precedentMapper.delete(precedentUpdate);
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

