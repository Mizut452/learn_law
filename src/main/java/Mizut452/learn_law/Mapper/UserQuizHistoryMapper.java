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

    @Insert("INSERT INTO userQuizHistory(questionAll, civilQuestionAll, criminalQuestionAll, pointAll, pointCivilLaw, pointCriminalLaw) VALUES(#{questionAll}. #{civilQuestionAll}, #{criminalQuestionAll}, #{pointAll}, #{pointCivilLaw}, #{pointCriminalLaw})")
    void insertUserQuizHistory(UserQuizHistory userQuizHistory);

    @Insert("INSERT INTO userQuizHistory(history_userId) VALUES(#{history_userId})")
    void insertNewUserQuizHistory(@Param("history_userId") int history_userId);

    @Update("UPDATE userQuizHistory SET questionAll = #{questionAll}, civilQuestionAll = #{civilQuestionAll}, criminalQuestionAll = #{criminalQuestionAll}, pointAll = #{pointAll}, pointCivilLaw = #{pointCivilLaw}, pointCriminalLaw = #{pointCriminalLaw} WHERE history_userId = #{history_userId}")
    void updateUserQuizHistory(UserQuizHistory usersHistory);
}
