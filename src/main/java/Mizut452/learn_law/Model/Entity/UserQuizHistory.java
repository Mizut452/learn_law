package Mizut452.learn_law.Model.Entity;

import lombok.Data;

@Data
public class UserQuizHistory {
    //LoginUserから取得
    private int userId;
    //挑戦した問題数
    private int questionAll;
    //挑戦した民法問題数
    private int civilQuestionAll;
    //挑戦した刑法問題数
    private int criminalQuestionAll;
    //正解した問題数
    private int pointAll;
    //正解した民法の問題
    private int pointCivilLaw;
    //正解した刑法問題
    private int pointCriminalLaw;

}
