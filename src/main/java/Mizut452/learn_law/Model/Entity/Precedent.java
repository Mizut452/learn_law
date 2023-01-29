package Mizut452.learn_law.Model.Entity;

import lombok.Data;

@Data
public class Precedent {
    private int precedent_id;
    //事件名
    private String precedent_title;
    //法律のカテゴリー
    private String precedent_category;
    //事件番号
    private String precedent_number;
    //小タイトル
    private String precedent_subtitle;
    //事実の概要
    private String precedent_overview;
    //両者の主張
    private String precedent_claim;
    //裁判所の判断
    private String precedent_judgement;
}
