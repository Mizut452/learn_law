package Mizut452.learn_law.Model.Entity.LawBoard;

import lombok.Data;

@Data
public class LawBoard {
    private int lawBoard_id;
    private String lawBoard_username;
    private String lawBoard_category;
    private String lawBoard_title;
    private String lawBoard_mainComment;
    private String lawBoard_comment;
    private String lawBoard_time;
}
