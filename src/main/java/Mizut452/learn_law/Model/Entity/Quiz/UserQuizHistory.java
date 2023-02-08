package Mizut452.learn_law.Model.Entity.Quiz;

import lombok.Data;

@Data
public class UserQuizHistory {
    //LoginUserから取得
    private int history_userId;
    private String history_username;
    //挑戦した問題数
    private int questionAll;
    //挑戦した民法問題数
    private int civilQuestionAll;
    //挑戦した刑法問題数
    private int criminalQuestionAll;
    //挑戦した著作権法問題数
    private int copyrightQuestionAll;
    //正解した問題数
    private int pointAll;
    //正解した民法の問題
    private int pointCivilLaw;
    //正解した刑法問題
    private int pointCriminalLaw;
    //正解した著作権法問題
    private int pointCopyrightLaw;
}
