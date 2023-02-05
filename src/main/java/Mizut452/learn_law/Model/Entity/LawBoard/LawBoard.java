package Mizut452.learn_law.Model.Entity.LawBoard;

import lombok.Data;
import org.hibernate.validator.constraints.Length;

@Data
public class LawBoard {
    private int lawBoard_id;

    private String lawBoard_username;

    private String lawBoard_category;

    @Length(max=50, message = "50文字以内で入力してください")
    private String lawBoard_title;

    @Length(max=300, message = "300文字以内で入力してください")
    private String lawBoard_mainComment;

    private String lawBoard_comment;

    private String lawBoard_time;
}
