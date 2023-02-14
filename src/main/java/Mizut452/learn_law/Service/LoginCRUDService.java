package Mizut452.learn_law.Service;

import Mizut452.learn_law.Mapper.LoginUserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class LoginCRUDService {
    @Autowired
    LoginUserMapper loginUserMapper;

    public void updateUserPageService(int userId) {
        loginUserMapper.update(userId);
    }

    public void updateUserRole(String roleName,
                               int userId) {
        loginUserMapper.updateUserRole(roleName, userId);
    }
}
