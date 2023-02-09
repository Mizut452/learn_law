package Mizut452.learn_law.Mapper;

import Mizut452.learn_law.Model.Entity.Quiz.UserQuizHistory;
import org.apache.ibatis.annotations.*;
import org.springframework.security.core.userdetails.User;

import java.util.List;

@Mapper
public interface UserQuizHistoryMapper {

    @Select("SELECT SETVAL('userQuizHistory_history_userId_seq', (SELECT MAX() FROM userQuizHistory))")
    UserQuizHistory USER_QUIZ_HISTORY_SYNC();

    @Select("SELECT * FROM userQuizHistory WHERE history_userId = #{history_userId}")
    UserQuizHistory quizHistoryMapperList(@Param("history_userId") int history_userId);

    @Select("SELECT * FROM userQuizHistory WHERE history_userId = #{history_userId}")
    UserQuizHistory usersQuizHistoryList(@Param("history_userId") int history_userId);

    @Select("SELECT history_username, pointAll FROM userQuizHistory WHERE pointAll > 0 ORDER BY pointAll DESC OFFSET 0 LIMIT 5")
    List<UserQuizHistory> usersQuizRank();

    @Insert("INSERT INTO userQuizHistory(history_userId, history_username) VALUES(#{history_userId}, #{history_username})")
    void insertNewUserQuizHistory(@Param("history_userId") int history_userId, @Param("history_username") String history_username);

    @Update("UPDATE userQuizHistory SET questionAll = #{questionAll}, civilQuestionAll = #{civilQuestionAll}, criminalQuestionAll = #{criminalQuestionAll}, copyrightQuestionAll = #{copyrightQuestionAll}, pointAll = #{pointAll}, pointCivilLaw = #{pointCivilLaw}, pointCriminalLaw = #{pointCriminalLaw}, pointCopyrightLaw = #{pointCopyrightLaw} WHERE history_userId = #{history_userId}")
    void updateUserQuizHistory(UserQuizHistory usersHistory);
}
