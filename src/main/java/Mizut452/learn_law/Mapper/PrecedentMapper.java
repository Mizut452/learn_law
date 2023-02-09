package Mizut452.learn_law.Mapper;

import Mizut452.learn_law.Model.Entity.Precedent.Precedent;
import Mizut452.learn_law.Model.Entity.Precedent.PrecedentUpdate;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface PrecedentMapper {

    @Select("SELECT SETVAL('Precedent_precedent_id_seq', (SELECT MAX(precedent_id) FROM Precedent))")
    Precedent PRECEDENT_SYNC();

    @Select("SELECT * FROM precedent WHERE precedent_category = '刑法'")
    List<Precedent> precedentCriminalList();

    @Select("SELECT * FROM precedent WHERE precedent_category = '民法'")
    List<Precedent> precedentCivilList();

    @Select("SELECT * FROM precedent WHERE precedent_category = '著作権法'")
    List<Precedent> precedentCopyrightList();

    @Select("SELECT * FROM precedent WHERE precedent_id = #{precedent_id}")
    Precedent findByPrecedentId(int precedent_id);

    @Select("SELECT precedent_id, precedent_title, precedent_subtitle, precedent_number, precedent_category FROM precedent")
    List<Precedent> precedentList();

    @Insert("INSERT INTO precedent(precedent_title, precedent_category, precedent_number, precedent_subtitle, precedent_overview, precedent_claim, precedent_judgement) VALUES(#{precedent_title}, #{precedent_category}, #{precedent_number}, #{precedent_subtitle}, #{precedent_overview}, #{precedent_claim}, #{precedent_judgement})")
    void createPrecedent(Precedent precedent);

    @Update("UPDATE precedent SET precedent_title = #{precedent_title}, precedent_category = #{precedent_category}, precedent_number = #{precedent_number}, precedent_subtitle = #{precedent_subtitle}, precedent_overview = #{precedent_overview}, precedent_claim = #{precedent_claim}, precedent_judgement = #{precedent_judgement} WHERE precedent_id = #{precedent_id}")
    void updatePrecedent(PrecedentUpdate precedentUpdate);

    @Delete("DELETE FROM precedent WHERE precedent_id = #{precedent_id}")
    void delete(int precedent_id);
}
