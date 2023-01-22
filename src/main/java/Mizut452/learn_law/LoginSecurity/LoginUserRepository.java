package Mizut452.learn_law.LoginSecurity;

import Mizut452.learn_law.Mapper.LoginUserMapper;
import Mizut452.learn_law.Model.Entity.LoginUser;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
@RequiredArgsConstructor
public class LoginUserRepository {
    private final LoginUserMapper loginUserMapper;

    public List<LoginUserDetails> selectAll() {
        return loginUserMapper.selectAll();
    }

    public LoginUserDetails findByUsername(String username) {
        return loginUserMapper.findByUsername(username);
    }

    public Optional<LoginUser> findByUsernameWithRoles(String username) {
        LoginUser loginUser = loginUserMapper.findByUsernameWithRoles(username);
        return Optional.ofNullable(loginUser);
    }
}
