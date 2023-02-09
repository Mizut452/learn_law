package Mizut452.learn_law.Mapper;

import Mizut452.learn_law.Model.Entity.LawBoard.LawBoard;
import Mizut452.learn_law.Model.Entity.LawBoard.LawBoardComment;
import Mizut452.learn_law.Model.Entity.LawBoard.LawBoardUpdateReq;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface LawBoardMapper {

    //プライマリーキーと自動採番を同期させる
    @Select("SELECT SETVAL('LawBoard_lawboard_id_seq', (SELECT MAX(lawboard_id) FROM LawBoard))")
    LawBoard LAW_BOARD_Sync();

    @Select("SELECT * FROM LawBoard")
    List<LawBoard> lawBoardAll();

    @Select("SELECT * FROM LawBoard where lawboard_id = #{lawboard_id}")
    LawBoard lawBoardById(@Param("lawboard_id") int lawboard_id);

    //コメントプライマリーキーと自動採番を同期させる
    @Select("SELECT SETVAL('LawBoard_comment_comment_id_seq', (SELECT MAX(comment_id) FROM LawBoard_comment))")
    LawBoardComment LAW_BOARD_COMMENT_Sync();

    @Select("SELECT * FROM LawBoard_comment WHERE boardParent_id = #{lawboard_id}")
    List<LawBoardComment> lawBoardCommentById(@Param("lawboard_id") int lawboard_id);

    @Insert("INSERT INTO LawBoard_comment(boardParent_id, comment, comment_time, comment_username) " +
            "VALUES(#{boardParent_id}, #{comment}, CURRENT_TIMESTAMP, #{comment_username})")
    void insertComment(LawBoardComment lawBoardComment);

    @Insert("INSERT INTO LawBoard(lawBoard_username, lawBoard_category, lawBoard_title, lawBoard_mainComment, lawBoard_time)" +
            "VALUES(#{lawBoard_username}, #{lawBoard_category}, #{lawBoard_title}, #{lawBoard_mainComment}, CURRENT_TIMESTAMP)")
    void createThread(LawBoard lawBoard);

    @Update("UPDATE LawBoard SET lawBoard_title = #{lawBoard_title}, lawBoard_category = #{lawBoard_category} WHERE lawBoard_id = #{lawBoard_id}")
    void update(LawBoardUpdateReq lawBoardUpdateReq);

    @Delete("DELETE FROM LawBoard WHERE lawBoard_id = #{lawBoard_id}")
    void delete(LawBoardUpdateReq lawBoardUpdateReq);
}
