package Mizut452.learn_law.Model.Entity;


import lombok.Data;

@Data
public class Quiz {
    private int quizId;
    private String quizQuestionSent;
    private int quizRightOrBad;
    private String quizCommentary;
    private int quizUsersAnswer;
    private String quizCategory;
}
