package Mizut452.learn_law.Model.Entity;

import lombok.Data;
import java.util.List;

@Data
public class LoginUser {
    private int userId;
    private String email;
    private String username;
    private String password;
    private List<String> roleList;
}
