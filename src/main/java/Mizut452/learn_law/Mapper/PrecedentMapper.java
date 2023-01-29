package Mizut452.learn_law.Mapper;

import Mizut452.learn_law.Model.Entity.Precedent;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface PrecedentMapper {
    @Select("SELECT * FROM precedent WHERE category = criminal")
    List<Precedent> precedentCriminalList();

    @Select("SELECT * FROM precedent WHERE category = civil")
    List<Precedent> precedentCivilList();

    @Select("SELECT * FROM precedent WHERE category = copyright")
    List<Precedent> precedentCopyrightList();

    @Select("SELECT precedent_id, precedent_title, precedent_subtitle, precedent_number, precedent_category")
    List<Precedent> precedentList();

    @Insert("INSERT INTO precedent(precedent_title, precedent_category, precedent_number, " +
            "precedent_subtitle, precedent_overview," +
            " precedent_plClaim, precedent_deClaim, precedent_judgement) " +
            "VALUES(#{precedent_title}, #{precedent_category}, #{precedent_number}, " +
            "#{precedent_subtitle}, #{precedent_overview}, #{precedent_plClaim}," +
            " #{precedent_deClaim}, #{precedent_judgement})")
    void createPrecedent(Precedent precedent);
}
