package Mizut452.learn_law.Model.Entity.Precedent;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Data
public class Precedent {
    private int precedent_id;

    @NotBlank(message = "必須項目です")
    //事件名
    private String precedent_title;

    @NotBlank(message = "必須項目です")
    //法律のカテゴリー
    private String precedent_category;

    @NotBlank(message = "必須項目です")
    //事件番号
    private String precedent_number;

    @NotBlank(message = "必須項目です")
    //小タイトル
    private String precedent_subtitle;

    @NotBlank(message = "必須項目です")
    //事実の概要
    private String precedent_overview;

    @NotBlank(message = "必須項目です")
    //両者の主張
    private String precedent_claim;

    @NotBlank(message = "必須項目です")
    //裁判所の判断
    private String precedent_judgement;
}
