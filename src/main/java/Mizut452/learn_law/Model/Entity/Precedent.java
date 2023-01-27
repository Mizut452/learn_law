package Mizut452.learn_law.Model.Entity;

import lombok.Data;

@Data
public class Precedent {
    private int precedent_id;
    private String precedent_title;
    private String precedent_sTitle;
    private String precedent_overview;
    //原告側の主張(plaintiff = 原告)
    private String precedent_plClaim;
    //被告側の主張(defendant = 被告)
    private String precedent_deClaim;
    //裁判所の判断
    private String precedent_judgement;
}
