package Mizut452.learn_law.Model.Entity;

import lombok.Data;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;
import java.util.List;

@Data
public class LoginUser {
    private int userId;
    private String email;
    private String username;
    private String password;
    private List<String> roleList;
}
