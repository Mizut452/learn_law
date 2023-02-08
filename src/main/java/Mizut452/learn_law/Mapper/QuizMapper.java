package Mizut452.learn_law.Mapper;


import Mizut452.learn_law.Model.Entity.Quiz.Quiz;
import Mizut452.learn_law.Model.Entity.Quiz.QuizUpdateReq;
import lombok.Data;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface QuizMapper {

    @Select("SELECT SETVAL('Quiz_quizId_seq', (SELECT MAX(quizId) FROM Quiz))")
    Quiz QUIZ_SYNC();

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

    @Delete("DELETE FROM quiz WHERE quizId = #{quizId}")
    void delete(QuizUpdateReq quizUpdateReq);

    @Insert("INSERT INTO Quiz(quizQuestionSent, quizRightOrBad, quizCommentary," +
            " quizCategory, quizAuthor) VALUES (#{quizQuestionSent}, #{quizRightOrBad}, #{quizCommentary}, #{quizCategory}, #{quizAuthor})")
    void preQuizToQuiz(Quiz quiz);
}
