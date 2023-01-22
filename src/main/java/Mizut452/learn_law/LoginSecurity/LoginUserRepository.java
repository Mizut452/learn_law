package Mizut452.learn_law.LoginSecurity;

import Mizut452.learn_law.Mapper.LoginUserMapper;
import Mizut452.learn_law.Model.Entity.LoginUser;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@RequiredArgsConstructor
public class LoginUserRepository {
    private final LoginUserMapper loginUserMapper;

    public List<LoginUser> selectAll() {
        return loginUserMapper.selectAll();
    }

    public List<LoginUser> findByUsername(String username) {
        return loginUserMapper.findByUsername(username);
    }
}
