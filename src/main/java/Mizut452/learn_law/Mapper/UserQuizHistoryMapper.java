package Mizut452.learn_law.Mapper;

import Mizut452.learn_law.Model.Entity.UserQuizHistory;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface UserQuizHistoryMapper {

    @Select("SELECT * FROM userQuizHistory WHERE history_userId = #{history_userId}")
    UserQuizHistory quizHistoryMapperList(@Param("history_userId") int history_userId);

    @Select("SELECT * FROM userQuizHistory WHERE history_userId = #{history_userId}")
    UserQuizHistory usersQuizHistoryList(@Param("history_userId") int history_userId);

    @Insert("INSERT INTO userQuizHistory(questionAll, civilQuestionAll, criminalQuestionAll, pointAll, pointCivilLaw, pointCriminalLaw) VALUES(#{questionAll}. #{civilQuestionAll}, #{criminalQuestionAll}, #{pointAll}, #{pointCivilLaw}. #{pointCriminalLaw})")
    UserQuizHistory insertUserQuizHistory(UserQuizHistory userQuizHistory);
}
