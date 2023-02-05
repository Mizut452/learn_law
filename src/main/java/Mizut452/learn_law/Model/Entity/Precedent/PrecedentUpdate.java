package Mizut452.learn_law.Model.Entity.Precedent;

import jakarta.validation.constraints.NotBlank;
import lombok.Data;

@Data
public class PrecedentUpdate {

    @NotBlank(message = "必須項目です")
    private int PreUpdate_id;

    @NotBlank(message = "必須項目です")
    private String PreUpdate_title;

    @NotBlank(message = "必須項目です")
    private String PreUpdate_category;

    @NotBlank(message = "必須項目です")
    private String PreUpdate_number;

    @NotBlank(message = "必須項目です")
    private String PreUpdate_subtitle;

    @NotBlank(message = "必須項目です")
    private String PreUpdate_overview;

    @NotBlank(message = "必須項目です")
    private String PreUpdate_claim;

    @NotBlank(message = "必須項目です")
    private String PreUpdate_judgement;
}
