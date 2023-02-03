package Mizut452.learn_law.Model.Entity.Quiz;

import lombok.Data;

@Data
public class QuizUpdateReq {
    private int quizId;
    private String quizQuestionSent;
    private int quizRightOrBad;
    private String quizCommentary;
    private String quizCategory;
    private String quizAuthor;
}
