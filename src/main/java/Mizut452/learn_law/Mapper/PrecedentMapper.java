package Mizut452.learn_law.Mapper;

import Mizut452.learn_law.Model.Entity.Precedent;
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
}
