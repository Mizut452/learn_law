package Mizut452.learn_law.Mapper;


import Mizut452.learn_law.Model.Entity.Quiz;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface QuizMapper {

    @Select("SELECT * FROM quiz WHERE quizId = #{quizId}")
    List<Quiz> selectQuizAll(int quizId);

    @Select("SELECT quizId FROM quiz")
    List<Quiz> selectQuizIdAll();

    @Select("SELECT quizCategory FROM quiz WHERE quizId = #{quizId}")
    String selectCategory(@Param("quizId") int quizId);
}
