package Mizut452.learn_law.Mapper;


import Mizut452.learn_law.Model.Entity.Quiz.Quiz;
import Mizut452.learn_law.Model.Entity.Quiz.QuizUpdateReq;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import java.util.List;

@Mapper
public interface QuizMapper {

    @Select("SELECT * FROM quiz")
    List<Quiz> selectQuizAll();

    @Select("SELECT * FROM quiz WHERE quizId = #{quizId}")
    List<Quiz> selectQuizAllByQuizId(int quizId);

    @Select("SELECT quizId FROM quiz")
    List<Quiz> selectQuizIdAll();

    @Select("SELECT quizCategory FROM quiz WHERE quizId = #{quizId}")
    String selectCategory(@Param("quizId") int quizId);

    @Select("SELECT * FROM quiz WHERE quizId = #{quizId}")
    Quiz selectQuizByQuizId(@Param("quizId") int quizId);

    @Update("UPDATE quiz SET quizQuestionSent = #{quizQuestionSent}, quizRightOrBad = #{quizRightOrBad}," +
            "quizCommentary = #{quizCommentary}, quizCategory = #{quizCategory} WHERE quizId = #{quizId}")
    void update(QuizUpdateReq quizUpdateReq);
}
