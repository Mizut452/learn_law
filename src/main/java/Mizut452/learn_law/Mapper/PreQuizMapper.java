package Mizut452.learn_law.Mapper;

import Mizut452.learn_law.Model.Entity.Quiz.Quiz;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface PreQuizMapper {

    @Select("SELECT SETVAL('PreQuiz_quizId_seq', (SELECT MAX(quizId) FROM PreQuiz))")
    Quiz PREQUIZ_SYNC();
    @Select("SELECT * FROM PreQuiz WHERE quizId = #{quizId}")
    Quiz selectPreQuizById(int quizId);

    @Select("SELECT * FROM PreQuiz")
    List<Quiz> selectPreQuiz();

    @Update("UPDATE PreQuiz SET quizGood = #{quizGood} " +
            "WHERE quizId = #{quizId}")
    void addGood(@Param("quizGood") int quizGood, @Param("quizId")int quizId);

    @Insert("INSERT INTO PreQuiz(quizQuestionSent, quizRightOrBad, quizCommentary," +
            "quizCategory, quizAuthor) VALUES (#{quiz.quizQuestionSent}, #{quiz.quizRightOrBad}, #{quiz.quizCommentary}, #{quiz.quizCategory}, #{username})")
    void insertPreQuiz(@Param("quiz") Quiz quiz, @Param("username") String username);
}
