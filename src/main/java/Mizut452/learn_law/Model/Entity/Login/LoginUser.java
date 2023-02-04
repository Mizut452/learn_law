package Mizut452.learn_law.Model.Entity.Login;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import lombok.Data;
import lombok.EqualsAndHashCode;
import org.hibernate.validator.constraints.Length;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;

@Data
public class LoginUser implements UserDetails {

    private int userId;

    @NotBlank(message = "必須項目です")
    @Email(message = "メールの形式で入力してください。")
    private String email;

    @NotBlank(message = "必須項目です")
    @Length(max=20, message = "20文字以内でお願いします。")
    private String username;

    @NotBlank(message = "必須項目です")
    @Length(max=20, message = "20文字以内でお願いします。")
    private String password;

    private String roleName;

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return AuthorityUtils.createAuthorityList(this.getRoleName());
    }

    @Override
    public String getUsername() {
        return username;
    }

    @Override
    public String getPassword() {
        return password;
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }
}
