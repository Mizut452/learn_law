package Mizut452.learn_law.Model.Entity.LawBoard;

import jakarta.validation.constraints.Max;
import lombok.Data;
import org.hibernate.validator.constraints.Length;

@Data
public class LawBoard {
    private int lawBoard_id;

    private String lawBoard_username;

    private String lawBoard_category;

    @Length(max=50)
    private String lawBoard_title;

    @Length(max=300)
    private String lawBoard_mainComment;

    private String lawBoard_comment;

    private String lawBoard_time;
}
