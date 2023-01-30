package Mizut452.learn_law.Mapper;

import Mizut452.learn_law.Model.Entity.LawBoard.LawBoard;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

@Mapper
public interface LawBoardMapper {

    @Select("SELECT * FROM LawBoard")
    LawBoard lawBoardAll();

    @Select("SELECT * FROM LawBoard where lawBoard_id = #{lawBoard_id}")
    LawBoard lawBoardById();
}
