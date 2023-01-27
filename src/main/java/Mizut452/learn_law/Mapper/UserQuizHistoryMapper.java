package Mizut452.learn_law.Mapper;

import Mizut452.learn_law.Model.Entity.UserQuizHistory;
import org.apache.ibatis.annotations.*;
import org.springframework.security.core.userdetails.User;

import java.util.List;

@Mapper
public interface UserQuizHistoryMapper {

    @Select("SELECT * FROM userQuizHistory WHERE history_userId = #{history_userId}")
    UserQuizHistory quizHistoryMapperList(@Param("history_userId") int history_userId);

    @Select("SELECT * FROM userQuizHistory WHERE history_userId = #{history_userId}")
    UserQuizHistory usersQuizHistoryList(@Param("history_userId") int history_userId);

    @Select("SELECT history_username, pointAll FROM userQuizHistory WHERE pointAll > 0 ORDER BY pointAll DESC LIMIT 0, 5")
    List<UserQuizHistory> usersQuizRank();

    @Insert("INSERT INTO userQuizHistory(history_userId, history_username) VALUES(#{history_userId}, #{history_username})")
    void insertNewUserQuizHistory(@Param("history_userId") int history_userId, @Param("history_username") String history_username);

    @Update("UPDATE userQuizHistory SET questionAll = #{questionAll}, civilQuestionAll = #{civilQuestionAll}, criminalQuestionAll = #{criminalQuestionAll}, pointAll = #{pointAll}, pointCivilLaw = #{pointCivilLaw}, pointCriminalLaw = #{pointCriminalLaw} WHERE history_userId = #{history_userId}")
    void updateUserQuizHistory(UserQuizHistory usersHistory);
}
