package Mizut452.learn_law.Model.Entity.Precedent;

import lombok.Data;

@Data
public class PrecedentUpdate {
    private int PreUpdate_id;
    private String PreUpdate_title;
    private String PreUpdate_category;
    private String PreUpdate_number;
    private String PreUpdate_subtitle;
    private String PreUpdate_overview;
    private String PreUpdate_claim;
    private String PreUpdate_judgement;
}
