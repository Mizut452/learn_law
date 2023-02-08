package Mizut452.learn_law.Model.Entity.Quiz;


import jakarta.validation.constraints.NotBlank;
import lombok.Data;

@Data
public class Quiz {
    private int quizId;

    @NotBlank(message = "必須項目です")
    private String quizQuestionSent;

    private int quizRightOrBad;

    @NotBlank(message = "必須項目です")
    private String quizCommentary;

    private int quizUsersAnswer;

    @NotBlank(message = "必須項目です")
    private String quizCategory;

    private String quizAuthor;

    private int quizGood;
    private int quizBad;
}
