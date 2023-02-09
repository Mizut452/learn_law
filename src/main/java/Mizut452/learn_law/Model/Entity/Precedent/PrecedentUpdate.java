package Mizut452.learn_law.Model.Entity.Precedent;

import jakarta.validation.constraints.NotBlank;
import lombok.Data;

@Data
public class PrecedentUpdate {

    @NotBlank(message = "必須項目です")
    private int precedent_id;

    @NotBlank(message = "必須項目です")
    private String precedent_title;

    @NotBlank(message = "必須項目です")
    private String precedent_category;

    @NotBlank(message = "必須項目です")
    private String precedent_number;

    @NotBlank(message = "必須項目です")
    private String precedent_subtitle;

    @NotBlank(message = "必須項目です")
    private String precedent_overview;

    @NotBlank(message = "必須項目です")
    private String precedent_claim;

    @NotBlank(message = "必須項目です")
    private String precedent_judgement;
}
