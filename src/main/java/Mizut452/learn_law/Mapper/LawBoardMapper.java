package Mizut452.learn_law.Mapper;

import Mizut452.learn_law.Model.Entity.LawBoard.LawBoard;
import Mizut452.learn_law.Model.Entity.LawBoard.LawBoardComment;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface LawBoardMapper {

    @Select("SELECT * FROM LawBoard")
    LawBoard lawBoardAll();

    @Select("SELECT * FROM LawBoard where lawboard_id = #{lawboard_id}")
    LawBoard lawBoardById(@Param("lawboard_id") int lawboard_id);

    @Select("SELECT * FROM LawBoard_comment WHERE boardParent_id = #{lawboard_id}")
    List<LawBoardComment> lawBoardCommentById(@Param("lawboard_id") int lawboard_id);
}
