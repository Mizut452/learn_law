package Mizut452.learn_law.Mapper;


import Mizut452.learn_law.Model.Entity.Quiz;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface QuizMapper {

    @Select("SELECT * FROM quiz WHERE quizId = #{quizId}")
    List<Quiz> selectQuizAll(int quizId);

    @Select("SELECT quizId FROM quiz")
    List<Quiz> selectQuizIdAll();

    @Select("SELECT quizRightOrBad FROM quiz")
    List<Quiz> selectQuizRightOrBadAll();

    @Select("SELECT quizCommentary FROM quiz")
    List<Quiz> selectQuizCommentaryAll();

    @Select("SELECT quizQuestionSent FROM quiz where quizId = #{quizId}")
    List<Quiz> selectQuestionAll(int randomInt);

    @Select("SELECT * FROM quiz where quizId = #{quizId}")
    List<Quiz> selectRandomQuizAll();
}
