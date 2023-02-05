package Mizut452.learn_law.Model.Entity.Quiz;

import jakarta.validation.constraints.NotBlank;
import lombok.Data;

@Data
public class QuizUpdateReq {
    private int quizId;

    @NotBlank(message = "必須項目です")
    private String quizQuestionSent;

    @NotBlank(message = "必須項目です")
    private int quizRightOrBad;

    @NotBlank(message = "必須項目です")
    private String quizCommentary;

    @NotBlank(message = "必須項目です")
    private String quizCategory;
    private String quizAuthor;
}
