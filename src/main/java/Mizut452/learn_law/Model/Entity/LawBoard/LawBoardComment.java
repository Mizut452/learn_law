package Mizut452.learn_law.Model.Entity.LawBoard;

import jakarta.validation.constraints.NotBlank;
import lombok.Data;
import org.hibernate.validator.constraints.Length;

@Data
public class LawBoardComment {
    private int boardParent_id;
    private int comment_id;

    @NotBlank(message = "コメントを入力してください")
    @Length(max=300, message = "300文字以内で入力してください")
    private String comment;
    private String comment_time;
    private String comment_username;
}
