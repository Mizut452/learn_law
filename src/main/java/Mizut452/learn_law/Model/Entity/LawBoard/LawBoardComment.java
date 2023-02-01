package Mizut452.learn_law.Model.Entity.LawBoard;

import lombok.Data;

@Data
public class LawBoardComment {
    private int boardParent_id;
    private int comment_id;
    private String comment;
    private String comment_time;
    private String comment_username;
}
