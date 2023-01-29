package Mizut452.learn_law.Model.Entity;

import lombok.Data;

@Data
public class Precedent {
    private int precedent_id;
    //事件名
    private String precedent_title;
    //法律のカテゴリー
    private String precedent_category;
    private String precedent_number;
    //小タイトル
    private String precedent_subtitle;
    //事実の概要
    private String precedent_overview;
    //原告側の主張(plaintiff = 原告)
    private String precedent_plClaim;
    //被告側の主張(defendant = 被告)
    private String precedent_deClaim;
    //裁判所の判断
    private String precedent_judgement;
}
