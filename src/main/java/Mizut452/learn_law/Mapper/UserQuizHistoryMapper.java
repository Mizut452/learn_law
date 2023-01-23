package Mizut452.learn_law.Mapper;

import Mizut452.learn_law.Model.Entity.UserQuizHistory;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface UserQuizHistoryMapper {

    @Select("SELECT * FROM userQuizHistory WHERE userId = #{userId}")
    UserQuizHistory quizHistoryMapperList(@Param("userId") int userId);
}
